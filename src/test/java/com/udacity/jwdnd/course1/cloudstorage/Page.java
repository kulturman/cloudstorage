package com.udacity.jwdnd.course1.cloudstorage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	@FindBy(css = "[type=submit]")
	private WebElement loginBtn;
	@FindBy(id = "inputPassword")
	private WebElement passwordInput;
	@FindBy(id = "inputUsername")
	private WebElement usernameInput;
	
	public Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void logIn(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		passwordInput.submit();
	}
}
