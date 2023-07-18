package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.Driver;

public class C02Icin_OpenSourcePageClass {
    public static WebElement username(){
        return Driver.getDriver().findElement(By.xpath("//*[@name='username']"));
    }
    public static WebElement password(){
        return Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
    }
    public static WebElement submitButton(){
        return Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
    }
    public static WebElement verify(){
        return Driver.getDriver().findElement(By.xpath("//h6"));
    }


}
