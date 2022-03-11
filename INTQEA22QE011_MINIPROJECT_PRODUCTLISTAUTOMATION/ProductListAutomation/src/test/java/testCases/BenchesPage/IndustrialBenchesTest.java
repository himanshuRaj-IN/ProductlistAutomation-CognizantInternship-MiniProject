package testCases.BenchesPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BenchesPage;	
import utilities.ScreenShot;
import utilities.WriteOutputFile;

public class IndustrialBenchesTest extends BenchesPage{
	
	public void verifyCountIdustrailBenches() {
		// desc: this method verify where industrial benches is more than one.
	
		System.out.println("# Checking industrial bench are more than one.");
		
		int countIndustrialBenches = 0;
		webEle = driver.findElement(By.className("clip-main-wrap-cat"));
		List<WebElement> allElements = webEle.findElements(By.tagName("li"));
		for (WebElement element : allElements) {
			String heading = element.findElement(By.tagName("h5")).getText();
			if(heading.contains("Industrial")) {
				String paraText = element.findElement(By.tagName("p")).getText();
				String[] splitStringArr = paraText.split("\\s");
				countIndustrialBenches = Integer.valueOf(splitStringArr[0]);
				break;
			}			
		}
		
		if(countIndustrialBenches>1) {
			System.out.println("- PASSES : Yes there are More options available in industrial benches");
		}
		else {
			System.out.println("- FAILED : No more options available !!.");
		}
	}
	
	public static void main(String[] args) {
		IndustrialBenchesTest obj = new IndustrialBenchesTest();
		try {
			
		WriteOutputFile.write();       			// Setting up PrintStream to Output.txt file 
		obj.driverSetup();			   			// Setting driver according to specified in config.properties file
		obj.openUrl("baseUrl");		   			// Navigating to the URL name baseUrl specified into config.properties file
		obj.validateTitle();           			// Validating title of the Landing page of the baseUrl.
		ScreenShot.takeFullScreenShot(driver,"LandingPage");
		obj.hoverOnFurniture();        			// Hovering over the furniture in navigation bar.
		obj.hoverOnSeating();          			// Hovering over the Seating in furniture submenu.
		ScreenShot.takeFullScreenShot(driver,"HoveringSubmenu");
		obj.clickOnBenches();         			// clicked on the benches option in seating submenu.
		obj.verifyBenchesPage();       			// verifying benches page.
		ScreenShot.takeFullScreenShot(driver,"BenchesPage");
		obj.displayBenchesCategory();  			//  Displaying  all category of the benches Available 
		obj.verifyCountIdustrailBenches();      // verifying industrial benches options 
		obj.closeBrowser();						// Closing Browser.		
		
		}catch (FileNotFoundException f) {
			f.printStackTrace();
		}catch (IOException i) {
			i.printStackTrace();
		}catch (NoSuchElementException nse) {
			nse.printStackTrace();
		}catch (NullPointerException npe) {
			npe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Shifting PrintStream to console 
			WriteOutputFile.writeOnConsole();
			System.out.println("#  Steps executed.");
			System.out.println("   For details check out Output.txt file.");
			System.out.println("------------------------------------------------------------");
			// Printing content of the Output.txt file to console.
			WriteOutputFile.printOutputTxtfile();
		}
	}

}
