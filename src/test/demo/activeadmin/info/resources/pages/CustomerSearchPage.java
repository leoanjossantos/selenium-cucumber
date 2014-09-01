package demo.activeadmin.info.resources.pages;


import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static demo.activeadmin.info.resources.support.Driver.get;
import static demo.activeadmin.info.resources.support.Driver.waitForElement;

/**
 * Created by lsantos on 22/08/14.
 */
public class CustomerSearchPage {

    private final String NEW_CUSTOMER_URL = HomePage.HOME_URL + "/admin/customers";

    private final By SEARCH_USERNAME = By.id("q_username");
    private final By SEARCH_EMAIL = By.id("q_email");
    private final By SEARCH_BEGIN_DATE = By.id("q_created_at_gte");
    private final By SEARCH_END_DATE = By.id("q_created_at_lte");

    private final By FILTER = By.id("q_submit");
    private final By CLEAR_FILTER = By.linkText("Clear Filters");

    private final By MESSAGE_NOT_FOUND = By.cssSelector("span.blank_slate");

    HashMap<String, By> mapBys = new HashMap<String, By>(){{
        put("username", SEARCH_USERNAME);
        put("email", SEARCH_EMAIL);
        put("begin_date", SEARCH_BEGIN_DATE);
        put("end_date", SEARCH_END_DATE);
    }};

    public void accessPage() {
        get(NEW_CUSTOMER_URL);

    }

    public void loadField(Map<String, String> inputs){
        for(String key : inputs.keySet()) {
            waitForElement(mapBys.get(key)).sendKeys(inputs.get(key));
        }
    }

    public void clickButtonFilter(){
        waitForElement(FILTER).click();

    }

    public void clearFields(){
        waitForElement((CLEAR_FILTER)).click();

    }

    public String returnMessageNotFound(){
        return waitForElement(MESSAGE_NOT_FOUND).getText();
    }


    public void isPresentList(Map<String, String> element) {

    }


    public boolean isFieldsLoad(){
        for(String key : mapBys.keySet()) {
            if(!(waitForElement(mapBys.get(key)).getText().equals(""))){
                return false;
            }
        }
        return true;
    }

}
