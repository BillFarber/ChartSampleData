package org.billFarber.charts.dataGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.billFarber.charts.dataGenerator.sampleValues.ProgramElement;
import org.billFarber.marklogic.MarkLogicClientFactory;
import org.billFarber.marklogic.MarkLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;

public class GenerateR2 {

    private static final Logger logger = LoggerFactory.getLogger(GenerateR2.class);
    private static int NUM_R2_RECORDS_TO_GENERATE = 50;
    private static String BASE_R2_URI = "/citation/R2/";

    public static void main(String[] args) throws Exception {
        logger.info("Begin Test");
        DatabaseClient client = MarkLogicClientFactory.createMarkLogicClient();
        MarkLogicService mlService = new MarkLogicService(client);
        FreemarkerClient freemarker = new FreemarkerClient();

        for (int i = 0; i < NUM_R2_RECORDS_TO_GENERATE; i++) {
            Map<String, Object> root = new HashMap<>();
            int randomPE = ThreadLocalRandom.current().nextInt(0, 10);
            int randomPE2 = ThreadLocalRandom.current().nextInt(0, 10);

            String accessionNumber = "AA" + String.format ("%06d", i);
            root.put("programElementNumber", ProgramElement.values()[randomPE].name());
            root.put("programElementNumber2", ProgramElement.values()[randomPE2].name());
            if (randomPE2 % 2 == 0) {
                root.put("useProgramElementNumber2", true);
            } else {
                root.put("useProgramElementNumber2", false);
            }
            root.put("accessionNumber", accessionNumber);

            freemarker.loadTemplate("r2Template.ftlh");
            String newR2 = freemarker.process(root);
            logger.debug("new R2 document: \n" + newR2);
            mlService.writeNewRTwo(BASE_R2_URI+ accessionNumber + ".xml", newR2);
        }

        client.release();
        logger.info("End Test");
    }

}
