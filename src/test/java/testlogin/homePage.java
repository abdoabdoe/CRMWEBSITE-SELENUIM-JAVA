package testlogin;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class homePage {
    WebDriver driver;
    @BeforeMethod
    public void login() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abdo\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/login.cfm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        WebElement LoginText = driver.findElement(By.name("username"));
        WebElement passwordButton = driver.findElement(By.name("password"));
        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[3]"));
        LoginText.sendKeys("abdoabdoe");
        passwordButton.sendKeys("123321");
        LoginButton.click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("C:\\Users\\abdo\\Desktop\\selenium-webdriver-java-course-c4.3\\Testcase\\hompage.png"));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }

    @Test(priority = 1)
    public void clickContactTests()
    {
        driver.switchTo().frame("mainpanel");
        WebElement contacts = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
        contacts.click();
    }
    @Test(priority = 2)
    public void clickdealsTests()
    {
        driver.switchTo().frame("mainpanel");
        WebElement contacts = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/a"));
        contacts.click();
    }
    @Test(priority = 3)
    public void clickTasksTests()
    {
        driver.switchTo().frame("mainpanel");
        WebElement contacts = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[6]/a"));
        contacts.click();
        WebElement keywrd = driver.findElement(By.xpath("//*[@id=\"extendedSearchLayer\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input[1]"));
        keywrd.sendKeys("send");
        WebElement company = driver.findElement(By.xpath("//*[@id=\"extendedSearchLayer\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/input"));
        company.sendKeys("vnet");

    }

}

