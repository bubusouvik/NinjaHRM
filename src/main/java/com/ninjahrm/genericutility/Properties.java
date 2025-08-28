package com.ninjahrm.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./testappdata/commondata.properties");
		java.util.Properties pfile = new java.util.Properties();
		pfile.load(fis);
		String data = pfile.getProperty(key);
		return data;

	}

}
