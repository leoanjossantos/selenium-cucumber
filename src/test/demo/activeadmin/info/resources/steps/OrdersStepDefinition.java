package demo.activeadmin.info.resources.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.activeadmin.info.resources.pages.OrdersPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by lsantos on 26/08/14.
 */
public class OrdersStepDefinition {

    private OrdersPage ordersPage;

    public OrdersStepDefinition(){
        ordersPage = new OrdersPage();
    }

    @Given("^I am in functionality of search of the orders$")
    public void i_am_in_functionality_of_search_of_the_orders() throws Throwable {
        ordersPage.acessOrderPage();
    }

    @When("^Search for orders:$")
    public void search_for_orders(Map<String, String> element) throws Throwable {
        ordersPage.loadFields(element);
        ordersPage.clickOnFilter();
    }

    @Then("^sould see itens in list$")
    public void sould_see_itens_in_list() throws Throwable {
        assertTrue(ordersPage.isPresentOnList());
    }

    @Then("^I see all empty fields$")
    public void i_see_all_empty_fields() throws Throwable {
        ordersPage.clearFields();
        ordersPage.isFieldsLoad();
    }

    @Then("^should see message \"(.*?)\"$")
    public void should_see_message(String msg) throws Throwable {
        assertTrue(ordersPage.returnMessageError().equals(msg));
    }


}
