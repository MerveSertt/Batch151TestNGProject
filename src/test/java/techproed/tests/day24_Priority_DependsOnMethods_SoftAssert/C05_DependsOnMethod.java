package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import org.testng.annotations.Test;

public class C05_DependsOnMethod {
    @Test
    public void test01() {
        System.out.println("erol");//bu test methodu tek başına çalışır
    }
    @Test(dependsOnMethods = "test01")
    public void test02() {
        System.out.println("evren");//bu test methodu tek başına çalışır çünkü sadece 1 tane test methoduna bağlı ikisini birlikte yazdırır
    }
    @Test(dependsOnMethods = "test02")
    public void test03() {
        System.out.println("esen");//bu test methodu tek başına çalışmaz. çünkü bağlı olduğu test methodu başka bir test methoduna bağlı.
    }
    @Test(dependsOnMethods = "test03")
    public void test04() {
        System.out.println("mehmet"); //sadece bu testi çalıştırırsak hata alırız. Çünkü dependson ile diğer testlere bağlı
    }

}
