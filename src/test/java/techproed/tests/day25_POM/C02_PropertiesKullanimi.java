package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;

public class C02_PropertiesKullanimi {

    @Test
    public void test01() {
        String amazonUrl = ConfigReader.getProperty("amazonUrl");
        String userName = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        System.out.println(amazonUrl);
        System.out.println(userName);
        System.out.println(password);
    }


}
