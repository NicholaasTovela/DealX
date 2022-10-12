package pageObject;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IntentPage extends TestBase {

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(name = "submit_search")
    WebElement btnSearch;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
    List<WebElement> productList;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement btnSignIn;

    @FindBy(id = "SubmitLogin")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement womanMainCategory;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
    WebElement tshirtSubMenu;

    public IntentPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickSearchBox() throws InterruptedException {
        Thread.sleep(2000);
        searchBox.click();
    }
    public void clearSearchBox(){
        //clearing anything that might be on the search box
        searchBox.clear();
    }
    public void clickSearchButton() throws InterruptedException {
        btnSearch.click();
    }
    public void clickSignIn(){
        btnSignIn.click();
    }
    public void clickLogin(){
        btnLogin.click();
    }
    public void enterSearchCriteria(String searchItem){
        searchBox.sendKeys(searchItem);
    }

    public void verifyProductList(String expectedItem){
        String actualItem = productList.get(0).getText();
        if (actualItem.contains(expectedItem)){
            System.out.println(actualItem + " contains " + expectedItem);
        }else{
            Assert.fail();
        }
    }

    public void hoverAndClickMenu(){
        Actions actions = new Actions(driver);

        actions.moveToElement(womanMainCategory).perform();
        tshirtSubMenu.click();
    }
}
