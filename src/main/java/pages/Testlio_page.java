package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Testlio_page extends PageBase {

	public Testlio_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Google Home Page
	@FindBy(name = "q")
	public WebElement Search_txtbox;
	
	@FindBy(name = "btnK")
	 WebElement GoogleSearch_btn;
	
	
	public void Searchbox(String Name)
	{
		SetText(Search_txtbox, Name);
		Search_txtbox.submit();
		
		
	}
	
	public void ClickSearchbutton()
	{
		click_button(GoogleSearch_btn);
	}
	
	
	

}
