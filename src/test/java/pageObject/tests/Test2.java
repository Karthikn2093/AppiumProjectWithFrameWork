package pageObject.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.pages.CartPage;
import pageObject.pages.HomePage;
import pageObject.utils.BaseClass;

public class Test2 extends BaseClass {
	
	
	@Test
	public void test2() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);
		
		homePage.enterName("Name")
		.clickGender("Female")
		.selectCountry("Algeria")
		.clickShop()
		.clickProduct("Jordan 6 Rings")
		.clickOnCartButton()
		.waitFor();
		
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(),"Jordan 6 Rings");
		
	}
	
}
