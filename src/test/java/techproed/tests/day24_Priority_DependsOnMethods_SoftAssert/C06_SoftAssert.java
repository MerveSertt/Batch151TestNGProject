package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C06_SoftAssert {

     /*
        SoftAssert kullaniminda Junitte daha once kullandigimiz methodlarin aynisini kullaniriz.
    Daha onceden kullandigimiz assertion nerde hata alirsa orda testlerin calismasini durdurur.
    SoftAssert'te ne kadar assertion kullansak da nerde assertAll() methodu kullanirsak testlerimiz de
    kullandigimiz assertionlar orda sonlanir ve hata varsa bunu bize konsolda belirtir
     */

WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert(); //--> SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız.
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");//-->Bilerek hata alıcaz.

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//bilerek hata alıcaz
        System.out.println("Burası çalıştı");
        softAssert.assertAll(); // Bu methoddan sonra herhangi bir şey çalışmaz.
        System.out.println("Burası çalışmaz");
    }


    //ODEV
    /*
    Yeni bir Class Olusturun : C03_SoftAssert
    1. “http://zero.webappsecurity.com/” Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password” yazin
    5. Sign in tusuna basin
    6. Online banking menusu icinde Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
    edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
    (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
    (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
    (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
    (dollar)","Thailand (baht)"
     */

    @Test
    public void testODEV() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//i[@class='icon-signin']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username",Keys.TAB,"password",Keys.ENTER);
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("(//a)[17]")).click();

        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));

        Select select = new Select(currency);
        select.selectByIndex(6);
        String seciliSecenek = currency.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Eurozone (Euro)",seciliSecenek);

        String tumu = "";

        List<WebElement> currencyList = select.getOptions();
        for (WebElement w:currencyList) {
            tumu = w.getText() +", ";
        }
        softAssert.assertEquals("Select One, Australia (dollar), Canada (dollar), Switzerland (franc), China (yuan)," +
                "Denmark (krone), Eurozone (euro), Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway" +
                   "(krone), New Zealand (dollar), Sweden (krona), Singapore  (dollar), Thailand (baht)",tumu);
softAssert.assertAll();





    }
}
