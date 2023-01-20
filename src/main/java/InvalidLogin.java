import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidLogin {

    WebDriver driver;

    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
    }

    @Test()
    void SS2()
    {

        driver.findElement(By.name("uid")).sendKeys("123abc");
        driver.findElement(By.name("password")).sendKeys("mAgebAj");
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String expected = "User or Password is not valid";
        String actual =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals(actual,expected);


    }


    @Test()
    void SS3()
    {

        driver.findElement(By.name("uid")).sendKeys("mngr471726");
        driver.findElement(By.name("password")).sendKeys("123abc");
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String expected = "User or Password is not valid";
        String actual =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals(actual,expected);


    }
    @Test()
    void SS4()
    {

        driver.findElement(By.name("uid")).sendKeys("123abc");
        driver.findElement(By.name("password")).sendKeys("123abc");
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
