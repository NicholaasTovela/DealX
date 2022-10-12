package pageObject;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
    WebElement hoverProduct;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
    WebElement btnCrossPopUp;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement btnViewCart;

    @FindBy(id = "cart_quantity_up_2_7_0_756038")
    WebElement btnIncreaseQuantity;

    @FindBy(id = "product_price_2_7_756038")
    WebElement productPrice;

    @FindBy(name = "quantity_2_7_0_756038_hidden")
    WebElement productQty;

    @FindBy(id = "total_product_price_2_7_756038")
    WebElement total;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void addToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverProduct).perform();
        btnAddToCart.click();
        Thread.sleep(7000);
        btnCrossPopUp.click();
    }
    public void viewCart(){
        btnViewCart.click();
    }

    public void increaseCartQty(String qty){

        int requiredQty = Integer.parseInt(qty);
        while (requiredQty > 0){
            btnIncreaseQuantity.click();
            requiredQty--;
        }
    }

    public double calculateTotal(double unitPrice, int qty){
        double total = 0;
        total = unitPrice * qty;
        return total;
    }

    public void verifyTotal() throws InterruptedException {
        String unitPrice = productPrice.getAttribute("innerText").trim().replace("$","");
        Thread.sleep(8000);
        String qty = productQty.getAttribute("value");
        String totalPrice = total.getAttribute("innerText").trim().replace("$","");

        double expectedTotal = calculateTotal(Double.parseDouble(unitPrice), Integer.parseInt(qty));
        double actualTotal = Double.parseDouble(totalPrice);

        if (expectedTotal == actualTotal){
            System.out.println("Expected total " + expectedTotal + " \n" + "Actual Total " + actualTotal + "\n=== Test Passed ===" );
        }else{
            Assert.fail();
        }
    }
}
