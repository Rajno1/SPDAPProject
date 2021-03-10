package org.issi.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import static org.issi.pages.SearchApplicantPage.*;

public class SearchApplicantSteps {
    // searching applicant by boath number and name
    @When("user enters applicant number {int}")
    public void user_enters_applicant_number(Integer appNum) {
        enterApplicantNumber(appNum);
        log().info("Entered applicant number as "+appNum+" in search field");
        waitupto(500);
    }
    @Then("user should found {int} in search field")
    public void user_should_found_in_search_field(Integer appNum) {
        Assertions.assertThat(searchByApplicantNum(appNum)).isEqualTo(true);
        log().info("Applicant number" +appNum + " found in search field");
    }


    @When("user enters applicant name {string}")
    public void user_enters_applicant_name(String name) {
        enterApplicantName(name);
        log().info("Entered applicant name as "+name+" in search field");
        waitupto(500);
    }
    @Then("user sould found {string} in search field")
    public void user_sould_found_in_search_field(String name) {
        Assertions.assertThat(searchByApplicantName(name)).isEqualTo(true);
        log().info("Applicant name " +name+ " found in search filed");
    }


}
