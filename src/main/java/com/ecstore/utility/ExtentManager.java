package com.ecstore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/CurrentTestResults/ExtentReport/"+"MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyECStoreProject");
		extent.setSystemInfo("Tester", "Vibha");
	}
	public static void endReport() {
		//extent.flush();
	}
}
