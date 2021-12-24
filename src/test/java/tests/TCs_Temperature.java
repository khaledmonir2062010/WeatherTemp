package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage_Page;
import utilities.Helper;

public class TCs_Temperature extends TestBase {


	HomePage_Page HomePage_obj;

	@Test()
	public void VerifyTempDegree()
	{
		//Temperature Degrees Declaration
		int High_degree=34;
		int Low_Degree=19;

		//URL Declaration
		String HomeActualURL=driver.getCurrentUrl();
		String HomeExpectedURL="https://weathershopper.pythonanywhere.com/";



		Assert.assertEquals(HomeExpectedURL, HomeActualURL);

		HomePage_obj =new HomePage_Page(driver);

		int tempDegree=Helper.AdjustLength(HomePage_obj.TempDegree_element);
		//int tempDegree=HomePage_obj.AdjustLength();

		//Check for temperature
		if(tempDegree>High_degree)
		{
			HomePage_obj.clickSunscreen();
			String SunScreen_ActualTitle=driver.getTitle();
			String SunScreen_ExpectedTitle="The Best Sunscreens in the World!";
			Assert.assertEquals(SunScreen_ExpectedTitle, SunScreen_ActualTitle);

		}
		else if (tempDegree<Low_Degree)
		{
			HomePage_obj.clickMoisturizers();

			String Moisturizers_ActualTitle=driver.getTitle();
			String Moisturizers_ExpectedTitle="The Best Moisturizers in the World!";
			Assert.assertEquals(Moisturizers_ExpectedTitle, Moisturizers_ActualTitle);
		}
		else
		{
			System.out.println("Good Weather Condition :)");
		}
	}

}
