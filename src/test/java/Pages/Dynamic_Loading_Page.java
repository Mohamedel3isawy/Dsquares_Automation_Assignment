package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dynamic_Loading_Page {
    private WebDriver driver;
    private WebDriverWait wait;


    public Dynamic_Loading_Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public static WebElement Example_Two_link;
    public static WebElement Start_Button;
    public static WebElement Hello_World_Message;

    public void Open_Example_2(){
        Example_Two_link = driver.findElement(By.linkText("Example 2: Element rendered after the fact"));
        Example_Two_link.click();
    }

    public void Click_Start(){
        Start_Button = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));
        Start_Button.click();
    }

    public String Wait_and_Get_Message(){
        Hello_World_Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/h4")));
        return Hello_World_Message.getText();
    }

}
