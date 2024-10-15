package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObject.utils.AndroidActions;

public class HomePage extends AndroidActions {

	public AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")
	private WebElement genderFemale;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")
	private WebElement genderMale;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryField;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;

	public HomePage enterName(String name) throws Exception {
		Thread.sleep(2000);
		nameField.sendKeys(name);
		driver.hideKeyboard();
		return this;
	}

	public HomePage clickGender(String gender) {

		if (gender.contains("Male")) {

			genderMale.click();
			return this;

		} else

			genderFemale.click();
		return this;
	}

	public HomePage selectCountry(String countryName) {

		countryField.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();
		return this;

	}

	public ProductPages clickShop() throws Exception {

		shopButton.click();
		Thread.sleep(2000);
		return new ProductPages(driver);
	}
	
	public void setActivity() {
		
	}

}
