package com.wbl.qa.pages;

import com.wbl.qa.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    WebElement loginlogo;
    @FindBy(xpath = "//input[@id = 'username']")
    WebElement username;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement password;
    @FindBy(xpath = "//button[@id = 'login']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@id = 'register']")
    WebElement registerButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyLoginTitle(){
      String actualT =  driver.getTitle();
      return actualT;
    }

    public boolean VerifyLoginLogo(){
      boolean b = loginlogo.isDisplayed();
      return b;
    }

    public boolean verifyLoginButton(){
      boolean b1 = loginButton.isEnabled();
      return b1;
    }

    public boolean verifyRegisterButton(){
        boolean b2 = registerButton.isEnabled();
        return b2;
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public void verifyLogindata(String Uname,String pwd){
        username.sendKeys(Uname);
        password.sendKeys(pwd);
        loginButton.click();

    }



}
