package testCases.BenchesPage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BenchesPage;	
import utilities.ScreenShot;

public class IndustrialBenchesTest extends BenchesPage{
	
	public void verifyCountIdustrailBenches() {
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
			System.out.println("--- Pass\n");
		}
		else {
			System.out.println("--- Fail\n");
		}
	}
	
	public static void main(String[] args) {
		IndustrialBenchesTest obj = new IndustrialBenchesTest();
		try {
			
		obj.driverSetup();
		obj.openUrl("baseUrl");
		ScreenShot.takeFullScreenShot(driver,"LandingPage");
		obj.validateTitle();
		obj.hoverOnFurniture();
		obj.hoverOnSeating();
		ScreenShot.takeFullScreenShot(driver,"HoveringSubmenu");
		obj.clickOnBenches();
		obj.verifyBenchesPage();
		ScreenShot.takeFullScreenShot(driver,"BenchesPage");
		obj.displayBenchesCategory();
		obj.verifyCountIdustrailBenches();
		obj.closeBrowser();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
