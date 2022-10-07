package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Jobs_page extends PageBase{

	public Jobs_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Jobs Element
	@FindBy(linkText = "Jobs")
	public WebElement Jobs_link;
	
	//Company Element
	@FindBy(linkText = "Company")
	public WebElement Company_link;

}
