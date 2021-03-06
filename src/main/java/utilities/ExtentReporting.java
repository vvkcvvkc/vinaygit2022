package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {

	public static ExtentReports getExtentReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\extentReport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Automation report");
		reporter.config().setReportName("TutorialsNinja.com");
		reporter.config().setTheme(Theme.DARK);
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Operating System", path);
		extent.setSystemInfo("Automation Script Developer", "Ankur Mishra");
		return extent;
	}
}
