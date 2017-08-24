package org.billFarber.charts.dataGenerator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.DocumentMetadataHandle.DocumentCollections;
import com.marklogic.client.io.StringHandle;

import freemarker.template.TemplateException;

public class GenerateUred {

    private static final Logger logger = LoggerFactory.getLogger(GenerateUred.class);

    private static int NUM_URED_RECORDS_TO_GENERATE = 10;

    public static void main(String[] args)
            throws IOException, TemplateException {
        logger.info("Begin Test");
        DatabaseClient client = MarkLogicClient.getClient();
        FreemarkerClient freemarker = new FreemarkerClient();

        DocumentMetadataHandle metaHandle = new DocumentMetadataHandle();
        DocumentCollections collections = metaHandle.getCollections();
        collections.add("ured");

        for (int i = 0; i < NUM_URED_RECORDS_TO_GENERATE; i++) {
            Map<String, Object> root = new HashMap<>();
            int randomStateNum = ThreadLocalRandom.current().nextInt(0, 49 + 1);
            int randomAmount = ThreadLocalRandom.current().nextInt(0, 999999999);
            
            root.put("state", State.values()[randomStateNum].abbreviation());
            root.put("amount", ""+randomAmount);

            freemarker.loadTemplate("uredTemplate.ftlh");
            String newURED = freemarker.process(root);
            StringHandle handle = new StringHandle(newURED);

            XMLDocumentManager xmlDocManager = client.newXMLDocumentManager();

            xmlDocManager.write(i+".xml", metaHandle, handle);
            logger.info("Document written");
        }

        client.release();
        logger.info("End Test");
    }

}
