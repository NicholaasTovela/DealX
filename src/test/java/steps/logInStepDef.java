package steps;

import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class logInStepDef {

    LoginPage loginPage;

    @When("I enter {string} and {string}")
    public void i_enter_and(String email, String password) throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

}
