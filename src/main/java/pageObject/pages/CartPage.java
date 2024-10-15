package pageObject.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObject.utils.AndroidActions;

public class CartPage extends AndroidActions {

	public AndroidDriver driver;
	double sum = 0.0;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")
	private List<WebElement> pricesList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement dismissButton;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement completeButton;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageTitle;

	public double getSum() {

		for (WebElement webElement : pricesList) {

			String priceText = webElement.getText();

			double price = formatDollarString(priceText);

			sum += price;

		}

		return sum;

	}

	public double totalSum() {

		String total = totalAmount.getText();
		double totalPrice = formatDollarString(total);
		return totalPrice;
	}

	public CartPage longClick() {

		longClickGesture(termsButton);
		return this;
	}

	public CartPage dismiss() {

		dismissButton.click();
		return this;
	}
	
	public CartPage checkCheckBox() {
		
		checkBox.click();
		return this;
	}
	
	public void completeOrder() {
		
		completeButton.click();
		
	}
	
	public void waitFor() {
		
		waitForElement(pageTitle, "Cart");
		
	}
	
}
