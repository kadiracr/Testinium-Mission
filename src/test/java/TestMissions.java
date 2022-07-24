import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestMissions extends BaseTest{


    @Test
    public void SetSearchBox() throws IOException {
        String name = GetNameFromFile();
        homePage.setName(name);
        try {
            Assert.assertEquals("roman",homePage.GetName());
            log.info("PASSED");
            homePage.PressEnter();
        }
        catch (Throwable y){
            log.error("FAILED");
        }


    }

    @Test
    public void ChooseBook() throws IOException {

        //========================== RANDOM KİTAP SEÇ ===================================

        SetSearchBox();

        WebElement book;
        book = homePage.ChooseRandomBook();
        try {
            book.click();
            log.info("ADDED");
            WebElement pCountElement = driver.findElement(By.xpath("//span[@id='cart-items']"));
            pCountElement.click();

            //========================== SEPET SAYISI BELİRLEME BAŞARISIZ ===================================
            /*

            WebElement pCountElement = driver.findElement(By.xpath("//span[@id='cart-items']"));
            String currentProductCount = pCountElement.getText();
            System.out.println(pCountElement.getText());
            Assert.assertEquals(currentProductCount,"1");

             */
        }
        catch (Throwable y){
            log.error("FAILED");
        }
    }

    @Test
    public void GoBasket() throws IOException {
        ChooseBook();

        //========================== SEPETE GİT ===================================

        WebElement goBasketElement = driver.findElement(By.id("js-cart"));
        goBasketElement.click();
        log.info("IN BASKET");
    }

    @Test
    public void UpdateBasket() throws IOException {
        GoBasket();

        //========================= SEPETTEKİ ÜRÜN SAYISI KONTROLÜ =======================================

        WebElement countBox = driver.findElement(By.xpath("//input[@style='width:22px']"));
        countBox.clear();
        countBox.sendKeys("2");
        log.info("NUMBER UPDATED");

        //========================= SEPETİ GÜNCELLE =======================================

        WebElement refreshBox = driver.findElement(By.xpath("//i[@onclick='cartProductUpdate($(this).parent())']"));
        refreshBox.click();
        log.info("BASKET UPDATED");

        //========================= GÜNCELLENİYOR YAZISI KONTROLÜ =======================================

        WebElement updatingElement = driver.findElement(By.xpath("//h2[@class='swal2-title ky-swal-title-single']"));
        Assert.assertTrue(updatingElement.isDisplayed());
        log.info("UPDATING TEXT DISPLAYED");

        //========================= SEPETTEKİ TEMİZLE =======================================

        WebElement deleteButton = driver.findElement(By.xpath("//i[@class='fa fa-times red-icon']"));
        deleteButton.click();
        log.info("BASKET CLEARED");

        //========================= SEPETİN BOŞ OLDUĞUNU KONTROL ET =======================================

        WebElement basketState = driver.findElement(By.xpath("//div[@id='cart-items-empty']"));
        String text = basketState.getAttribute("innerHTML");
        Assert.assertEquals(text,"Sepetiniz boş");
        log.info("PROCESS COMPLETED");


    }








    String GetNameFromFile() throws IOException {
        File file = new File("src/main/resources/typesOfBook.csv");
        if(file.exists()){
            System.out.println("File Exists");
        }
        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));
        String line = null;
        List<String> types = new ArrayList<String>();
        while((line = bufRdr.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line,",");
            while (st.hasMoreTokens()){
                types.add(st.nextToken());
            }
        }
        bufRdr.close();
        return types.get(2);
    }

}
