package org.TTA.Base;

import org.TTA.Driver.DriverManagerTH_Local;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Common {
    public Common() {
    }

    //    It might have 1>waits2>drivers 3>locartors 4>common things
    public void implicitWait(int sec) {
        DriverManagerTH_Local.getDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    //this is the example of method overloading
    public void clickElemnet(By by) {
        DriverManagerTH_Local.getDriver().findElement(by).click();
    }
//    public void Actions(By locator) {
//      Actions actions=new Actions(DriverManagerTH_Local.getDriver());
//      actions.moveToElement((WebElement) locator).c;
//    }

    public void iWaitForElementToBeVisible(By loc, int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManagerTH_Local.getDriver(), Duration.ofSeconds(second));
            wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
        } catch (Exception e) {
            System.out.println("Failed to Wait!: " + e.toString());
        }
    }

    public void FluentWait(By locator) {
        WebElement wait = new FluentWait<WebDriver>(DriverManagerTH_Local.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void elementToBeClickableFluentWait(By locator) {
        WebElement wait = new FluentWait<WebDriver>(DriverManagerTH_Local.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void clear(By by) {
        DriverManagerTH_Local.getDriver().findElement(by).clear();
    }
    public void ActionClassClick(WebElement loc) {
        Actions actions=new Actions( DriverManagerTH_Local.getDriver());
                actions.moveToElement(loc).click();
    }

    public void openUrl(String url) {
        DriverManagerTH_Local.getDriver().get(url);
    }

    public void navigateback() {
        DriverManagerTH_Local.getDriver().navigate().back();
    }
    public void pageloadtimeout() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
    }
//    public void pageloadtimeout(int second) {
//       DriverManagerTH_Local.getDriver().manage().timeouts().pageLoadTimeout(second,TimeUnit.SECONDS);
//    }

    //this is the example of method overloading
    protected void enterInput(By by, String key) {
        DriverManagerTH_Local.getDriver().findElement(by).sendKeys(key);
    }

    public WebElement getElemnet(By key) {
        return DriverManagerTH_Local.getDriver().findElement(key);
    }

    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTH_Local.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) DriverManagerTH_Local.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\nikpo\\IdeaProjects\\LumaEcart\\src\\main\\java\\org\\TTA\\ScreenShots" + faker.randomno() + ".jpg"));

    }
}
