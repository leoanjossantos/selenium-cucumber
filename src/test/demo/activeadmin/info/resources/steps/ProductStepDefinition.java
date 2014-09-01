package demo.activeadmin.info.resources.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.activeadmin.info.resources.pages.ProductSearchPage;
import junit.framework.Assert;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by lsantos on 27/08/14.
 */
public class ProductStepDefinition {

    ProductSearchPage productSearch;

    public ProductStepDefinition(){
        productSearch = new ProductSearchPage();
    }


    @Given("^I am in functionality of search of the products$")
    public void i_am_in_functionality_of_search_of_the_products() throws Throwable {
        productSearch.getUrlAcess();
    }

    @When("^informing the datas the product:$")
    public void informing_the_datas_the_product(Map<String, String> values) throws Throwable {
        productSearch.inputFields(values);
        productSearch.clickFilter();
    }

    @Then("^should see the product in list$")
    public void should_see_the_product_in_list() throws Throwable {
        productSearch.isPresentOnList();
    }


    @Then("^Should see the message for search product:\"(.*?)\"$")
    public void should_see_the_message_for_search_product(String msg) throws Throwable {
        assertTrue(msg.equals(productSearch.returnMessageError()));
    }

    @Then("^Should see the empty fields$")
    public void should_see_the_empty_fields() throws Throwable {
        assertTrue(productSearch.isFieldsLoad());
    }

    @When("^Clear the fields of the products search$")
    public void clear_the_fields_of_the_products_search() throws Throwable {
        productSearch.clearFields();
    }

}
