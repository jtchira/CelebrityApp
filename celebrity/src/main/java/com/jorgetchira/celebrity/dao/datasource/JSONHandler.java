package com.jorgetchira.celebrity.dao.datasource;

import java.io.File;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Jorge Tchira
 * 
 * Represents JSON data handler
 *
 */
@Component
public class JSONHandler {
	
	/**
	 * Retrieve the JSON data structure
	 * 
	 * @return JSONData structure
	 */
	public JSONData getData() {
		JSONData jsonData = null;
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			jsonData = mapper.readValue(new File("src/main/resources/static/data.json"), JSONData.class);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonData;
	}

}
