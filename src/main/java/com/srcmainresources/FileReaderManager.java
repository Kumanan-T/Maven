package com.srcmainresources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static Properties property;
	private static FileInputStream fileInputStream;
	
	private static void setupProperty() throws IOException{
		if(property == null) {
			File file = new File("C:\\Users\\HP\\eclipse-workspace\\MavenProject\\src\\main\\java\\com\\srcmainresources\\testdata.properties");
			try {
				fileInputStream = new FileInputStream(file);
				property = new Properties();
				property.load(fileInputStream);
			}catch (FileNotFoundException e) {
				Assert.fail("ERROR: FILENOTFOUND EXCEPTION OCCURS DUE TO THE LOADING OF PROPERTY");
			}catch (Exception e) {
				Assert.fail("ERROR: FILENOTFOUND EXCEPTION OCCURS DUE TO THE READING PROPERTY");
			}
		}
		
	}
	public static String getDataProperty(String dataValue) throws IOException {
		setupProperty();
		String browserName = property.getProperty(dataValue);
		return browserName;
	}
	

}
