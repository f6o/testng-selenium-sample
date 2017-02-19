package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopPage {
	@FindBy(how = How.ID_OR_NAME, name="field-keywords")
	WebElement searchBox;
	
	@FindBy(how = How.CSS, using="form[name='site-search'] input[type='submit']")
	WebElement submitButton;
	
	public WebDriver browser;
	
	public TopPage(WebDriver driver) {
		this.browser = driver;
	}
	
	public void search(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
	}
}
