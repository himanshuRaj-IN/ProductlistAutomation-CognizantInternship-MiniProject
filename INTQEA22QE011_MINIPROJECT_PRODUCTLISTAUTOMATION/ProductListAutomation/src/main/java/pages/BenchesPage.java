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
		// Setting up driver by making object of the DriverSetup class in utilities package
		// desc: create a static 'driver' instant of the WebDriver type.
		DriverSetup setupObj = new DriverSetup();
		driver = setupObj.driverSetup();
	}

	public void openUrl(String urlNameInPropFile) {
		// desc: open url according to the name which is mapped in the properties file 
		ReadPropertiesFile rpfObj = new ReadPropertiesFile();
		Properties prop = rpfObj.readPropertiesFile();
		System.out.println("# Navigating to Url :  "+prop.getProperty(urlNameInPropFile)+".\n");
		driver.get(prop.getProperty(urlNameInPropFile));
	}

	public void closeBrowser() {
		// desc: close browser kill driver instant.
		System.out.println("# Closing Browser.");	
		driver.quit();
	}

	public void validateTitle() {
		//desc: verify title of the dom tha contain particular String which passed into the function print pass and fail accordingly.
		
		System.out.println("# Validating title of page.");
		String title = driver.getTitle();
		boolean flag = title.contains("Online Furniture Shopping Store");
		
		if (flag) {
			System.out.println("- PASSED : Contains 'Online Furniture Shopping Store'");
		}
		else {
			System.out.println("- FAILED : Do not contains 'Online Furniture Shopping Store'");
			
		}
			
	}

	public void hoverOnFurniture() {
		// desc:  hover on the furniture 
		System.out.println("# Hovering over Furniture.");
		
		webEle = driver.findElement(By.linkText("Furniture"));
		Actions action = new Actions(driver);
		action.moveToElement(webEle).perform();
	}
	
	public void hoverOnSeating() {
		//  desc:  hover on the Seating 
		System.out.println("# Hovering over seating.");
		
		Actions action = new Actions(driver);
		webEle = driver.findElement(By.linkText("Seating"));
		action.moveToElement(webEle).perform();
	}
	
	public void clickOnBenches() {
		// desc:  click on the benches option
		
		System.out.println("# Clicking on Benches Option.");
		
		Actions action = new Actions(driver);
		webEle = driver.findElement(By.linkText("Benches"));
		action.moveToElement(webEle).click().perform();
	}

	public void verifyBenchesPage() {
		//desc:   verify benches page by valdating subtitle benches in the DOM
		
		System.out.println("# Verifying Sub Heading Benches page.");
		String SubHeading = driver.findElement(By.className("clipMeta__ttl")).getText();
		
		if(SubHeading.equals("Benches")) {
			System.out.println("- PASSED : Subtitle of page contains 'Benches'.");
		}
		else {
			System.out.println("- FAILED : Subtitle of page not contains 'Benches'.");
		}
		
	}

	public void displayBenchesCategory() {
		//desc:  print all display category of the benches available on console.
		
		System.out.println("# Displaying Benches with Respect to Category and Count.");
		System.out.println("----------------------------------------------");
		System.out.println("       Category                    Count");
		System.out.println("----------------------------------------------");
		
		webEle = driver.findElement(By.className("clip-main-wrap-cat"));
		List<WebElement> allElements = webEle.findElements(By.tagName("li"));
		int count = 1; 
		for (WebElement element : allElements) {
			String heading = element.findElement(By.tagName("h5")).getText();
			String paraText = element.findElement(By.tagName("p")).getText();
			System.out.printf(count+". %-30s%s\n",heading,paraText);
			count++;
		}
		
		System.out.println("");
	}
}
