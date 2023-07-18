package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PageKullanimi {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.submit.click();

        ReusableMethods.bekle(2);

        Assert.assertTrue(centerPage.verify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logout.click();
        Assert.assertTrue(centerPage.username.isDisplayed());
    }
}
