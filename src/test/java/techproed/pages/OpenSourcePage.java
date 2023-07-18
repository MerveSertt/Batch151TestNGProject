package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
    TestNG'de locate'lerimizi pages package'ı altında oluşturduğumuz class'lar içinde alırız.
    Bu class içinde driver'ımızı tanımlamak ve webelementleri oluşturabilmek için constructer oluşturup
    bu constructer içinde PageFactory class'ından initelements methodunu kullanarak driver'ımızı bu class'a tanımlarız.
     */
    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);

        /*
        WebElementleri locate edebilmek için findElement() methodu kullanıyorduk @FindBy notasyonu ile
        artık findElement() methodunu kullanmayıp @FindBy notasyonu içinde driver'ın yerini tarif etmemiz gerekiyor.
            Yukarıdaki (Driver.getDriver(),this) komutu burada ihtiyaç duyduğum driver, Driver class'ındaki
            getDriver() methodundaki driver demek oluyor.
         */
    }
        @FindBy(xpath = "//*[@name='username']")
        public WebElement username;
         @FindBy(xpath = "//input[@name='password']")
         public WebElement password;
          @FindBy(xpath = "//button[@type='submit']")
          public WebElement submitbutton;
         @FindBy(xpath = "//h6")
         public WebElement verify;





}
