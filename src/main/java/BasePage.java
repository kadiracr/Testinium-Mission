import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    String baseURL = "https://www.kitapyurdu.com/";

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement find(By locater){
        return driver.findElement(locater);
    }


    //========================== RANDOM KİTAP SEÇ ===================================
    public WebElement ChooseRandomBook(){
        List<WebElement> bookList = new ArrayList<WebElement>();
        bookList = driver.findElements(By.xpath("//div[@class='product-cr']"));
        Random rand = new Random();
        int number = rand.nextInt(3,23);
        String id = bookList.get(number).getAttribute("id");
        System.out.println(driver.findElement(By.xpath("//div[@id='"+id+"']/div[2]/div[3]/a[2]/i")));
        return driver.findElement(By.xpath("//div[@id='"+id+"']/div[2]/div[3]/a[2]/i"));
    }

    public void click(By locater){
        find(locater).click();
    }

    public void fill(By locater, String text){
        find(locater).sendKeys(text);
    }



}
