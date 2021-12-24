package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Moisturizers_Page extends PageBase {

	public Moisturizers_Page(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "cart")
	WebElement AddCart_btn;
	
	public void OpenCart()
	{
		click_button(AddCart_btn);
	}
	
	

}
