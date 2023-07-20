package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class OdevClass {
    @Test
    public void test01() {
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
        //Acceptance Criteria:
        //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
        //Hata Mesaji:
        //Bad credentials
        //Test Data:
        //Customer email: jack@gmail.com
        //Customer password: fakepass
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        rentalPage.email.sendKeys(ConfigReader.getProperty("Customeremail"), Keys.TAB,ConfigReader.getProperty("Customerpassword"),Keys.ENTER);
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(rentalPage.badCredentials.isDisplayed());
        Driver.closeDriver();

    }
}
