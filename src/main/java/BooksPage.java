import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage{

    private final By nameLocator = By.name("search_keyword");

    public BooksPage(WebDriver driver){
        super(driver);
    }


}
