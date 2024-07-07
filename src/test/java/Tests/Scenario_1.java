package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Home_Page;
import Pages.File_Upload_Page;


public class Scenario_1 {
    WebDriver driver;
    String Picture_Path = System.getProperty("user.dir")+"/src/test/resources/Dsquares.jpg";
    String URL = "https://the-internet.herokuapp.com/";
    String Expected_Success_Message = "File Uploaded!";

    @BeforeTest
    void Setup(){
        // Preparation for Test Case
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test Case to Upload Image and Make Sure Success Message is Displayed
    @Test
    void Test_Upload(){
        Home_Page homepage = new Home_Page(driver);
        // Go to URL
        homepage.Go_To_URL(URL);
        // Click on File Upload link in Home Page
        homepage.Open_File_Upload();

        File_Upload_Page file_upload_page = new File_Upload_Page(driver);
        // Upload Picture by its Path
        file_upload_page.Upload_File(Picture_Path);

        // Compare Returned Message with Expected Message
        Assert.assertEquals(file_upload_page.Get_Success_Message(), Expected_Success_Message);
    }

    @AfterTest
    void Close(){
        // Close Browser at the end
        driver.quit();
    }
}
