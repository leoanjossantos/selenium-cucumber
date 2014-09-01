package demo.activeadmin.info.resources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static demo.activeadmin.info.resources.support.Driver.*;

/**
 * Created by lsantos on 26/08/14.
 */
public class OrdersPage {

    private final String URL_ORDERS = HomePage.HOME_URL + "/admin/orders";

    private final By PRICE = By.xpath("//select");
    private final By VALUE = By.id("total_price_numeric");
    private final By BEGIN_CHECKED = By.id("q_checked_out_at_gte");
    private final By END_CHECKED = By.id("q_checked_out_at_lte");

    private final By FILTER = By.id("q_submit");
    private final By CLEAR_FILTER = By.id("q_submit");

    private final By TABLE_OF_RESULTS = By.tagName("tbody");
    private final By MESSAGE_ERROR = By.cssSelector("span.blank_slate");

    /**
     * Open url of the Orders page
     */
    public void acessOrderPage() {
        get(URL_ORDERS);
    }

    HashMap<String, By> myMap = new HashMap<String, By>() {{
        put("total_price", PRICE);
        put("value", VALUE);
        put("begin_checked", BEGIN_CHECKED);
        put("end_checked", END_CHECKED);
    }};

    /**
     * Load fields
     * @param element
     */
    public void loadFields(Map<String, String> element) {

        for (String key : element.keySet()) {
            if (key.equals("total_price")) {
                if (myMap.get(key).equals("") || myMap.get(key).equals("Equals To")) {
                    selectionOftheCombobox(element.get(key));
                }
            }
            waitForElement(myMap.get(key)).sendKeys(element.get(key));
        }
    }

    /**
     * Select value in combobox
     * @param value
     */
    public void selectionOftheCombobox(String value) {
        Select combobox = new Select(waitForElement(PRICE));
        combobox.selectByVisibleText(value);
    }

    /**
     * Click on button Filter
     */
    public void clickOnFilter() {
        waitForElement(FILTER).click();
    }

    /**
     * Click on button Clear Fields
     */
    public void clearFields() {
        waitForElement(CLEAR_FILTER);
    }

    /**
     * Return boolean for list empty or load
     * @return
     */
    public boolean isPresentOnList() {

        List<WebElement> webElement = waitForAllElements(TABLE_OF_RESULTS);

        for (WebElement webElem : webElement) {
            if (webElem.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return boolean for fields empty or load
     * @return
     */
    public boolean isFieldsLoad() {
        for (String key : myMap.keySet()) {
            if (!(waitForElement(myMap.get(key)).getText().equals(""))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return string of the message
     * @return
     */
    public String returnMessageError() {

        return waitForElement(MESSAGE_ERROR).getText();
    }
}
