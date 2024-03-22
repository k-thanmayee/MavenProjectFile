package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class priorities {
	WebDriver driver;
	@BeforeTest
	public void setdriver() {
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
	}
	@Test(priority='1')
	public void data() {
		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		driver.findElement(By.id("password")).sendKeys("vasu1234");
		driver.findElement(By.id("login")).click();
	}
	@Test(priority='z')
	public void zdata() {
		System.out.println("z");
	}
	@Test(priority='a')
	public void adata() {
		System.out.println("a");
	}
	@Test(priority='k')
	public void kdata() {
		System.out.println("k");
	}
}
