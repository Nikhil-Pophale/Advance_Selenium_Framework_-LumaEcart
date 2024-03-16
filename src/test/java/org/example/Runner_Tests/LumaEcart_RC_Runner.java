package org.example.Runner_Tests;

import io.qameta.allure.Description;
import org.TTA.Pages.PageObjectModel.Login;
import org.TTA.Pages.PageObjectModel.Registation;
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
    @Test(priority = 3)
    @Description("Verify Registration with  Invalid email and appropriate error message is displayed")
    public void TC_006() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_Invalid_email();
        String error_msg=registation.EmailErrormsg();
        Assert.assertEquals(error_msg, "Please enter a valid email address (Ex: johndoe@domain.com).");
        System.out.println(error_msg);
    }
    @Description("Verify Registration with  Invalid email and appropriate error message is displayed")
    @Test
    public void TC_007() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_already_registered_email();
        String error_msg=registation.ALerror();
        Assert.assertEquals(error_msg, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
        System.out.println(error_msg);
    }
    @Description("Verify Registration with  Keeping all the fields empty")
    @Test
    public void TC_008() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.TC_004();
        String req_field_error=registation.ReqFieldError();
        Assert.assertEquals(req_field_error, "This is a required field.");
        System.out.println(req_field_error);
    }

    @Test
    @Description("Verify Registration with Invalid weak password ")
    public void TC_009() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_Invalid_weak_password();
        String WeakPassError=registation.WeakPassError();
        Assert.assertEquals(WeakPassError, "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
        System.out.println(WeakPassError);
    }
    @Test
    @Description("Verify Registration with Invalid weak password ")
    public void TC_010() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_all_valid_data();
        String ConfirmRegtxt=registation.confirmmsgx();
        Assert.assertEquals(ConfirmRegtxt, "Thank you for registering with Main Website Store.");
        System.out.println(ConfirmRegtxt);
    }

}





