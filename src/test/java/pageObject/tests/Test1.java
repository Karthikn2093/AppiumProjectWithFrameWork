package pageObject.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObject.pages.CartPage;
import pageObject.pages.HomePage;
import pageObject.utils.BaseClass;

public class Test1 extends BaseClass {
	
	@Test
	public void test1() throws Exception {
		
		HomePage homePage = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);
		
		homePage.enterName("Name")
		.clickGender("Female")
		.selectCountry("Algeria")
		.clickShop()
		.addItemToCartByIndex(0)
		.addItemToCartByIndex(0)
		.clickOnCartButton();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Thread.sleep(2000);
		
		double sum = cartPage.getSum();
		
		double totalPrice = cartPage.totalSum();
		
		Assert.assertEquals(sum, totalPrice);
		
		cartPage.longClick().dismiss().checkCheckBox().completeOrder();
		
		
	}

}
