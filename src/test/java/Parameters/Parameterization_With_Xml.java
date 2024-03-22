package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterization_With_Xml {
WebDriver driver;
@Test
@Parameters({"uname","pswrd"})
public void driverdriven(String uname,String pswrd) {
	
	driver=new ChromeDriver();
	driver.get("https://adactinhotelapp.com/index.php");
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.id("password")).sendKeys(pswrd);
	driver.findElement(By.id("login")).click();
	
}
}
