package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    BeforeSuite , test ve class en basta bir sefer ..AfterSuite, test ve class en son da bir sefer calisir
    before ve after methodlar ise her testin basinda sonunda bir kez calisir
     */
@BeforeSuite
    public void site(){
    System.out.println("Her şeyden önce bir kez BeforeSuite çalışır");
}
@BeforeTest
    public void beforeTest(){
    System.out.println("Testlerden önce bir kez BeforeTest çalışır");
}
@BeforeClass
    public void beforeClass(){
    System.out.println("Her class'tan önce bir kez BeforeClass çalışır");
}
@BeforeMethod
    public void setUp(){
    System.out.println("Junitteki @Before notasyonu gibi @BeforeMethod her methoddan önce çalışır");
}

    @Test
    public void testtest01() {
        System.out.println("Test1 çalıştı");
    }

    @Test
    public void testtest02() {
        System.out.println("Test2 çalıştı");
    }

    @Test
    public void testtest03() {
        System.out.println("Test3 çalıştı");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Her şeyden sonra @AfterSuite 1 kez çalışır");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Bütün testten sonra  @AfterTest 1 kez çaışır");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Her class'tan sonra @AfterClass 1 kez çalışır");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Junitteki @After notasyonu gibi  @AfterMethod her methoddan sonra çalışır.");
    }


}
