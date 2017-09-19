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

    private static DocumentMetadataHandle uredMetaHandle = new DocumentMetadataHandle();
    private static DocumentCollections uredCollections = uredMetaHandle.getCollections();

    private static DocumentMetadataHandle rTwoMetaHandle = new DocumentMetadataHandle();
    private static DocumentCollections rTwoCollections = rTwoMetaHandle.getCollections();

    private DatabaseClient client;

    static {
        uredCollections.add("/citation/URED");
        rTwoCollections.add("/citation/R2");
    }

    public MarkLogicService(DatabaseClient client) {
        this.client = client;
    }

    public void writeNewUred(String url, String uredDoc) {
        StringHandle handle = new StringHandle(uredDoc);
        XMLDocumentManager xmlDocManager = client.newXMLDocumentManager();
        xmlDocManager.write(url, uredMetaHandle, handle);
        logger.info("Document written");
    }

    public void writeNewRTwo(String url, String rTwoDoc) {
        StringHandle handle = new StringHandle(rTwoDoc);
        XMLDocumentManager xmlDocManager = client.newXMLDocumentManager();
        xmlDocManager.write(url, rTwoMetaHandle, handle);
        logger.info("Document written");
    }
}
