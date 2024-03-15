package org.TTA.Pages.PageObjectModel;


import io.qameta.allure.Description;
import org.TTA.Base.Common;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Login extends Common {
    //    this is POM contains all the locators and actions/behaviour of  particular page

    By email = By.id("email");
    By password = By.id("pass");
    By signin_btn = By.xpath("//button[@id=\"send2\"]");
    By signin_btn2 = By.xpath("//*[@id=\"send2\"]");
//    By invalidemailerror = By.xpath("//*[@id=\"email-error\"]");
    By fieldreqmsgg = By.partialLinkText("A login and a password are required.");
    By thisfieldreqmsgg = By.id("pass-error");
    By wrongCredAlert = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    By Accountinfo = By.xpath("//div[@class=\"box-content\"]/p");



//    public String errormsg() {
//        presenceOfElement(invalidemailerror);
//        System.out.println(presenceOfElement(invalidemailerror).getText());
//        Assert.assertEquals(getElemnet(invalidemailerror).getText(), "Please enter a valid email address (Ex: johndoe@domain.com).");
//        return getElemnet(invalidemailerror).getText();
//
//    }
    public String WrongCredAlert() {
        presenceOfElement(wrongCredAlert);
        return getElemnet(wrongCredAlert).getText();
    }
    public String password_field_req_error_msg() {
        presenceOfElement(thisfieldreqmsgg);
        System.out.println(presenceOfElement(thisfieldreqmsgg).getText());
//        Assert.assertEquals(getElemnet(thisfieldreqmsgg).getText(), "Please enter a valid email address (Ex: johndoe@domain.com).");
        return getElemnet(thisfieldreqmsgg).getText();

    }
    public String fieldreqmsg() {
        presenceOfElement(fieldreqmsgg);
        Assert.assertEquals(getElemnet(fieldreqmsgg).getText(), "This is a required field.");
        System.out.println(getElemnet(fieldreqmsgg).getText());
        return getElemnet(fieldreqmsgg).getText();

    }
    public String AccountInfo() {
        presenceOfElement(Accountinfo);
        System.out.println(getElemnet(Accountinfo).getText());
        return getElemnet(Accountinfo).getText();
    }

    @Description("Verify Login with valid email and password")
    public Login Verify_Login_with_valid_email_and_password() {
        enterInput(email, "joebiden@gmail.com");
        enterInput(password, "7878198@joe");
        clickElemnet(signin_btn);
        return this;
    }
    @Description("Verify Login with invalid email and invalid password")
    public Login Verify_Login_with_invalid_email_and_invalid_password() {
        enterInput(email, "invalidjoebiden@gmail.com");
        enterInput(password, "invalid7878198@joe");
        clickElemnet(signin_btn);
        return this;
    }

    @Description("Verify Login with valid email and keeping password field empty")
    public Login test_keeping_passwordX_field_empty() throws InterruptedException {
        enterInput(email, "joebiden@gmail.com");
        Thread.sleep(5000);
        enterInput(password,"");
        clickElemnet(signin_btn);
        return this;
    }


    @Description("Verify Login with keeping  fields empty ")
    public Login test_keeping_field_empty() {
        clickElemnet(signin_btn);
        return this;
    }

    @Description("Verify Login with invalid email and valid password")
    public Login test_Negative() throws InterruptedException {
        enterInput(email, "asf@y");
        enterInput(password, "7878198@nik");
        Thread.sleep(5000);
        clickElemnet(signin_btn);
        Thread.sleep(5000);
//        System.out.println(presenceOfElement(invalidemailerror).getText());
        return this;
    }

    // this function is allows you to handover the cotrol to AddToCart class/Page
    public AddToCart afterLogin() {
        return new AddToCart();
    }
}
