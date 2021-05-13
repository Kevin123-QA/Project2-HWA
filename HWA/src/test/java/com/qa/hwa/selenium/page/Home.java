package com.qa.hwa.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Home {
	
	
	@FindBy(id="amount")
	private WebElement InputAmount;
	
	@FindBy(id="typeSelector")
	private WebElement InputType;
	
	@FindBy(id="additional")
	private WebElement InputInfo;
	
	@FindBy(id="submit")
	private WebElement ButtonSubmit;
	
	@FindBy(id="clear")
	private WebElement ButtonClear;
	
	@FindBy(id= "editBTN")
	private WebElement edit;
	
	@FindBy(id= "removeBTN")
	private WebElement delete;
	
	@FindBy(id="EditAmount")
	private WebElement ModalAmount;
	
	@FindBy(id="EditTypeSelector")
	private WebElement ModalType;
	
	@FindBy(id="EditAdditional")
	private WebElement ModalInfo;
	
	@FindBy(id="EditSave")
	private WebElement ButtonSave;
	
	@FindBy(xpath="/html/body/div[3]")
	private WebElement Message;
	
	
	
	
	public WebElement getButtonSave() {
		return ButtonSave;
	}

	public void addEntry(double amount,String type,String info) {
		String amountToStr = String.valueOf(amount);
		
		InputAmount.sendKeys(amountToStr);
		InputInfo.sendKeys(info);
		InputType.sendKeys(type);
	
	}
	
	public void updateEntry(double amount,String type,String info) {
		String amountToStr = String.valueOf(amount);
		
		ModalAmount.sendKeys(amountToStr);
		ModalInfo.sendKeys(info);
		ModalType.sendKeys(type);
	}

	public WebElement getInputAmount() {
		return InputAmount;
	}

	public WebElement getInputType() {
		return InputType;
	}

	public WebElement getInputInfo() {
		return InputInfo;
	}

	public WebElement getButtonSubmit() {
		return ButtonSubmit;
	}

	public WebElement getButtonClear() {
		return ButtonClear;
	}
	public WebElement getEdit() {
		return edit;
	}
	
	public WebElement getDelete() {
		return delete;
	}

	public WebElement getModalAmount() {
		return ModalAmount;
	}

	public WebElement getModalType() {
		return ModalType;
	}

	public WebElement getModalInfo() {
		return ModalInfo;
	}

	public WebElement getMessage() {
		return Message;
	}
	
	
	
	
}
