import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{


    private final By nameLocator = By.name("search_keyword");

    public HomePage(WebDriver driver){
        super(driver);
        driver.get(baseURL);
    }

    public void setName(String name){
        fill(nameLocator, name);
    }

    public String GetName(){
        return find(nameLocator).getAttribute("value");

    }

    public void PressEnter(){
        find(nameLocator).sendKeys(Keys.RETURN);
    }

    public String GetWebElementValue(By locator){
        return find(locator).getAttribute("value");

    }



}
