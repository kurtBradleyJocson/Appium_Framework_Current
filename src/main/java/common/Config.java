package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private static Properties properties;

	FileInputStream fileInputStream;
	
	String project;

	public Config(String project) {
		
		this.project = project;
		
		setup();
		
	}

	public void setup() {
		
		try {
			String userHome = System.getProperty("user.home");
		
			String filePath = userHome + "/eclipse-workspace/"+project+"/resources/config.properties";
			fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
	}
	
	public static String getApk() {
		return properties.getProperty("androidApp");
	}
	
	public static String getApp() {
		return properties.getProperty("iosApp");
	}

}
