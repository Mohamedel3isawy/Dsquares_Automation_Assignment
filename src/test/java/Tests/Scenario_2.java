package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Home_Page;
import Pages.Dynamic_Loading_Page;


public class Scenario_2 {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/";
    String Expected_Message = "Hello World!";

    @BeforeTest
    void Setup(){
        // Preparation for Test Case
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test Case to wait for Message to be Displayed
    @Test
    void Test_Dynamic_Loading(){
        Home_Page homepage = new Home_Page(driver);
        // Go to URL
        homepage.Go_To_URL(URL);
        // Click on Dynamic Loading link in Home Page
        homepage.Open_Dynamic_Loading();

        Dynamic_Loading_Page dynamicLoadingPage = new Dynamic_Loading_Page(driver);
        // Click on Example 2 Link
        dynamicLoadingPage.Open_Example_2();
        // Click on Start button
        dynamicLoadingPage.Click_Start();

        // Wait for Message to be displayed then compare Returned Message with Expected Message
        Assert.assertEquals(dynamicLoadingPage.Wait_and_Get_Message(), Expected_Message);
    }

    @AfterTest
    void Close(){
        // Close Browser at the end
        driver.quit();
    }
}
