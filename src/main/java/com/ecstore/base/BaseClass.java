package com.ecstore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

//import com.ecstore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		//moveExecutionResultsToArchivedFolder() ;
		//moveScreenshotsToArchivedFolder();
		//ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/Config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void launchApp(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().get(prop.getProperty("url"));
	}
	
	public void moveExecutionResultsToArchivedFolder() {
		File fileData = new File(System.getProperty("user.dir") + "/CurrentTestResults/ExtentReport/" + "MyReport.html");
		File destination = new File (System.getProperty("user.dir") + "/ArchivedTestResults/ExtentReport/" + "MyArchivedReport.html");
         // renaming the file and moving it to a new location
		if (fileData.renameTo(destination)) {
			// if file copied successfully then delete the original file
			fileData.delete();
			System.out.println("File moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}
	}
	
	public void moveScreenshotsToArchivedFolder() {
		String str_source = System.getProperty("user.dir") + "/CurrentTestResults/Screenshots";
	      String str_target = System.getProperty("user.dir") + "/ArchivedTestResults/ArchivedScreenshots/";
	      File directory = new File(str_source);
	      File[] filesList = directory.listFiles();

	      for(File file:filesList)
	      {
	          System.out.println(file.getPath());
	      }

	      Path result = null;
	      try 
	      {
	         for(File file:filesList)
	         {
	             result = Files.move(Paths.get(file.getPath().toString()), Paths.get(str_target+file.getName().toString()));
	         }
	      } 
	      catch (IOException e) 
	      {
	         System.out.println("Exception while moving file: " + e.getMessage());
	      }
	      if(result != null) 
	      {
	         System.out.println("File moved successfully.");
	      }
	      else
	      {
	         System.out.println("File movement failed.");
	      }  
	}

	@AfterSuite(groups = { "Smoke", "Regression", "Sanity" })
	public void afterSuite() {
		//ExtentManager.endReport();
	}
}
