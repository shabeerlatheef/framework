package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test2 {
	
	public WebDriver driver;
	public String url = "https://demoqa.com/alerts";
	
	@BeforeSuite
	public void browsersetup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	@BeforeMethod
	public void appsetup()
	{
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
    public void quit()
    {
       driver.quit();
        System.out.println("quit the browser");
    }
	
	@Test
	public void test1() throws InterruptedException
	{
		WebElement alertbutton = driver.findElement(By.id("alertButton"));
		alertbutton.click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		WebElement confirm = driver.findElement(By.id("confirmButton"));
		confirm.click();
		Thread.sleep(5000);
		String s = driver.switchTo().alert().getText();
		System.out.println(s);
		driver.switchTo().alert().accept();
	}

}
