package org.example.Runner_Tests;

import io.qameta.allure.Description;
import org.TTA.Naukri_Page.homepage;
import org.TTA.Pages.PageObjectModel.AddToCart;
import org.TTA.Pages.PageObjectModel.Checkout;
import org.TTA.Pages.PageObjectModel.Login;
import org.TTA.Pages.PageObjectModel.Registation;
import org.example.basic.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LumaEcart_RC_Runner extends BaseTest {

    @Test(priority = 4)
    @Description("Verify Login with valid email and password")
    public void Verify_Login_with_valid_email_and_password() throws Exception {
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
    public void Verify_Login_with_invalid_email_and_invalid_password() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_invalid_email_and_invalid_password();
        String loginarror = login.WrongCredAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginarror, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        System.out.println(loginarror);
    }

    @Test(priority = 1)
    @Description("Verify Login with keeping  fields empty")
    public void Verify_Login_with_keeping_fields_empty() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.test_keeping_field_empty();
        String loginarror = login.WrongCredAlert();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginarror, "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
        System.out.println(loginarror);
    }

    @Test(priority = 2)
    @Description("Verify Login with keeping password fields empty")
    public void Verify_Login_with_keeping_password_fields_empty() throws Exception {
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
    public void Verify_Registration_with__Invalid_email_and_appropriate_error_message_is_displayed() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_Invalid_email();
        String error_msg = registation.EmailErrormsg();
        Assert.assertEquals(error_msg, "Please enter a valid email address (Ex: johndoe@domain.com).");
        System.out.println(error_msg);
    }

    @Description("Verify Registration with  already email registered and appropriate error message is displayed")
    @Test(priority = 5)
    public void Verify_Registration_with_already_email_registered_and_appropriate_error_message_is_displayed() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_already_registered_email();
        String error_msg = registation.ALerror();
        Assert.assertEquals(error_msg, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
        System.out.println(error_msg);
    }

    @Description("Verify Registration with  Keeping all the fields empty")
    @Test(priority = 6)
    public void Verify_Registration_with__Keeping_all_the_fields_empty() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.TC_004();
        String req_field_error = registation.ReqFieldError();
        Assert.assertEquals(req_field_error, "This is a required field.");
        System.out.println(req_field_error);
    }

    @Test(priority = 7)
    @Description("Verify Registration with Invalid weak password ")
    public void Verify_Registration_with_Invalid_weak_password() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_Invalid_weak_password();
        String WeakPassError = registation.WeakPassError();
        Assert.assertEquals(WeakPassError, "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
        System.out.println(WeakPassError);
    }

    @Test(priority = 8)
    @Description("Verify Registration with valid data")
    public void Verify_Registration_with_valid_data() throws Exception {
        Registation registation = new Registation();
        registation.openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
        registation.Registration_with_all_valid_data();
        String ConfirmRegtxt = registation.confirmmsgx();
        Assert.assertEquals(ConfirmRegtxt, "Thank you for registering with Main Website Store.");
        System.out.println(ConfirmRegtxt);
    }

    @Test(priority = 9)
    @Description("Verify Add to cart when Sku is out of Stock")
    public void Verify_Add_to_cart_when_Sku_is_out_of_Stock() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        AddToCart addToCart = new AddToCart();
        addToCart.addtoCart_which_is_not_in_stock();
        String OtofStock = addToCart.outofstk();
        Assert.assertEquals(OtofStock, "The requested qty is not available");
        System.out.println(OtofStock);
    }

    @Test(priority = 10)
    @Description("Verify_user_can_add_product__to_cart_and_is_reflected_in_list")
    public void Verify_user_can_add_product_to_cart_and_is_reflected_in_list() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        AddToCart addToCart = new AddToCart();
        addToCart.addtoCart();
        String addtocartNotify = addToCart.AddedtoCartmsg();
        System.out.println(addtocartNotify);
    }

    @Test(priority = 11)
    @Description("Verify_Add_to_cart_Add_to_Wishlist_Functionality")
    public void Verify_Add_to_cart_Add_to_Wishlist_Functionality() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        AddToCart addToCart = new AddToCart();
        addToCart.addtoWishlist();
        String AddedtoWishlistNotify = addToCart.addedtowishlistmsg();
        Assert.assertEquals(AddedtoWishlistNotify, "Affirm Water Bottle has been added to your Wish List. Click here to continue shopping.");
        System.out.println(AddedtoWishlistNotify);
    }

