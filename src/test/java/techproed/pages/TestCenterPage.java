package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {
    public TestCenterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//*[@class='alert alert-success alert-dismissible fade show']")
    public WebElement verify;

    @FindBy(xpath = "(//i)[2]")
    public WebElement logout;
}
