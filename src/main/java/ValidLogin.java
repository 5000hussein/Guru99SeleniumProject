import org.openqa.selenium.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.OutputType;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import java.util.Date;

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
    void SS1 () throws IOException {

        driver.findElement(By.name("uid")).sendKeys("mngr471726");
        driver.findElement(By.name("password")).sendKeys("mAgebAj");
        WebElement login = driver.findElement(By.name("btnLogin"));
        login.click();
        String message1 = driver.findElement(By.xpath("(//marquee[@class='heading3'])[1]")).getText();
        String expected = "Welcome To Manager's Page of Guru99 Bank";
        TakesScreenshot ValidLogin = ((TakesScreenshot) driver);
        File SrcFile = ValidLogin.getScreenshotAs(OutputType.FILE);
        Date currentDate = new Date();
        String date = currentDate.toString().replace(" ","-").replace(":","-");
        FileUtils.copyFile(SrcFile, new File(".//screenshot/"+date+"ValidLogin.png"));
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
