package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProvider1 {
	WebDriver driver;
	@Test(dataProvider="TestData")
	
	public void data(String uname,String pswrd) {
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pswrd);
		driver.findElement(By.id("login")).click();
		
	}
	
	@DataProvider(name="TestData")
	public Object[][] TestData() {
		Object[][] data=new Object[5][2];
		data[0][0]="vasuvespag";
		data[0][1]="vasu1234";
		data[1][0]="Sriyaseth";
		data[1][1]="Sriya@86";
		data[2][0]="Varsharaj";
		data[2][1]="Varsharaj";
		data[3][0]="jastisrija";
		data[3][1]="oY38Rv";
		data[4][0]="chaithuuu";
		data[4][1]="12309876";
		return data;
	}
}
