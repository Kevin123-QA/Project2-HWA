package com.qa.hwa.selenium.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.hwa.selenium.page.Home;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeTest {
	@LocalServerPort
	int port; 
	
	private static final String url = "http://localhost:";
	private WebDriver driver; 
	
	
	@Before
	public void StartUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		//option.setHeadless(true); 
		driver = new ChromeDriver(option);
		driver.manage().window().setSize(new Dimension(1500, 800));
	}
	
	
	@After
	public void ShutDown() {
		driver.close();
	}
	
	@Test
	public void Check() {
		driver.get(url+port+"/");
		assertEquals(url+port+"/",driver.getCurrentUrl());
	}
	
	@Test 
	public void add() {
		driver.get(url+port+"/");
		Home homePage = PageFactory.initElements(driver, Home.class);
		String type = "Other";
		String info = "Unique 1";
		double amount=19.99d;
		
		homePage.addEntry(amount, type, info);
		
		
		homePage.getButtonSubmit().click();
				
		assertTrue(driver.getPageSource().contains("Entry Has Been Added"));
		
		
		
		
	}
	
	@Test
	public void clear() {
		driver.get(url+port+"/");
		Home homePage = PageFactory.initElements(driver, Home.class);
		
		String type = "Other";
		String info = "Unique 1";
		double amount=19.99d;
		
		homePage.addEntry(amount, type, info);
		homePage.getButtonClear().click();
		assertThat(homePage.getInputAmount().getText().isBlank()).isTrue();
		assertThat(homePage.getInputType().getText().isBlank()).isFalse();
		assertThat(homePage.getInputInfo().getText().isBlank()).isTrue();
	}
	
	
	@Test
	public void Edit() {
	driver.get(url+port+"/");
	Home homePage = PageFactory.initElements(driver, Home.class);
	String type = "Shopping";
	String info = "Update 2";
	double amount=1.99d;
	
	homePage.getEdit().click();
	WebDriverWait wait = new WebDriverWait(driver, 3); 
	wait.until(ExpectedConditions.visibilityOf(homePage.getModalWindow()));
	homePage.getClear().click();
	
	homePage.updateEntry(amount, type, info);
		
	homePage.getButtonSave().click();
	assertTrue(driver.getPageSource().contains("Entry Has Been Updated"));
	
		}

	@Test public void Delete() {
		driver.get(url+port+"/");
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getDelete().click();
		assertTrue(driver.getPageSource().contains("Entry Has Been Deleted"));
		
		
	}
}
