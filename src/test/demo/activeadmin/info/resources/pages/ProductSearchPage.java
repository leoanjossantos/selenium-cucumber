package demo.activeadmin.info.resources.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static demo.activeadmin.info.resources.support.Driver.get;
import static demo.activeadmin.info.resources.support.Driver.waitForAllElements;
import static demo.activeadmin.info.resources.support.Driver.waitForElement;

/**
 * Created by lsantos on 27/08/14.
 */
public class ProductSearchPage {

    private final String URL_PRODUCT_SEARCH = HomePage.HOME_URL + "/admin/products";

    private final By TITLE = By.id("q_title");
    private final By DESCRIPTION = By.id("q_description");
    private final By AUTHOR = By.id("q_author");
    private final By PRICE = By.xpath("//select");
    private final By VALUE = By.id("price_numeric");
    private final By BEGIN_DATE_AVAILABLE = By.id("q_available_on_gte");
    private final By END_DATE_AVAILABLE = By.id("q_available_on_lte");
    private final By IMAGE_FILE_NAME = By.id("q_image_file_name");
    private final By BEGIN_CREATED = By.id("q_created_at_gte");
    private final By END_CREATED = By.id("q_available_on_lte");
    private final By BEGIN_UPDATE = By.id("q_updated_at_gte");
    private final By END_UPDATE = By.id("q_updated_at_lte");

    private final By FILTER = By.id("q_submit");
    private final By CLEAR_FILTER = By.linkText("Clear Filters");

    private final By TABLE_OF_RESULTS = By.className("index_grid");

    private final By MESSAGE_ERROR = By.cssSelector("span.blank_slate");


    HashMap<String, By> myMap = new HashMap<String, By>() {{
        put("title", TITLE);
        put("description", DESCRIPTION);
        put("author", AUTHOR);
        put("price", PRICE);
        put("value", VALUE);
        put("begin_date_available", BEGIN_DATE_AVAILABLE);
        put("end_date_available", END_DATE_AVAILABLE);
        put("image_file_name", IMAGE_FILE_NAME);
        put("begin_created", BEGIN_CREATED);
        put("end_created", END_CREATED);
        put("begin_update", BEGIN_UPDATE);
        put("end_update", END_UPDATE);
    }};

    /**
     * Open url of the product search
     */
    public void getUrlAcess() {
        get(URL_PRODUCT_SEARCH);
    }

    /**
     * Load fields
     * @param values
     */
    public void inputFields(Map<String, String> values) {
        for(String key : values.keySet()){
            if (key.equals("price")) {
                if (myMap.get(key).equals("") || myMap.get(key).equals("Equals To")) {
                    selectionOftheCombobox(values.get(key));
                }
            }
            waitForElement(myMap.get(key)).sendKeys(values.get(key));


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
     * Click on button Clear Fields
     */
    public void clickFilter() {
        waitForElement(FILTER).click();
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
     * Return string of the message
     * @return
     */
    public String returnMessageError() {

        return waitForElement(MESSAGE_ERROR).getText();
    }

    /**
     * Return boolean for fields empty or load
     * @return
     */
    public boolean isFieldsLoad() {
        for (String key : myMap.keySet()) {
            if(!myMap.get(key).equals(PRICE)){
                if (!(waitForElement(myMap.get(key)).getText().equals(""))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void clearFields() {
        waitForElement(CLEAR_FILTER).click();
    }
}