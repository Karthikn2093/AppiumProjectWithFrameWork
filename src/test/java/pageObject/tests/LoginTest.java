package pageObject.tests;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.pages.HomePage;
import pageObject.utils.BaseClass;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "getData")
	public void loginTest(String name, String gender, String country) throws Exception {

		HomePage homePage = new HomePage(driver);
		homePage.enterName(name).clickGender(gender).selectCountry(country).clickShop();

	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "Alex", "Male", "Argentina" }, { "Kim", "Female", "Angola" } };

	}

	@DataProvider
	public Object[][] getDataUsingMap() {
		
		List<HashMap<String, String>> data = getJsonData("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProjectWithFrameWork\\src\\test\\java\\pageObjects\\testData\\eCommerce.JSON");
				
			
			return new Object [][] { {data.get(0)}, {data.get(1)}};
			
		
		}

	

}}
