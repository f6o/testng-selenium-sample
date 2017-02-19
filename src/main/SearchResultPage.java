package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultPage {
	@FindBy(how=How.ID, using="s-result-count")
	WebElement resultCount;
	
	@FindBy(how=How.ID, using="bcKwText")
	WebElement searchQuery;
	
	@FindBy(how=How.CSS, using="#refinements .categoryRefinementsSection ul")
	WebElement categoryList;
	
	@FindBy(how=How.ID, using="s-results-list-atf")
	WebElement itemList;
	
	public WebDriver browser;
	
	public SearchResultPage(WebDriver driver) {
		this.browser = driver;
	}

	public boolean selectCategory(String name) {
		for ( WebElement li : categoryList.findElements(By.tagName("li")) ) {
			if ( name.equals(li.getText()) ) {
				li.click();
				return true;
			}
		}
		return false;
	}

	public String getQuery() {
		String q = resultCount.getText();
		return q.split("\"")[1];
	}
}
