package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Home_Page {
    private WebDriver driver;
    public Home_Page(WebDriver driver){
        this.driver = driver;
    }

    public static WebElement File_Upload_Link;
    public static WebElement Dynamic_Loading_Link;

    public void Go_To_URL(String URL){
        driver.get(URL);
    }

    public void Open_File_Upload(){
        File_Upload_Link = driver.findElement(By.linkText("File Upload"));
        File_Upload_Link.click();
    }

    public void Open_Dynamic_Loading(){
        Dynamic_Loading_Link = driver.findElement(By.linkText("Dynamic Loading"));
        Dynamic_Loading_Link.click();
    }
}
