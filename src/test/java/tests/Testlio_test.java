package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.Jobs_page;
import pages.Testlio_page;

public class Testlio_test extends TestBase {
	
	
	Testlio_page testliopa;
	Jobs_page JobsObject;
	
	@Test
	public void printJob_Company()
	{
		//testliopa = new Testlio_page(driver);
		//JobsObject =new Jobs_page(driver);
		
		//testliopa.Searchbox("testlio");
		//testliopa.ClickSearchbutton();
		
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("");
		driver.manage().window().maximize();
	}

}
