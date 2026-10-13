package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        drivers.set(webDriver);
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void quitDriver() {

        if (drivers.get() != null) {

            drivers.get().quit();
            drivers.remove();
        }
    }
}