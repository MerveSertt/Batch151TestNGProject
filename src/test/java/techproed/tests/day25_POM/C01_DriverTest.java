package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.getDriver().get("https://facebook.com");
        /*
        Driver'a koyduğumuz if bloğu ile buradaki sayfalara tek browser ile sırasıyla gittik.
        Driver'daki if bloğunu kullanmadığımız zaman her get() methodu kullandığımızda yeni bir browser açtı
         */
    }

    @Test
    public void test03() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://facebook.com");
    }

    @Test
    public void testtest04() {
        // Driver driver = new Driver();
        //Singleton pattern kullandığımız için obje oluşturmanın önüne geçtik.
    }
}
