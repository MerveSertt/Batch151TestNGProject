package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {


    @Test
    public void test01() {
        //Bluerentalcar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //mysmoketestdata excel dosyasındaki herhangi bir email ve password ile login olalım
        ExcelReader excelReader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email = excelReader.getCellData(2,0);
        String password = excelReader.getCellData(2,1);

        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);

        //login olduğumuzu doğrulayalım
        Assert.assertTrue(rentalPage.loginverify.getText().contains("Kate"));

        //sayfayı kapatalım
        Driver.closeDriver();
    }


}
