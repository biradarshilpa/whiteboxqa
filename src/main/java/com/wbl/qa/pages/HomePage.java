package com.wbl.qa.pages;

import com.wbl.qa.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@id = 'logo']")
    WebElement wbllogo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement homeBtn;

    @FindBy(xpath = "//a[@id = 'loginButton' and @href ='login.php']")
    WebElement loginBtn;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomeTitle(){
       String title = driver.getTitle();
       return title;
    }

    public boolean verifyLogo(){
        boolean logo = wbllogo.isDisplayed();
        return logo;
    }

    public LoginPage VerifyLogin(){
      boolean login =  loginBtn.isDisplayed();
      loginBtn.click();
      return new LoginPage();


    }




}
