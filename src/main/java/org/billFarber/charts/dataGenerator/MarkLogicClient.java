package org.billFarber.charts.dataGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

public class MarkLogicClient {

    private static final Logger logger = LoggerFactory.getLogger(MarkLogicClient.class);

    public static DatabaseClient getClient() {
        DatabaseClient client = DatabaseClientFactory.newClient("localhost",
                8000, "Charts", new DatabaseClientFactory.DigestAuthContext(
                        "admin", "admin"));
        logger.info("MarkLogic client created");
        return client;
    }
}
