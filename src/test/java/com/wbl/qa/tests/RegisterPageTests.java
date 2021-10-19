package com.wbl.qa.tests;

import com.wbl.qa.basePage.BasePage;
import com.wbl.qa.pages.HomePage;
import com.wbl.qa.pages.LoginPage;
import com.wbl.qa.pages.RegisterPage;
import com.wbl.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTests extends BasePage {
    HomePage homepage;
    LoginPage loginPage;
    RegisterPage registerPage;
    String sheetName = "RegisterTestData";
    public RegisterPageTests(){
        super();

    }
@BeforeMethod
    public void setUp(){
        initialization();
        homepage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        homepage.VerifyLogin();
        loginPage.clickOnRegisterButton();
    }

    @Test(priority = 1)
    public void verifyRegistrationLogo(){
       boolean logo = registerPage.verifyRegisterLogo();
        Assert.assertTrue(logo,"logo id not present");

    }

   @DataProvider
    public Object[] getRegisterData(){
        Object data[][]=TestUtil.getData(sheetName);
        return data;
    }



    @Test(priority = 2,dataProvider = "getRegisterData")
    public void verifyRegisterDetailsTest(String username,String password,String fullname,String phone,String address,String city,String zip,String country ){
     // registerPage.verifyRegisterDetails("shilpa@gmail.com","shilpa1","shilpa biradar", "1245","aaa","fremont","123");
          registerPage.verifyRegisterDetails(username,password,fullname,phone,address,city,zip,country);
    }

}