//    @Test(priority = 12)
//    @Description("Verify Registration with Invalid weak password ")
//    public void TC_013() throws Exception {
//        Login login = new Login();
//        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
//        login.Verify_Login_with_valid_email_and_password();
//        AddToCart addToCart = new AddToCart();
//        addToCart.addtoWishlist();
//        String AddedtoWishlistNotify = addToCart.addedtowishlistmsg();
//        Assert.assertEquals(AddedtoWishlistNotify, "Affirm Water Bottle has been added to your Wish List. Click here to continue shopping.");
//        System.out.println(AddedtoWishlistNotify);
//    }

    @Test(priority = 13)
    @Description("Verify_user_can_remove_product_from_Cart_list")
    public void Verify_user_can_remove_product_from_Cart_list() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password().afterLogin();
        AddToCart addToCart = new AddToCart();
        addToCart.removeFromCart();

    }

    @Test(priority = 14)
    @Description("Verify_user_can_add_product__to_cart_and_is_reflected_in_list")
    public void Verify_user_can_add_product__to_cart_and_is_reflected_in_list() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password().afterLogin();
        AddToCart addToCart = new AddToCart();
        addToCart.addtoCart();
        Checkout checkout = new Checkout();
        checkout.placeanOrder();
//        Checkout checkout = new AddToCart().addtoCart().afterAtoCart();
//        checkout.placeanOrder();
        String ThanksMsg = checkout.confirmatoionMsg();
        Assert.assertEquals(ThanksMsg, "Thank you for your purchase!");
        System.out.println(ThanksMsg);
    }

    @Test(priority = 15)
    @Description("Verify Checkout without selecting Shipping methods")
    public void Verify_Checkout_without_selecting_Shipping_methods() throws Exception {
        AddToCart addToCart = new AddToCart();
        addToCart.openUrl("https://magento.softwaretestingboard.com/");
        Checkout checkout = new AddToCart().addtoCart().afterAtoCart();
        checkout.Checkout_without_selecting_Shipping_methods();
        String ErrorMsg = checkout.shippingMethodMissingErrorMsgx();
        Assert.assertEquals(ErrorMsg, "The shipping method is missing. Select the shipping method and try again.");
//        System.out.println(ErrorMsg);
    }

    @Test(priority = 16)
    @Description("Verify Order_billing_reflected_on_checkout_page")
    public void Verify_Order_billing_reflected_on_checkout_page() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        Checkout checkout = new AddToCart().addtoCart().afterAtoCart();
        checkout.Order_billing_reflected_on_checkout_page();
        String bill = checkout.billSummary();
        Assert.assertNotNull(bill);
        System.out.println(bill);
    }

    @Test(priority = 17)
    @Description("Verify purchase_with_applying_invalid_discount_code")
    public void Verify_purchase_with_applying_invalid_discount_code() throws Exception {
        Login login = new Login();
        login.openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
        login.Verify_Login_with_valid_email_and_password();
        Checkout checkout = new AddToCart().addtoCart().afterAtoCart();
        checkout.purchase_with_applying_invalid_discount_code();
//        String errormsg = checkout.();
//       Assert.assertNotNull(address);
//     System.out.println(address);
    }

    @Test
    public void Verify_update_profile_removedot() throws Exception {
        homepage H = new homepage();
        H.update_Profile_remove_dot();
    }

    @Test
    public void Verify_update_profile_dot() throws Exception {
        homepage H = new homepage();
        H.update_Profile_with_dot();
    }


}





