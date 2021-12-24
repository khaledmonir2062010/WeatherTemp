package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Page extends PageBase {
	
	
	public HomePage_Page(WebDriver driver)
	{
		super(driver);
		
	}
	@FindBy(css = "h2")
	public WebElement CurrentTemp_TXT;
	
	@FindBy(id ="temperature")
	public WebElement TempDegree_element;
	
	
	@FindBy(css=".offset-4 .btn")
	WebElement BuySunScreens_btn;
	
	@FindBy(xpath="//button[contains(.,'Buy moisturizers')]")
	WebElement BuyMoisturizers_btn;
	
	
	public void clickSunscreen()
	{
		click_button(BuySunScreens_btn);
	}
	
	public void clickMoisturizers()
	{
		click_button(BuyMoisturizers_btn);
	}
	
	public Integer AdjustLength()
	{
		String temp=TempDegree_element.getText();
		String tempnumber="";
		
		for (int i = 0; i <temp.length(); i++)
			{
				int charc=temp.charAt(i);
				if(charc>48 && charc<58 )
				{
					tempnumber=tempnumber+temp.charAt(i);
				}
			}
		
		return Integer.parseInt(tempnumber);
	}
	
	
}
