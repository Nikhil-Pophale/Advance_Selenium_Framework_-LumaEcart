package org.TTA.Base;

import org.TTA.Driver.DriverManagerTH_Local;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void iWaitForElementToBeVisible(WebElement loc,int second) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManagerTH_Local.getDriver(), Duration.ofSeconds(second));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
        } catch (Exception e) {
            System.out.println("Failed to Wait!: " + e.toString());
        }
    }
    public void clear(By by) {
        DriverManagerTH_Local.getDriver().findElement(by).clear();
    }

    public void openUrl(String url) {
        DriverManagerTH_Local.getDriver().get(url);
    }
    public void navigateback() {
        DriverManagerTH_Local.getDriver().navigate().back();
    }

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
    public  void takeScreenShot() throws IOException {
        File file=((TakesScreenshot)DriverManagerTH_Local.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:\\Users\\nikpo\\IdeaProjects\\LumaEcart\\src\\main\\java\\org\\TTA\\ScreenShots"+faker.randomno()+".jpg"));

    }
}
