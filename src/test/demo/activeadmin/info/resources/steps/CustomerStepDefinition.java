package demo.activeadmin.info.resources.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.activeadmin.info.resources.pages.CustomerRegisterPage;
import demo.activeadmin.info.resources.pages.CustomerSearchPage;

import static org.junit.Assert.assertTrue;

import java.util.Map;

/**
 * Created by lsantos on 22/08/14.
 */
public class CustomerStepDefinition {

    CustomerRegisterPage customerRegister;
    CustomerSearchPage customerSearch;

    public CustomerStepDefinition() {
        customerRegister = new CustomerRegisterPage();
        customerSearch = new CustomerSearchPage();
    }


    @Given("^I am functionality from customer registration$")
    public void I_am_functionality_from_customer_registration() throws Throwable {
        customerRegister.accessPage();
    }

    @When("^I create new customer:$")
    public void I_create_new_customer(Map<String, String> inputs) throws Throwable {
        customerRegister.registerCustomer(inputs);
    }

    @Then("^I must see the customer registration$")
    public void I_must_see_the_customer_registration() throws Throwable {
        // Express the Regexp above with the code you wish you had
    }


    @Given("^I am functionality of the customer search$")
    public void i_am_functionality_of_the_customer_search() throws Throwable {
        customerSearch.accessPage();
    }

    @When("^Search for:$")
    public void search_for(Map<String, String> imputs) throws Throwable {
        customerSearch.loadField(imputs);
        customerSearch.clickButtonFilter();
    }

    @Then("^Should see the message: \"(.*?)\"$")
    public void should_see_the_message(String msg) throws Throwable {
        assertTrue(customerSearch.returnMessageNotFound().equals(msg));
    }

    @Then("^I must see the customer in list$")
    public void i_must_see_the_customer_in_list(Map<String, String> element) throws Throwable {
        customerSearch.isPresentList(element);
    }


    @When("^fill the fieldes:$")public void fill_the_fieldes(Map<String, String> element) throws Throwable {
        customerSearch.loadField(element);
    }

    @When("^clear the fields$")
    public void clear_the_fields() throws Throwable {
        customerSearch.clearFields();
    }

    @Then("^The fields are empty$")
    public void the_fields_are_empty() throws Throwable {
        assertTrue(customerSearch.isFieldsLoad());
    }

}
