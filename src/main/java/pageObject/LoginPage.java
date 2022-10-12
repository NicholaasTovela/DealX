package pageObject;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(id = "passwd")
    WebElement passwordTextBox;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAddress(String email){
        emailTextBox.click();
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }

}
