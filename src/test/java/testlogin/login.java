package testlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class login  {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\abdo\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/login.cfm");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }

    @Test(priority = 1)
    public void litleTest() {

        String expectedresults = "CRMPRO Log In Screen";
        String actualresult = driver.getTitle();
        System.out.println(actualresult);
        Assert.assertEquals(actualresult,expectedresults);

    }

    @Test (priority = 2)
    public void urlCheck() {
        String expectedresults = "https://classic.freecrm.com/login.cfm";
        String actualresult = driver.getCurrentUrl();
        System.out.println(actualresult);
        Assert.assertEquals(actualresult,expectedresults);

    }
    @Test (priority = 3)
    public void logoTest() {
        WebElement Logo = driver.findElement(By.xpath("/html/body/div[1]/div/a/img"));
        boolean expectedresults = true;
        boolean actualresult = Logo.isDisplayed();
        System.out.println(actualresult);
        Assert.assertEquals(actualresult,expectedresults);


    }
    @Test (priority = 4, dataProvider = "mydata")
    public void Logintest(String username , String password) {
        WebElement LoginText = driver.findElement(By.name("username"));
        WebElement passwordButton = driver.findElement(By.name("password"));
        WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[3]"));
        LoginText.sendKeys(username);
        passwordButton.sendKeys(password);
        LoginButton.click();
        String expectedresults = "CRMPRO";
        String actualresult = driver.getTitle();
        Assert.assertEquals(actualresult,expectedresults);

    }
    @DataProvider
    public Object[][] mydata()
    {
        Object[][] data = new Object[4][2];
        data [0][0]="abdoabdoe";
        data [0][1]="123321";
        data [1][0]="abdoabdoe";
        data [1][1]="1223321";
        data [2][0]="abdoabdo";
        data [2][1]="123321";
        data [3][0]="abdoabdo";
        data [3][1]="1233321";
        return data;
    }

}

