import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;


public class ValidLogin {

    WebDriver driver;

    @BeforeClass
    public void ChromeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
    }

    @Test
    void SS1 ()
    {

        driver.findElement(By.name("uid")).sendKeys("mngr471726");
        driver.findElement(By.name("password")).sendKeys("mAgebAj");
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String message1 = driver.findElement(By.xpath("(//marquee[@class='heading3'])[1]")).getText();
        String expected = "Welcome To Manager's Page of Guru99 Bank";

        assertEquals(message1,expected);
    }

    @Test(dependsOnMethods = {"SS1"})
    void SS1d()
    {
        String title1 =driver.getTitle();
        assertEquals(title1,"Guru99 Bank Manager HomePage");

    }



    @AfterClass
    void exit()
    {
        driver.quit();
    }

}
