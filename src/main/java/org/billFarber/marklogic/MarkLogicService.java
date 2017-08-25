package org.billFarber.marklogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.XMLDocumentManager;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.StringHandle;
import com.marklogic.client.io.DocumentMetadataHandle.DocumentCollections;

public class MarkLogicService {

    private static final Logger logger = LoggerFactory.getLogger(MarkLogicService.class);

    private static DocumentMetadataHandle metaHandle = new DocumentMetadataHandle();
    private static DocumentCollections collections = metaHandle.getCollections();

    private DatabaseClient client;

    static {
        collections.add("/citation/URED");
    }

    public MarkLogicService(DatabaseClient client) {
        this.client = client;
    }

    public void writeNewUred(String url, String uredDoc) {
        StringHandle handle = new StringHandle(uredDoc);
        XMLDocumentManager xmlDocManager = client.newXMLDocumentManager();
        xmlDocManager.write(url, metaHandle, handle);
        logger.info("Document written");
    }
}
