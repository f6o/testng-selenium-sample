package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.SearchResultPage;
import main.TopPage;

public class TopPageSearchTest {
	private TopPage page;
	
	@BeforeTest
	public void openBrowser() {
		WebDriver browser = new ChromeDriver();
		browser.get("http://www.amazon.co.jp/");
		page = PageFactory.initElements(browser, TopPage.class);
	}
	
	@Test
	public void doSearch() {
		page.search("testng");
		SearchResultPage resultPage = PageFactory.initElements(page.browser, SearchResultPage.class);
		
		boolean done = resultPage.selectCategory("本");
		Assert.assertTrue(done);
		
		SearchResultPage adultResultPage = PageFactory.initElements(page.browser, SearchResultPage.class);
		Assert.assertEquals(adultResultPage.getQuery(), "testng");
	}
	
	@AfterTest
	public void closeBrowser() {
		page.browser.quit();
	}
}
