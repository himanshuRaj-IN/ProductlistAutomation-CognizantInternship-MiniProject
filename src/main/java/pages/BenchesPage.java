package pages;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.DriverSetup;
import utilities.ReadPropertiesFile;

public class BenchesPage {

	public static WebDriver driver;
	public static WebElement webEle;

	public void driverSetup() {
		DriverSetup setupObj = new DriverSetup();
		driver = setupObj.driverSetup();
	}

	public void openUrl(String urlNameInPropFile) {
		ReadPropertiesFile rpfObj = new ReadPropertiesFile();
		Properties prop = rpfObj.readPropertiesFile();
		System.out.println("# Navigating to Url :  "+prop.getProperty(urlNameInPropFile)+".\n");
		driver.get(prop.getProperty(urlNameInPropFile));
	}

	public void closeBrowser() {
		System.out.println("# Closing Browser.");	
		driver.quit();
	}

	public void validateTitle() {
		System.out.println("# Validating title of page");
		// Validating text in title
		String title = driver.getTitle();
		boolean flag = title.contains("Online Furniture Shopping Store");
		
		if (flag) {
			System.out.println("--- Pass\n");
		}
		else {
			System.out.println("--- Fail\n");
			
		}
			
	}

	public void hoverOnFurniture() {
		System.out.println("# Hovering over Furniture.\n");
		
		webEle = driver.findElement(By.linkText("Furniture"));
		Actions action = new Actions(driver);
		action.moveToElement(webEle).perform();
	}
	
	public void hoverOnSeating() {
		System.out.println("# Hovering over seating.\n");
		
		Actions action = new Actions(driver);
		webEle = driver.findElement(By.linkText("Seating"));
		action.moveToElement(webEle).perform();
	}
	
	public void clickOnBenches() {
		System.out.println("# Clicking on Benches Option.\n");
		
		Actions action = new Actions(driver);
		webEle = driver.findElement(By.linkText("Benches"));
		action.moveToElement(webEle).click().perform();
	}

	public void verifyBenchesPage() {
		System.out.println("# Verifying Sub Heading Benches page.");
		String SubHeading = driver.findElement(By.className("clipMeta__ttl")).getText();
		
		if(SubHeading.equals("Benches")) {
			System.out.println("--- Pass\n");
		}
		else {
			System.out.println("--- Fail\n");
		}
		
	}

	public void displayBenchesCategory() {
		
		System.out.println("# Displaying Benches with Respect to Category and Count.");
		System.out.println("       Category                Count");
		System.out.println("------------------------------------------");
		
		webEle = driver.findElement(By.className("clip-main-wrap-cat"));
		List<WebElement> allElements = webEle.findElements(By.tagName("li"));
		for (WebElement element : allElements) {
			String heading = element.findElement(By.tagName("h5")).getText();
			String paraText = element.findElement(By.tagName("p")).getText();
			System.out.printf("%-30s%s\n",heading,paraText);	
		}
		
		System.out.println("");
	}
}
