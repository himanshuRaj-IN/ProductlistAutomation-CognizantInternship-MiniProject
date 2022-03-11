package utilities;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
		
	public static WebDriver driver;
	public static Properties prop;

	public WebDriver driverSetup() {
		// desc :  Read browser name from and config.properties file and create a static 'driver' instant of the WebDriver type.
		
		try {
		ReadPropertiesFile objReadPropertiesFile = new ReadPropertiesFile();
		prop =objReadPropertiesFile.readPropertiesFile();
		
		System.out.println("# Setting up driver for "+prop.getProperty("browserName")+" Browser.");
		
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",".\\.\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",".\\.\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver",".\\.\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("# Not a valid Browser Named passed"); 
			System.out.println("# Check config.properties file");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
