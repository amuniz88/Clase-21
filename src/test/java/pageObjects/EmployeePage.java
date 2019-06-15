package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeePage extends BasePage{

    @FindBy(how = How.TAG_NAME, using = "h4")
    WebElement textoPagina;

    @FindBy(how = How.ID, using ="name")
    WebElement boxNombre;

    @FindBy(how = How.ID, using ="address")
    WebElement boxAddres;

    @FindBy(how = How.CSS, using ="[placeholder=\"City\"]")
    WebElement boxCity;

    @FindBy(how = How.ID, using ="state")
    WebElement boxState;

    @FindBy(how = How.ID, using ="postcode")
    WebElement boxPostal;

    @FindBy(how = How.ID, using ="email")
    WebElement boxEmail;

    @FindBy(how = How.ID, using ="phoneNumber")
    WebElement boxPhone;

    WebElement addButton;

    @FindBy(how = How.ID, using = "success-alert")
    WebElement msgSuccess;


    public EmployeePage(WebDriver driver){
        super(driver);
    }

    public boolean textoPaginaIsDisplayed(){
        return textoPagina.isDisplayed();
    }

    public boolean textoPaginaContainsText(String text){
        return textoPagina.getText().contains(text);
    }

    public void addEmployee(String name, String address, String city, String state, String postal, String email, String phone){


        boxNombre.sendKeys(name);
        boxAddres.sendKeys(address);
        boxCity.sendKeys(city);
        boxState.sendKeys(state);
        boxPostal.sendKeys(postal);
        boxEmail.sendKeys(email);
        boxPhone.sendKeys(phone);
        addButton.click();
    }

    public boolean messageSuccessIsDisplayed(){
        return msgSuccess.isDisplayed();
    }

    public boolean messageSuccess(){
        return msgSuccess.getText().contains("Employee added successfully.");
    }
}
