package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class File_Upload_Page {
    private WebDriver driver;

    public File_Upload_Page(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement Choose_File;
    public static WebElement Upload_Button;
    public static WebElement Success_Message;


    public void Upload_File(String Picture_Path){
        Choose_File = driver.findElement(By.id("file-upload"));
        Choose_File.sendKeys(Picture_Path);

        Upload_Button = driver.findElement(By.id("file-submit"));
        Upload_Button.click();
    }

    public String Get_Success_Message(){
        Success_Message = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        return Success_Message.getText();
    }
}
