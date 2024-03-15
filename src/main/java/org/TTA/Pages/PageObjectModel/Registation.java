package org.TTA.Pages.PageObjectModel;


import io.qameta.allure.Description;
import org.TTA.Base.Common;
import org.TTA.Base.faker;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

public class Registation extends Common {

//    this is POM contains all the locators and actions/behaviour of  particular page


    public Registation() {
    }

    By firstname = By.xpath("//*[@id=\"firstname\"]");
    By lastname = By.xpath("//*[@id=\"lastname\"]");
    By email = By.id("email_address");
    By password = By.xpath("//*[@id=\"password\"]");
    By confirm_password = By.xpath("//*[@name=\"password_confirmation\"]");
    By crreateac_btn = By.xpath("//button[@title=\"Create an Account\"]");
    By IE_error_text = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    By IEmail_error = By.id("email_address-error");
    By requiredfield_error = By.id("firstname-error");
    //    By confirmmsg = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    By confirmmsg = By.xpath("//*[text()=\"Thank you for registering with Main Website Store.\"]");


    @Description("TC_002\tVerify Registration with  Invalid email and appropriate error message is displayed")
    public Registation TC_002() {
        enterInput(firstname,faker.fname());
        enterInput(lastname, faker.lname());
        enterInput(email, "invalidemail");
        enterInput(password, "7878198this");
        enterInput(confirm_password, "7878198this");
        clickElemnet(crreateac_btn);
        System.out.println(getElemnet(IEmail_error).getText());
        Assert.assertEquals(getElemnet(IEmail_error).getText(), "Please enter a valid email address (Ex: johndoe@domain.com).");
        return this;
    }

    public String ALerror() {
        presenceOfElement(IE_error_text);
        return getElemnet(IE_error_text).getText();

    }
    public String ReqFieldError() {
        presenceOfElement(requiredfield_error);
        return getElemnet(requiredfield_error).getText();

    }

    @Description("TC_003 -Verify Registration with already registered email and respective error-msg pop-up")
    public Registation TC_003() throws InterruptedException {

        enterInput(firstname, "Simran");
        enterInput(lastname, "kk");
        enterInput(email, "joebieden@gmail.com");
        enterInput(password, "7878198@This");
        enterInput(confirm_password, "7878198@This");
        clickElemnet(crreateac_btn);
        Thread.sleep(5000);
        return this;

    }

    @Description("TC_004 -Verify Registration with keeping all fields empty and Error message should displayed ")
    public Registation TC_004() {

        clickElemnet(crreateac_btn);
        System.out.println(getElemnet(requiredfield_error).getText());
        Assert.assertEquals(getElemnet(requiredfield_error).getText(), "This is a required field.");

        return this;
    }

    public String confirmmsgx() {
        presenceOfElement(confirmmsg);
        return getElemnet(confirmmsg).getText();

    }


    @Description("TC_001 -Verify Registration with all valid data")
    public Registation TC_001() throws IOException {

        enterInput(firstname, faker.fname());
        enterInput(lastname, faker.lname());
        enterInput(email, faker.email());
        enterInput(password, "7878198@Tthis");
        enterInput(confirm_password, "7878198@Tthis");
        clickElemnet(crreateac_btn);
        takeScreenShot();
//        presenceOfElement(confirmmsg).getText();
//        System.out.println(getElemnet(confirmmsg).getText());
//        Assert.assertEquals(getElemnet(confirmmsg).getText(), "Thank you for registering with Main Website Store.");

        return this;
    }

    // this function is allows you to handover the cotrol to login class/Page
    public Login afterReg() {
        return new Login();
    }
}
