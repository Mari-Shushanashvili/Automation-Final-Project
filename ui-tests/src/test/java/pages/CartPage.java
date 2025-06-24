package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(className = "inventory_item_name")
    private WebElement inventoryItemName;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getInventoryItemName() {
        return inventoryItemName.getText();
    }

    public void removeProduct() {
        removeBackpackButton.click();
    }

    public int getNumberOfItemsInCart() {
        return cartItems.size();
    }
}