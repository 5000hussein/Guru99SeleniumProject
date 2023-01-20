import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidLogin {

    WebDriver driver;

    @Test()
    void SS2()
    {
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
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
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
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
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        driver.findElement(By.name("uid")).sendKeys("123abc");
        driver.findElement(By.name("password")).sendKeys("123abc");
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String expected = "User or Password is not valid";
        String actual =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        assertEquals(actual,expected);


    }
}
