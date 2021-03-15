import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class GridTest {
    //On Hub&node: download Selenium standalone driver & chrome WebDriver (same version of your chrome browser)

//Hub on Terminal-> java -jar selenium-server-standalone-3.141.59.jar -role hub
//Node on Terminal-> java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.1.8:4444/grid/register/ -port 5566

   // @Test
    public void GridTesing() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.MAC);


        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.8:4444/wd/hub"),dc);

        driver.navigate().to("https://www.google.com/");




    }
}
