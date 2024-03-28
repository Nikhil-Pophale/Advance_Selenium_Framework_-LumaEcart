package org.TTA.Pages.PageObjectModel;


import org.TTA.Base.Common;
import org.TTA.Driver.DriverManagerTH_Local;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AddToCart extends Common {
//    this is POM contains all the locators and actions/behaviour of  particular page

    private By catwmn = By.id("ui-id-4");
    private By itemBag = By.xpath("//a[@title=\"Push It Messenger Bag\"]");
    private By itemBottle = By.xpath("//img[@alt=\"Affirm Water Bottle \"]");

//    private By addtocartbtn = By.xpath("//button[@id=\"product-addtocart-button\"]");
    private By addtocartbtn = By.id("product-addtocart-button");
    private By viewCart = By.xpath("//a[@class=\"action viewcart\"]");
    By addedtocartmsg = By.xpath("//div[@role=\"alert\"]/div/div");
    //    By cartIcon = By.linkText("My Cart");
    private By cartIcon = By.xpath("//a[contains(@class,\"action showcart\")]");
//    private By cartIcon = By.xpath("//span[@class=\"counter qty\"]");
    private By procedtochkout = By.xpath("//button[@id=\"top-cart-btn-checkout\"]");
    private By radiobtn = By.xpath("//input[@class=\"radio\"]");
    private By next = By.xpath("//button[@type=\"submit\"]");
    private By placeorder = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button");
    private By thkumsg = By.linkText("Thank you for your purchase!");
    private By deletebtnCartlist = By.xpath("//a[@class=\"action action-delete\"]");
    private By addtoWishlistbtn = By.xpath("//span[text()=\"Add to Wish List\"]");
    private By addtoWishlistMsg = By.xpath("//div[@data-ui-id=\"message-success\"]");
    private By gearCategory = By.xpath("//span[text()=\"Gear\"]");
    private By lumalogo = By.xpath("//a[@class=\"logo\"]");
    private By outofstockmsg = By.xpath("//div[text()=\"The requested qty is not available\"]");

    public AddToCart addtoCart_which_is_not_in_stock() throws InterruptedException {
        clickElemnet(lumalogo);
        clickElemnet(itemBag);
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickElemnet(addtocartbtn);
//        System.out.println(presenceOfElement(addtocartmsg).getText());
        Thread.sleep(7000);
        clickElemnet(cartIcon);
//        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        presenceOfElement(procedtochkout).click();
//        clickElemnet(radiobtn);
//        presenceOfElement(next).click();
//        presenceOfElement(placeorder).click();
//        System.out.println(presenceOfElement(thkumsg));

        return this;
    }

    public AddToCart addtoCart() throws InterruptedException {
        clickElemnet(lumalogo);
        clickElemnet(gearCategory);
//        FluentWait(itemBottle);
        clickElemnet(itemBottle);
        Thread.sleep(4000);
        clickElemnet(addtocartbtn);
        System.out.println(presenceOfElement(addedtocartmsg).getText());

        return this;
    }

    public AddToCart addtoWishlist() throws InterruptedException {
        clickElemnet(lumalogo);
        clickElemnet(gearCategory);
        clickElemnet(itemBottle);
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FluentWait(addtoWishlistbtn);
        clickElemnet(addtoWishlistbtn);
        System.out.println(addtoWishlistMsg);

        return this;
    }

    public AddToCart removeFromCart() throws InterruptedException {
//        clickElemnet(lumalogo);
//        clickElemnet(gearCategory);
//        clickElemnet(itemBottle);
//        FluentWait(addtocartbtn);
//        clickElemnet(addtocartbtn);
        addtoCart();
        FluentWait(cartIcon);
        clickElemnet(cartIcon);
        FluentWait(viewCart);
        clickElemnet(viewCart);
        clickElemnet(deletebtnCartlist);
        return this;
    }

    public String outofstk() {
        presenceOfElement(outofstockmsg);
        return getElemnet(outofstockmsg).getText();
    }

    public String addedtowishlistmsg() {
        try {
            presenceOfElement(addtoWishlistMsg);
        } catch (Exception e) {
            presenceOfElement(addtoWishlistMsg);
        }

        return getElemnet(addtoWishlistMsg).getText();
    }

    public Checkout afterAtoCart() {
        return new Checkout();
    }
}
