package org.TTA.Pages.PageObjectModel;

import org.TTA.Base.Common;
import org.TTA.Driver.DriverManagerTH_Local;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Checkout extends Common {
    private By shippingAddress = By.xpath("//div[@class=\"shipping-address-item selected-item\"]");
    private By NextBtn = By.xpath("//button[@data-role=\"opc-continue\"]");
    private By NextBtn2 = By.xpath("//span[text()=\"Next\"]");
    private By cartIcon = By.xpath("//a[@class=\"action showcart\"]");
    //    private By cartIcon = By.xpath("//span[text()=\"My Cart\"]");
    private By procedtocheckoutbtn = By.id("top-cart-btn-checkout");
//    private By addDiscountCodeBtn = By.xpath("//span[@id=\"block-discount-heading\"]");
    private By addDiscountCodeBtn = By.id("block-discount-heading");
    private By InputDiscountCode = By.id("discount-code");
    private By applyDiscountbtn = By.xpath("//button[@class=\"action action-apply\"]");
    private By invalidDiscountCodeError = By.xpath("//div[text()=\"The coupon code isn't valid. Verify the code and try again.\"]");
    private By billDetails = By.xpath("//div[@class=\"opc-block-summary\"]");
    private By shippingMethodMissingErrorMsg = By.xpath("//div[@role=\"alert\"]");
    private By orderNumber = By.xpath("//div[@class=\"checkout-success\"]");
    private By confirmationMsg = By.xpath("//span[text()=\"Thank you for your purchase!\"]");
    private By placeOrderbtn = By.xpath("//button[@class=\"action primary checkout\"]");
    private By ShippingMethodFlatRateRadioBtn = By.xpath("//input[@name=\"ko_unique_1\"]");
    private By ShippingMethodmissingerrorMsg = By.xpath("//span[text()=\"The shipping method is missing. Select the shipping method and try again.\"]");

    public Checkout placeanOrder() throws InterruptedException {

        FluentWait(cartIcon);
        clickElemnet(cartIcon);
//        ActionClassClick(cartIcon);
        FluentWait(procedtocheckoutbtn);
        clickElemnet(procedtocheckoutbtn);
//        iWaitForElementToBeVisible(ShippingMethodFlatRateRadioBtn,20);
        FluentWait(ShippingMethodFlatRateRadioBtn);
        clickElemnet(ShippingMethodFlatRateRadioBtn);
        System.out.println(shippingAddress());
//        System.out.println(billSummary());
        clickElemnet(NextBtn);
        FluentWait(placeOrderbtn);
        clickElemnet(placeOrderbtn);
        FluentWait(confirmationMsg);
        System.out.println(confirmatoionMsg());
        System.out.println(getOrderid());

        return this;
    }

    public Checkout Shipping_Address_shown_at_timefcheckout() throws InterruptedException {
        FluentWait(cartIcon);
        clickElemnet(cartIcon);
        FluentWait(procedtocheckoutbtn);
        clickElemnet(procedtocheckoutbtn);
//        iWaitForElementToBeVisible(ShippingMethodFlatRateRadioBtn,20);
        FluentWait(ShippingMethodFlatRateRadioBtn);
        clickElemnet(ShippingMethodFlatRateRadioBtn);
        System.out.println(shippingAddress());

        return this;
    }

    public Checkout Checkout_without_selecting_Shipping_methods() throws InterruptedException {
        FluentWait(cartIcon);
        clickElemnet(cartIcon);
        FluentWait(procedtocheckoutbtn);
        clickElemnet(procedtocheckoutbtn);
        FluentWait(NextBtn);
        clickElemnet(NextBtn);
        Thread.sleep(7000);
        FluentWait(shippingMethodMissingErrorMsg);
        System.out.println(shippingMethodMissingErrorMsgx());
        return this;
    }

    public Checkout Order_billing_reflected_on_checkout_page() throws InterruptedException {
        Thread.sleep(5000);
        clickElemnet(cartIcon);
        FluentWait(procedtocheckoutbtn);
        clickElemnet(procedtocheckoutbtn);
        FluentWait(ShippingMethodFlatRateRadioBtn);
        clickElemnet(ShippingMethodFlatRateRadioBtn);
        clickElemnet(NextBtn);
        FluentWait(billDetails);
        presenceOfElement(billDetails);
        System.out.println(billSummary());
        return this;
    }

    public Checkout purchase_with_applying_invalid_discount_code() throws InterruptedException {
        FluentWait(cartIcon);
        clickElemnet(cartIcon);
        FluentWait(procedtocheckoutbtn);
        clickElemnet(procedtocheckoutbtn);
        FluentWait(ShippingMethodFlatRateRadioBtn);
        clickElemnet(ShippingMethodFlatRateRadioBtn);
        FluentWait(NextBtn);
        clickElemnet(NextBtn);
//        pageloadtimeout();
        FluentWait(addDiscountCodeBtn);
//        ActionClassClick((WebElement) addDiscountCodeBtn);
        Thread.sleep(9000);
        clickElemnet(addDiscountCodeBtn);
        FluentWait(InputDiscountCode);
        enterInput(InputDiscountCode, "inValidDiscountCode");
        clickElemnet(applyDiscountbtn);
        presenceOfElement(invalidDiscountCodeError);
        System.out.println(getElemnet(invalidDiscountCodeError).getText());
        return this;
    }

    public String shippingMethodMissingErrorMsgx() {
        FluentWait(shippingMethodMissingErrorMsg);
        return getElemnet(shippingMethodMissingErrorMsg).getText();
    }

    public String shippingAddress() {
        FluentWait(shippingAddress);
        presenceOfElement(shippingAddress);
        return getElemnet(shippingAddress).getText();
    }

    public String billSummary() {
        presenceOfElement(billDetails);
        return getElemnet(billDetails).getText();
    }

    public String confirmatoionMsg() {
        presenceOfElement(confirmationMsg);
        return getElemnet(confirmationMsg).getText();
    }

    public String getOrderid() {
        presenceOfElement(orderNumber);
        return getElemnet(orderNumber).getText();
    }

}
