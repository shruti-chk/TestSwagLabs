package com.test.drivers;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
	public Driver() {}
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader locfr;
	
	public static void initDriver() throws IOException {

			if (driver == null) {
				// read config properties and launch browser accordingly
				fr = new FileReader(System.getProperty("user.dir")+
						"\\src\\test\\resources\\configfiles\\config.properties");
				locfr = new FileReader(System.getProperty("user.dir")+
						"\\src\\test\\resources\\configfiles\\locators.properties");
				
				prop.load(fr);
				loc.load(locfr);
			}
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				//launch chrome browser
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.navigate().to(prop.getProperty("baseURL"));
				driver.manage().window().maximize(); // maximize the browser window
				
			}
			if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				// launch firefox browser
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.navigate().to(prop.getProperty("baseURL"));
				driver.manage().window().maximize();  // maximize the browser window
				
			}
			
		}
	
	public static void closeDriver() {
		if(Objects.nonNull(driver)) {
			driver.close();
			driver.quit();
		}
	}

}
