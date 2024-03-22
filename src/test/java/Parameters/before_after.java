package Parameters;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class before_after {
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter reporter;
	ExtentTest test;
	String ExpectedText="Hello vasuvespag!";
	@Test
	public void login() {
		test=extent.createTest("Validate Greeting");
		
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		driver.findElement(By.id("password")).sendKeys("vasu1234");
		driver.findElement(By.id("login")).click();
		WebElement display= driver.findElement(By.id("username_show"));
		String actualText=display.getAttribute("value");
		
		if(actualText.equalsIgnoreCase(ExpectedText)) {
			test.log(Status.PASS, "Actual Greeting");
		}
		else {
			test.log(Status.FAIL, "Not Actual Greeting");
		}
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\TKOLICHA\\Pictures\\screenshot.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	private void extentLaunch() {
		extent = new ExtentReports();
		reporter= new ExtentSparkReporter("target/extHtml.html");
		extent.attachReporter(reporter);
	}
	@AfterSuite
	private void finOper() {
		test.addScreenCaptureFromPath("C:\\Users\\TKOLICHA\\Pictures\\screenshot.png",ExpectedText);
		driver.quit();
		extent.flush();
	}

}
