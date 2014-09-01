package demo.activeadmin.info.resources.pages;


import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static demo.activeadmin.info.resources.support.Driver.get;
import static demo.activeadmin.info.resources.support.Driver.waitForElement;

/**
 * Created by lsantos on 22/08/14.
 */
public class CustomerRegisterPage {

    private final String NEW_CUSTOMER_URL = HomePage.HOME_URL + "/admin/customers/new";
    private final By USERNAME = By.id("customer_username");
    private final By EMAIL = By.id("customer_email");
    private final By PASSWORD_HASH = By.id("customer_password_hash");
    private final By PASSWORD_SALT = By.id("customer_password_salt");


    HashMap<String, By> mapBys = new HashMap<String, By>() {{
        put("username", USERNAME);
        put("email", EMAIL);
        put("password_hash", PASSWORD_HASH);
        put("password_salt", PASSWORD_SALT);
    }};

    public void accessPage() {
        get(NEW_CUSTOMER_URL);

    }

    public void registerCustomer(Map<String, String> inputs) {
        for (String key : inputs.keySet()) {
            waitForElement(mapBys.get(key)).sendKeys(inputs.get(key));

        }
    }
}
