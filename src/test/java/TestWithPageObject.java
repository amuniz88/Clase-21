import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.EmployeePage;
import pageObjects.HomePage;

public class TestWithPageObject {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeePage employeePage;

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://verstandqa.com/login-employee-v2/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testLogin(){
        employeePage = homePage.loginEmploye("admin", "admin123");

        Assert.assertTrue(employeePage.textoPaginaIsDisplayed() &&
                employeePage.textoPaginaContainsText("Add Employee"));
    }

    @Test
    public void testFailed(){
        homePage.login("admin1", "admin");

        Assert.assertTrue(homePage.messageError("Bad credentials Please try again.."));
        Assert.assertTrue(homePage.messageErrorIsDisplayed());
    }

    @Test
    public void addEmployed(){
        employeePage =  homePage.loginEmploye("admin","admin123");

        employeePage.addEmployee("Emilia","Rivera 19380","Montevideo","Montevideo","10000","e.m@gmail.com","12333654");

        Assert.assertTrue(employeePage.messageSuccessIsDisplayed());
        Assert.assertTrue(employeePage.messageSuccess());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}