package com.wbl.qa.tests;

import com.wbl.qa.basePage.BasePage;
import com.wbl.qa.pages.HomePage;
import com.wbl.qa.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BasePage {
    HomePage homePage;
    LoginPage loginPage;

    public HomePageTests() {
        super();
    }

    @BeforeMethod
    public  void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void verifyTitleTest(){

        String  actualTitle = homePage.verifyHomeTitle();
        Assert.assertEquals(actualTitle,"QA/QE/SDET Training.","Titles are not matched");
    }

    @Test(priority = 2)
    public void verifyLogoTest(){
        boolean logo = homePage.verifyLogo();
        Assert.assertTrue(logo,"logo is not present");
    }


    @Test(priority = 3)
    public void verifyLoginTest()
    {
       loginPage = homePage.VerifyLogin();
    }


}
