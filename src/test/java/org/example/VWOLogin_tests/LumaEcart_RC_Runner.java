package org.example.VWOLogin_tests;

import io.qameta.allure.Description;
import org.TTA.Driver.DriverManagerTH_Local;
import org.TTA.Pages.PageObjectModel.Login;
import org.example.basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LumaEcart_RC_Runner extends BaseTest {

    @Test(priority = 4)
    @Description("Verify Login with valid email and password")
    public void TC_001() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        String AccountInfo = login.AccountInfo();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(AccountInfo, "Joe Biden\n" +
                "joebiden@gmail.com");
        System.out.println(AccountInfo);
    }
    @Test(priority = 0)
    @Description("Verify Login with invalid email and invalid password")
    public void TC_002() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_invalid_email_and_invalid_password();
        String loginarror = login.WrongCredAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginarror, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        System.out.println(loginarror);
    }
    @Test(priority = 1)
    @Description("Verify L2gin with keeping  fields empty")
    public void TC_003() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.test_keeping_field_empty();
        String loginarror = login.WrongCredAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginarror, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        System.out.println(loginarror);
    }
    @Test(priority = 3)
    @Description("Verify Login with keeping password fields empty")
    public void TC_004() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.test_keeping_passwordX_field_empty();
//        String loginarror = login.WrongCredAlert();
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(loginarror, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
//        System.out.println(loginarror);
    }

}





