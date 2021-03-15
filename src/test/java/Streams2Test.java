import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;


public class Streams2Test {
    WebDriver driver = null;
    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/ahmadkhalili/Desktop/Streams/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
       //driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void StreamsExample1(){
        //To validate search functionality working as expected
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
        //result 1 element
        List<WebElement> elementList =driver.findElements(By.xpath("//tr/td[1]"));
        //result 1 element
        List<WebElement> filteredList = elementList.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(elementList.size(),filteredList.size());

    }
    @Test
    public void StreamsExample2(){
        //Test if the list of elements are sorted the compare original list with sorted list.
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(originalList.equals(sortedList));

    }
    @Test
    public void StreamsExample3(){
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //List<String> price;
        List<String> price2;


        do{
            List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
          //  price =elementList.stream().filter(s->s.getText().contains("Strawberry")).
                  //  map(s->getviggiPrice(s)).collect(Collectors.toList());

            price2= elementList.stream().filter(s->s.getText().contains("Strawberry")).
                    map(s->s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());


            price2.forEach(s-> System.out.println(s));



            if (price2.size()<1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        }while(price2.size()<1);


    }

    private static String getviggiPrice(WebElement s) {
       String priceString= s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceString;
    }

   // @Test
    public void streamClick(){
     List<WebElement> drop = driver.findElements
             (By.xpath("//select[@id='dropdown-class-example']/option"));
    drop.stream().filter(s->s.getText().contains("Option2"))
             .findAny().get().click();
    }

    @AfterMethod
    public void terDown(){
        driver.close();
        driver.quit();
    }

}
