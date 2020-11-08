package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import utilities.Helper;

public class BaseTest {

	private WebDriver driver;
	protected HomePage homePage;
//	protected JsonDataReader dataReader;
	private ExtentTest logger;
	private ExtentReports report;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://contactcars.com/");
		homePage = new HomePage(driver);
	}

	@BeforeMethod
	public void setupReport(Method m) {
		report = new ExtentReports("./Reports/" + m.getName() + ".html");
		logger = report.startTest(m.getName());
	}

	@AfterMethod
	public void updateReportWithFailedScreenshots(ITestResult result, Method m) throws IOException {

		String screenshot_path = "./Screenshots/" + result.getName() + ".png";
		String screenshotAbsolutePath = Helper.takeScreenShot(driver, screenshot_path);
		String image = logger.addScreenCapture(screenshotAbsolutePath);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, m.getName(), image);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, m.getName(), image);
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, m.getName(), image);
		}
		report.endTest(logger);
		report.flush();
	}

	@AfterTest
	public void closeSession() {
		driver.quit();
	}

}
