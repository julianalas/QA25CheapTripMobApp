package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests_JulianaLas extends TestBase{
    @Test
    public void start() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Hello!");
    }

//attention, on the tested device the default language is Russian
    @Test(groups = "UI")
    public void sloganIsDisplayed(){
        WebElement slogan = driver.findElement(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view." +
                        "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.V" +
                        "iew/android.view.View/android.view.View/android.view.View/android.view." +
                        "View/android.view.View/android.view.View/android.view.View/android.view." +
                        "View/android.view.View[1]/android.view.View[2]/android.view.View[2]"));

        System.out.println(slogan.getText());
        Assert.assertEquals(slogan.getText(), "CheapTrip.Плати меньше, посети больше");

    }

    @Test(priority = 1, groups = {"functional"})
    public void changeLanguageValidationTest() throws InterruptedException {
        WebElement selectLang = driver.findElement(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."+
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view."+
                        "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view."+
                        "View/android.view.View/android.view.View/android.view.View/android.view.View/android.view."+
                        "View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android."+
                        "view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view."+
                        "View/android.widget.ListView/android.widget.Button"));
        Thread.sleep(5000);
        selectLang.click();
        Thread.sleep(5000);
        WebElement selectEnglishLanguage = driver.findElement(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."+
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view."+
                        "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view"+
                        ".View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android"+
                        ".view.View/android.view.View/android.view.View[1]/android.view.View/android.view."+
                        "View[1]/android.view.View/android.widget.RadioButton/android.widget.Button"));
        selectEnglishLanguage.click();
        WebElement titleEnglishLanguage = driver.findElement(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."+
                        "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view."+
                        "ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view."+
                        "View/android.view.View/android.view.View/android.view.View/android.view.View/android.view."+
                        "View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android."+
                        "view.View/android.view.View[1]/android.view.View"));
        Assert.assertEquals(titleEnglishLanguage.getText(),
                "Discover the cheapest way to get anywhere combining plane, train, bus and rideshare");

    }
}
