package steps;


import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.IntentPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IntentPageStepDef extends TestBase {
    IntentPage intentPage;


    @Given("User successfully navigates to the automation practice intent page")
    public void userSuccessfullyNavigatesToTheAutomationPracticeIntentPage() throws InterruptedException {
        initialization();
        Thread.sleep(9000);
    }

    @And("I click on the {string}")
    public void iClickOnTheButton(String button) throws InterruptedException {
        intentPage = new IntentPage();
        if(button.equals("search box"))
        {
            intentPage.clickSearchBox();
        }else if(button.equals("search button")){
            intentPage.clickSearchButton();
        }else if(button.equals("sign in button")) {
            intentPage.clickSignIn();
        }else if(button.equals("log in button")) {
            intentPage.clickLogin();
        }
    }

    @When("I enter {string} in the searchbox")
    public void iEnterItemInTheSearchbox(String item) {
        intentPage.enterSearchCriteria(item);
    }

    @Then("I verify if the first result matches search {string}")
    public void iVerifyIfTheFirstResultMatchesSearchCriteria(String item) {
        intentPage.verifyProductList(item);
    }

    @Then("I search for three products and verify results match")
    public void iSearchForThreeProductsAndVerifyResultsMatch() throws InterruptedException {
        intentPage = new IntentPage();
        String searchCriteria = "Dress,Short,Blouse";
        String[] toBeSearched = searchCriteria.split(",");

        intentPage.clickSearchBox();
        for (int i= 0; i < toBeSearched.length ; i++ ){
            intentPage.enterSearchCriteria(toBeSearched[i]);
            intentPage.clickSearchButton();
            intentPage.verifyProductList(toBeSearched[i]);
            intentPage.clearSearchBox();
        }
    }

    @Then("I search for three products saved on an external file and verify results match")
    public void iSearchForThreeProductsSavedOnAnExternalFileAndVerifyResultsMatch() throws IOException, InterruptedException {
        FileReader fileReader = new FileReader("src/main/resources/data/products.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int count = 0;
        String line;

        while ((line = bufferedReader.readLine()) != null){
            count = count + 1;
            if (count > 1){
                String[] inputData = line.split("", 1);
                intentPage = new IntentPage();
                intentPage.clickSearchBox();
                for (int i= 0; i < inputData.length ; i++ ){
                    intentPage.enterSearchCriteria(inputData[i]);
                    intentPage.clickSearchButton();
                    intentPage.verifyProductList(inputData[i]);
                    intentPage.clearSearchBox();
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
    }

    @When("I hover over main category and select sub category")
    public void iHoverOverMainCategoryAndSelectSubCategory() {
        intentPage = new IntentPage();
        intentPage.hoverAndClickMenu();
    }
}
