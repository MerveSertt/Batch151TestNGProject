package techproed.tests.day26_PageKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {
    @Test
    public void test01() {

        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        //Admin email: jack@gmail.com
        //Admin password: 12345
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);

        //Admin email: jack@gmail.com -->.properties dosyasında
        //Admin password: 12345 -->.properties dosyasında
        rentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalemail"), Keys.TAB ,
                ConfigReader.getProperty("blueRentalpassword"),Keys.ENTER);

        //Giriş yapıldığını doğrulayalım
        Assert.assertTrue(rentalPage.verify.getText().contains("Jack"));

        //Sayfayı kapatınız

    }
}
