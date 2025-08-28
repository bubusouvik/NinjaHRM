package com.ninjahrm.genericutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileUtility {

//get common data from JSON utility

	public String getDataFromJSON(String key) throws ParseException, FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./testappdata/commondata.json"));
		JSONObject jsonobj = (JSONObject) obj;
		String data = jsonobj.get(key).toString();
		return data;

	}

}
