package org.TTA.Pages.PageObjectModel;


import org.TTA.Base.Common;
import org.TTA.Driver.DriverManagerTH_Local;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class AddToCart extends Common {
//    this is POM contains all the locators and actions/behaviour of  particular page

    private By catwmn = By.id("ui-id-4");
    private By item = By.linkText("Breathe-Easy Tank");
    private By selectsize = By.xpath("//*[@id=\"option-label-size-143-item-166\"]");
    private By selectcolour = By.xpath("//*[@id=\"option-label-color-93-item-59\"]");
    private By addtocartbtn = By.xpath("//button[@id=\"product-addtocart-button\"]");
//    By addtocartmsg = By.partialLinkText("You added Breathe-Easy Tank to your ");
//    By cartIcon = By.linkText("My Cart");
    private By cartIcon = By.xpath("//a[contains(@class,\"action showcart\")]");
    private By procedtochkout = By.xpath("//button[@id=\"top-cart-btn-checkout\"]");
    private By radiobtn = By.xpath("//input[@class=\"radio\"]");
    private By next = By.xpath("//button[@type=\"submit\"]");
    private By placeorder = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
    private By thkumsg= By.linkText("Thank you for your purchase!");

    public AddToCart Chkout() throws InterruptedException {

        clickElemnet(catwmn);
        clickElemnet(item);
        clickElemnet(selectsize);
        clickElemnet(selectcolour);
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickElemnet(addtocartbtn);
//        System.out.println(presenceOfElement(addtocartmsg).getText());
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickElemnet(cartIcon);
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        presenceOfElement(procedtochkout).click();
        clickElemnet(radiobtn);
        presenceOfElement(next).click();
        presenceOfElement(placeorder).click();
        System.out.println(presenceOfElement(thkumsg));

        return this;
    }
}
