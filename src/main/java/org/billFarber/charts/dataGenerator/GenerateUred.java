package org.billFarber.charts.dataGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.billFarber.marklogic.MarkLogicClientFactory;
import org.billFarber.marklogic.MarkLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;

public class GenerateUred {

    private static final Logger logger = LoggerFactory.getLogger(GenerateUred.class);
    private static int NUM_URED_RECORDS_TO_GENERATE = 10;

    public static void main(String[] args) throws Exception {
        logger.info("Begin Test");
        DatabaseClient client = MarkLogicClientFactory.createMarkLogicClient();
        MarkLogicService mlService = new MarkLogicService(client);
        FreemarkerClient freemarker = new FreemarkerClient();

        for (int i = 0; i < NUM_URED_RECORDS_TO_GENERATE; i++) {
            Map<String, Object> root = new HashMap<>();
            int randomStateNum = ThreadLocalRandom.current().nextInt(0, 49 + 1);
            int randomAmount = ThreadLocalRandom.current().nextInt(0, 999999999);

            root.put("state", State.values()[randomStateNum].abbreviation());
            root.put("amount", "" + randomAmount);

            freemarker.loadTemplate("uredTemplate.ftlh");
            String newURED = freemarker.process(root);
            logger.debug("new URED document: \n" + newURED);
            mlService.writeNewUred(i + ".xml", newURED);
        }

        client.release();
        logger.info("End Test");
    }

}
