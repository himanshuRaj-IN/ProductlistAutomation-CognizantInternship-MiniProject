package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static void takeFullScreenShot(WebDriver driver, String fileName) throws IOException {
		//desc: Take full window screenshot and store it into the Screenshots folder with name passed in as string concatination withthe timestamp at the end
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		File fileObj = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileObj, new File(".\\.\\screenshots\\"+fileName+"_"+timeStamp+".png"));
		System.out.println("- Screenshot captured Name : "+fileName+"_"+timeStamp+".png\n");	
}
	}
		
	

