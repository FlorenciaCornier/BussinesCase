package config;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class Utils {
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void scrollToTopPage(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
    }
}