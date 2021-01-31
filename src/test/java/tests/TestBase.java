package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        final String baseDir = System.getProperty("user.dir") + "/app";
        System.out.println("current dir = " + baseDir);

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus_5");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "io.ionic.starter");
        capabilities.setCapability("appActivity", "io.ionic.starter.MainActivity");
        capabilities.setCapability("app", baseDir + "/app-debug.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }



    @AfterMethod
    public void quitApp(){
        driver.closeApp();
        driver.quit();
    }

}
