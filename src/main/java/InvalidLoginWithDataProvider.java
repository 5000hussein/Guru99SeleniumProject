
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidLoginWithDataProvider {

    WebDriver driver;


    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
    }

    @DataProvider(name= "Credentials")
    public Object[][] get()
    {
        Object[][] data ={{"123abc","mAgebAj"},{"mngr471726","123abc"},{"123abc","123abc"}};
        return data;
    }

    @Test(dataProvider = "Credentials")
    public void InvalidLogin(String UID,String Password)
    {
        driver.findElement(By.name("uid")).sendKeys(UID);
        driver.findElement(By.name("password")).sendKeys(Password);
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String expected = "User or Password is not valid";
        String actual =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals(actual,expected);
    }

    @AfterClass
    void exit()
    {
        driver.quit();
    }

}
