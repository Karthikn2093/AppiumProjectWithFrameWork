package pageObject.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {

	public AppiumDriver driver;

	public AppiumUtils(AppiumDriver driver) {

		this.driver = driver;

	}

	public void waitForElement(WebElement element, String expectedTitle) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((element), "text", expectedTitle));

	}

	public Double formatDollarString(String amount) {

		Double price = Double.parseDouble(amount.substring(1));
		return price;

	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
		
		return data;
		}
	

}
