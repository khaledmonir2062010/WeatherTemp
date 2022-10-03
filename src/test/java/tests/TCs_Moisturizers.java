package tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage_Page;
import pages.Moisturizers_Page;

public class TCs_Moisturizers extends TestBase {
	HomePage_Page HomePage_obj;
	Moisturizers_Page Moisturizers_obj;

	@Test
	public void LeastExpensivemoisturizers()
	{
		HomePage_obj = new HomePage_Page(driver);
		HomePage_obj.clickMoisturizers();
		Moisturizers_obj =new Moisturizers_Page(driver);

		String CLickElement="";
		Integer minPric=Integer.MAX_VALUE;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> ProductsButtons=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("button")));
		System.out.println(ProductsButtons.size());
		ProductsButtons.remove(0);

		//Identify the least expensive Aloe Product
		for(WebElement product:ProductsButtons)
		{
			System.out.println(product.getAttribute("onclick"));

			String[] Prodname=product.getAttribute("onclick").split(",");
			String moisturizersName=Prodname[0].substring(11,Prodname[0].length()-1);
			Integer moisturizersPrice=Integer.parseInt(Prodname[1].substring(0,Prodname[1].length()-1));
			boolean found=Arrays.asList(moisturizersName.split(" ")).contains("Aloe");
			if (found && moisturizersPrice<minPric )
			{
				minPric=moisturizersPrice;
				CLickElement="//button[@onclick=\"addToCart('"+moisturizersName+"',"+moisturizersPrice+")\"]";
			}
		}

		driver.findElement(By.xpath(CLickElement)).click();

		
		//Identify the least expensive Almond Product
		for(WebElement product:ProductsButtons)
		{
			String[] Prodname=product.getAttribute("onclick").split(",");
			 String moisturizersName=Prodname[0].substring(11,Prodname[0].length()-1);
			Integer moisturizersPrice=Integer.parseInt(Prodname[1].substring(0,Prodname[1].length()-1));
			boolean found=Arrays.asList(moisturizersName.split(" ")).contains("Almond");

			if (found && moisturizersPrice<minPric )
			{
				minPric=moisturizersPrice;
				CLickElement="//button[@onclick=\"addToCart('"+moisturizersName+"',"+moisturizersPrice+")\"]";
			}
		}

//		//Click 
//		driver.findElement(By.xpath(CLickElement)).click();
//		Moisturizers_obj.OpenCart();
		
		
//		String Actual="//td[contains(.,'moisturizersName')]";
//		Assert.assertEquals("", "");
	}

}
