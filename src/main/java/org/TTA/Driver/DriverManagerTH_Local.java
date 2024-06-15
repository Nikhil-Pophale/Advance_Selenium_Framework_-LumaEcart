package org.TTA.Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.util.Objects;

public class DriverManagerTH_Local {
//    BUt as far this is the bad practise insted off this use > > >

    //    THread Local > >

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    public static final ThreadLocal<Any thing you want to keep safe from thread keep here> dr=new ThreadLocal<>();


    public static void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
    }

    public static void init() throws MalformedURLException {
        if (Objects.isNull(DriverManagerTH_Local.getDriver())) {
//            ChromeOptions options=new ChromeOptions();
//            options.addArguments("--headless");
//            WebDriver driver = new ChromeDriver(options);
            WebDriver driver = new ChromeDriver();
            setDriver(driver);
        }
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTH_Local.getDriver())) {
//            getDriver().close();
//            getDriver().quit();
            unload();
        }
    }
}