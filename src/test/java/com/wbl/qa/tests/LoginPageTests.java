package com.wbl.qa.tests;

import com.wbl.qa.basePage.BasePage;
import com.wbl.qa.pages.HomePage;
import com.wbl.qa.pages.LoginPage;
import com.wbl.qa.util.TestUtil;
import com.wbl.qa.util.TestUtilLogin;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends BasePage {
    LoginPage loginPage;
    HomePage homePage;
    String  SheetName = "Logindata";
    public LoginPageTests(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage= new HomePage();
        homePage.VerifyLogin();
    }

    @Test
    public void verifyLoginTitleTest(){
       String actualTitle = loginPage.verifyLoginTitle();
        Assert.assertEquals(actualTitle,"QA/QE/SDET Training.","Title is not matched");

    }
    @Test
    public void verifyLoginLogoTest(){
       boolean b = loginPage.VerifyLoginLogo();
       Assert.assertTrue(b,"logo is not displayed");
    }
    @Test
    public void verifyLoginButtonTest(){
        boolean b = loginPage.verifyLoginButton();
        Assert.assertTrue(b,"login button is not enabled");

    }
    @Test
    public void verifyRegisterButtonTest(){
        boolean b = loginPage.verifyRegisterButton();
        Assert.assertTrue(b,"Register button is not enabled");

    }

    @DataProvider
    public Object[][] getLoginData(){
        Object data[][]= TestUtilLogin.getData(SheetName);
        return data;
    }

    @Test(dataProvider =  "getLoginData")
    public void verifyLoginDetailsTest(String username , String password){
       loginPage.verifyLogindata(username,password);

    }

}
