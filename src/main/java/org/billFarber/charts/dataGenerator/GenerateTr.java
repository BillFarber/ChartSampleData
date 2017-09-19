package org.billFarber.charts.dataGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.billFarber.charts.dataGenerator.sampleValues.ContractNumber;
import org.billFarber.marklogic.MarkLogicClientFactory;
import org.billFarber.marklogic.MarkLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;

public class GenerateTr {

    private static final Logger logger = LoggerFactory.getLogger(GenerateTr.class);
    private static int NUM_TR_RECORDS_TO_GENERATE = 10;
    private static String BASE_TR_URI = "/citation/TR/";

    public static void main(String[] args) throws Exception {
        logger.info("Begin Generation");
        DatabaseClient client = MarkLogicClientFactory.createMarkLogicClient();
        MarkLogicService mlService = new MarkLogicService(client);
        FreemarkerClient freemarker = new FreemarkerClient();

        for (int i = 0; i < NUM_TR_RECORDS_TO_GENERATE; i++) {
            Map<String, Object> root = new HashMap<>();
            int randomContractNumber = ThreadLocalRandom.current().nextInt(0, 10);

            String accessionNumber = "AD" + String.format ("%06d", i);
            root.put("accessionNumber", accessionNumber);
            root.put("contractNumber", ContractNumber.values()[randomContractNumber].name());

            freemarker.loadTemplate("trTemplate.ftlh");
            String newTr = freemarker.process(root);
            logger.debug("new TR document: \n" + newTr);
            mlService.writeNewTr(BASE_TR_URI+ accessionNumber + ".xml", newTr);
        }

        client.release();
        logger.info("End Generation");
    }

}
