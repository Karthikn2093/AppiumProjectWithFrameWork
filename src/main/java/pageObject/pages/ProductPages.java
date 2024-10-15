package pageObject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObject.utils.AndroidActions;

public class ProductPages extends AndroidActions {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartIcon;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> productCart;

	public ProductPages(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public ProductPages addItemToCartByIndex(int index) {

		addToCart.get(index).click();
		return this;
	}

	public CartPage clickOnCartButton() throws Exception {

		cartIcon.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
	public ProductPages clickProduct(String productName) {
		
		scrollToText(productName);
		
		int productCount = productNames.size();	
		
		for (int i = 0; i < productCount; i++) {
			
			
			String name = productNames.get(i).getText();
			if(name.equalsIgnoreCase(productName)) {
				
				productCart.get(i).click();
				
			}
			
		}
		
		return this;
		
	}

}
