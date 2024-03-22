package Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class hotelapplogin {
	WebDriver driver;
	@Test(dataProvider="TestData")
	public void app(String username, String password) {
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}
	@DataProvider(name="TestData")
	public Object[][] testdata() {
		
		exceldata ed=new exceldata("C:\\Users\\TKOLICHA\\Documents\\LoginData.xlsx");
		int rows=ed.getrowcount(0);
		Object[][] data=new Object[rows][2];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<2;j++) {
				data[i][j]=ed.getdata(0,i+1,j);
			}
		}
		return data;
	}

	
}
