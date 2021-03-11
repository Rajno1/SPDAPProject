package org.issi.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.issi.driver.DriverManager;
import org.issi.enums.ConfigProperties;
import org.issi.utilities.PropertyUtils;

import java.util.List;
import java.util.Map;

import static org.issi.pages.LoginPage.doLogin;

public class PhoneLogSteps {


    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps(String.class, String.class);
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        doLogin(username, password);
    }
    @When("user clicks on PhoneLog button")
    public void user_clicks_on_phone_log_button() {

    }

}
