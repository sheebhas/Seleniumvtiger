package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtility extends BaseClass implements IAutoConstants {
	public static  String takingScreenshot(String screenshotname)
	 {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File photo=ts.getScreenshotAs(OutputType.FILE);
		 String ldt= LocalTime.now().toString().replace(":","-");
		 String path= System.getProperty("user.dir")+SSPATH+screenshotname+" "+ldt+".png";
		 
		 File dest = new File(path);
		 try {
			FileUtils.copyFile(photo, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return path;
	 }

	
}


