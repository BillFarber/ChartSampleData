package org.billFarber.marklogic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;

public class MarkLogicService {

	private static final Logger logger = LoggerFactory.getLogger(MarkLogicService.class);

	private DatabaseClient client;

	public MarkLogicService(DatabaseClient client) {
		this.client = client;
	}

	public List<String> readStateRegion(String uri) {
		JSONDocumentManager jsonDocumentManager = client.newJSONDocumentManager();
		JacksonHandle readHandle = new JacksonHandle();
		readHandle = jsonDocumentManager.read(uri, readHandle);
		JsonNode root = readHandle.get();
		return root.findValuesAsText("region");
	}
}
