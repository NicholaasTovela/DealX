package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;

public class HomePageStepDefs extends TestBase {
    HomePage homePage;

    @When("I add and view an item in cart")
    public void i_add_an_item_to_cart() throws InterruptedException {
        homePage = new HomePage();
        homePage.addToCart();
        homePage.viewCart();
    }

    @And("I increase the cart quantity by {string}")
    public void iIncreaseTheCartQuantityBy(String qty) throws InterruptedException {
        Thread.sleep(6000);
        homePage.increaseCartQty(qty);
    }

    @Then("I calculate total and verify it with the total on the cart")
    public void iCalculateTotalAndVerifyItWithTheTotalOnTheCart() throws InterruptedException {
        homePage.verifyTotal();
    }
}
