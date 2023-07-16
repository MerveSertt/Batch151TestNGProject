package techproed.tests.day23_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupsAfterGroups {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("En başta beforeSuite çalışır.");
    }

    @BeforeGroups({"gp1", "evren"})
    public void beforeGroups(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups = "gp1")//Groups parametresiyle beforeGroups'a bağladık. Böylece testlerimiz çalıştı
    public void testtest01() {
        String amazonUrl = "https://amazon.com";
        driver.get(amazonUrl);


    }

    @Test(groups = "gp1") //Groups parametresiyle beforeGroups'a bağladık. Böylece testlerimiz çalıştı
    public void testtest02() {
        driver.get("https://youtube.com");
    }

    @Test (groups = "evren")  //Groups parametresiyle beforeGroups'a bağlamadığımız için bu test methodu tek başına olsa çalışmaz.
    //Ama burada bu testten önce açılan driver sayesinde facebook'a da geçiş yapar.
    //Bu test methoduna verdiğimiz groups ismini beforeGroups'a da eklersek (2 adet groups ismi koyarsak)  bu test methodu da çalı şır
    public void testtest03() {
        driver.get("https://youtube.com");
    }
}
