package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility implements IAutoConstants {
	

	/***
	 * this method is used to fetch the value from property file and it is return 
	 * @param key
	 * @return
	 * @throws IOException
	 */

		public  String readDataFromPropertiesFile(String key)
		
		
		{
			FileInputStream fis=null;
			try {
				fis = new FileInputStream(PROPERTYFILE);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			Properties ppt = new Properties();
			try {
				ppt.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return ppt.getProperty(key);
		}
			
		}
