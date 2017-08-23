package org.billFarber.charts.dataGenerator;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

public class MarkLogicClient {
    public static DatabaseClient getClient() {
        DatabaseClient client = DatabaseClientFactory.newClient("localhost",
                8000, "Charts", new DatabaseClientFactory.DigestAuthContext(
                        "admin", "admin"));
        return client;
    }
}
