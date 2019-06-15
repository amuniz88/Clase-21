package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(how = How.ID, using = "user")
    WebElement inputUser;

    @FindBy(how = How.ID, using = "pass")
    WebElement inputPassword;

//    @FindBy(how = How.ID, using = "loginButton")
    WebElement loginButton;

    @FindBy(how = How.NAME, using = "errorMessage")
    WebElement messageError;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public EmployeePage loginEmploye(String usuario, String password){
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));
        return new EmployeePage(driver);
    }

    public void login(String usuario, String password){
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));
    }

    public boolean messageError(String text){
        return messageError.getText().contains(text);
    }

    public boolean messageErrorIsDisplayed(){
        return messageError.isDisplayed();
    }


}
