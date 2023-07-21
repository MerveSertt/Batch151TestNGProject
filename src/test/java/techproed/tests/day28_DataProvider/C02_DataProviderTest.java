package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"},{"audi"},{"mercedes"},{"ford"}};
    }





    /*
     Google sayfasina gidip
     DataProvider ile belirtilen arac isimlerini aratalim
     */

    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
    //Google sayfasına git
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Dataprovider'daki verilerle arama yapalım
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(2);

        //Her arama için sayfa resmi alalım
        ReusableMethods.tumSayfaResmi("google");

        //Sayfayı kapatalım
        Driver.closeDriver();

    }
    @DataProvider
    public static Object[][] kediler() {
        return new Object[][]{};
    }

    @Test(dataProvider = "kediler")
    public void test02() {
    }
}
