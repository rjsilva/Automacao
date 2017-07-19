package br.com.userede.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File {
	
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"src/properties/chromedriver.properties");
		props.load(file);
		return props;
	
	}
}
