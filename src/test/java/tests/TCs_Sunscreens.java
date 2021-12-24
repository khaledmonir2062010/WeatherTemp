package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage_Page;
import pages.SunScreens_Page;

public class TCs_Sunscreens extends TestBase {

	HomePage_Page HomePage_obj;
	SunScreens_Page Sunscreen_obj;

	@Test
	public void LeastExpensiveSPF_Fifty()
	{
		HomePage_obj = new HomePage_Page(driver);
		HomePage_obj.clickSunscreen();
		Sunscreen_obj =new SunScreens_Page(driver);

		String CLickElement="";
		Integer minPric=Integer.MAX_VALUE;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> ProductsButtons=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("button")));
		System.out.println(ProductsButtons.size());
		ProductsButtons.remove(0);

		//Identify the least expensive sunscreen that is SPF-30
		for(WebElement product:ProductsButtons)
		{
			String[] Prodname=product.getAttribute("onclick").split(",");
			String sunScreenName=Prodname[0].substring(11,Prodname[0].length()-1);
			Integer sunScreenPrice=Integer.parseInt(Prodname[1].substring(0,Prodname[1].length()-1));
			String spfNo=sunScreenName.substring(sunScreenName.length()-2,sunScreenName.length());

			if (spfNo.equals("50") && sunScreenPrice<minPric )
			{
				minPric=sunScreenPrice;
				CLickElement="//button[@onclick=\"addToCart('"+sunScreenName+"',"+sunScreenPrice+")\"]";
			}
		}

		//Click on the least expensive sunscreen that is SPF-50
		driver.findElement(By.xpath(CLickElement)).click();

		//Identify the least expensive sunscreen that is SPF-30
		for(WebElement product:ProductsButtons)
		{
			String[] Prodname=product.getAttribute("onclick").split(",");
			String sunScreenName=Prodname[0].substring(11,Prodname[0].length()-1);
			Integer sunScreenPrice=Integer.parseInt(Prodname[1].substring(0,Prodname[1].length()-1));
			String spfNo=sunScreenName.substring(sunScreenName.length()-2,sunScreenName.length());

			if (spfNo.equals("30") && sunScreenPrice<minPric )
			{
				minPric=sunScreenPrice;
				CLickElement="//button[@onclick=\"addToCart('"+sunScreenName+"',"+sunScreenPrice+")\"]";
			}
		}

		//Click on the Product with least spf 30 price
		driver.findElement(By.xpath(CLickElement)).click();
		Sunscreen_obj.OpenCart();
	}	
}
