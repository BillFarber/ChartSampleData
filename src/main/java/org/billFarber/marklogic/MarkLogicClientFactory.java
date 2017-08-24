package org.billFarber.marklogic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.billFarber.utils.properties.PropertiesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.SecurityContext;

public class MarkLogicClientFactory {

    private static final Logger logger = LoggerFactory.getLogger(MarkLogicClientFactory.class);

    private static String ML_HOST;
    private static Integer ML_REST_PORT;
    private static String ML_AUTHENTICATION;
    private static String ML_DATABASE;
    private static String ML_USERNAME;
    private static String ML_PASSWORD;

    private MarkLogicClientFactory() {
    }

    public static DatabaseClient createMarkLogicClient() throws Exception {
        DatabaseClient client = null;
        if (getMarkLogicProperties()) {
            SecurityContext securityContext = null;
            if (ML_AUTHENTICATION.equals("BASIC")) {
                securityContext = new DatabaseClientFactory.BasicAuthContext(ML_USERNAME, ML_PASSWORD);
            } else if (ML_AUTHENTICATION.equals("DIGEST")) {
                securityContext = new DatabaseClientFactory.DigestAuthContext(ML_USERNAME, ML_PASSWORD);
            } else {
                throw new Exception(
                        "MarkLogic Authentication type must be specified in marklogic.properties (BASIC or DIGEST)");
            }
            client = DatabaseClientFactory.newClient(ML_HOST, ML_REST_PORT, ML_DATABASE, securityContext);
            logger.info("Created MarkLogic client for " + ML_USERNAME);
        } else {
            throw new IOException();
        }
        return client;
    }

    private static Boolean getMarkLogicProperties() {
        Boolean success = false;
        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = PropertiesHelper.getResourceAsStream("marklogic.properties");
            properties.load(input);
            ML_HOST = properties.getProperty("host");
            ML_REST_PORT = Integer.valueOf(properties.getProperty("port"));
            ML_AUTHENTICATION = properties.getProperty("authentication");
            ML_DATABASE = properties.getProperty("database");
            ML_USERNAME = properties.getProperty("username");
            ML_PASSWORD = properties.getProperty("password");
            success = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }
}
