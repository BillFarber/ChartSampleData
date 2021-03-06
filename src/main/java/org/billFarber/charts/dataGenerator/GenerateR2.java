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
    private static int NUM_R2_RECORDS_TO_GENERATE = 100;
    private static int NUM_R2_YEARS = 8;
    private static String BASE_R2_URI = "/citation/R2/";

    public static void main(String[] args) throws Exception {
        logger.info("Begin Test");
        DatabaseClient client = MarkLogicClientFactory.createMarkLogicClient();
        MarkLogicService mlService = new MarkLogicService(client);
        FreemarkerClient freemarker = new FreemarkerClient();

        for (int i = 0; i < NUM_R2_RECORDS_TO_GENERATE; i++) {
            Map<String, Object> root = new HashMap<>();
            int randomPE = ThreadLocalRandom.current().nextInt(0, 40);
            int randomPE2 = ThreadLocalRandom.current().nextInt(0, 40);

            String accessionNumber = "AA" + String.format ("%06d", i);
            root.put("accessionNumber", accessionNumber);
            root.put("programElementNumber", ProgramElement.values()[randomPE].name());
            root.put("programElementNumber2", ProgramElement.values()[randomPE2].name());
            if (randomPE2 % 4 == 0) {
                root.put("useProgramElementNumber2", true);
            } else {
                root.put("useProgramElementNumber2", false);
            }

            int baseBudgetYear = 2000 + ThreadLocalRandom.current().nextInt(0, 15);
            int funding = ThreadLocalRandom.current().nextInt(100000, 8000000);
            for (int j = 0; j < NUM_R2_YEARS; j++) {
                root.put("programElementBudgetYear", String.format ("%4d", baseBudgetYear+j));

                int randomFundingIncrement = ThreadLocalRandom.current().nextInt(10000, 800000);
                funding += randomFundingIncrement;
                root.put("fundingAmount", String.format ("%8d", funding));

                freemarker.loadTemplate("r2Template.ftlh");
                String newR2 = freemarker.process(root);
                logger.debug("new R2 document: \n" + newR2);
                String uri = BASE_R2_URI+ accessionNumber + "-" + (baseBudgetYear+j) + ".xml";
                mlService.writeNewRTwo(uri, newR2);
            }
        }

        client.release();
        logger.info("End Test");
    }

}
