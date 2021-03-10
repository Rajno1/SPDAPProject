Feature: ApplicationsList feature

  Background:
    Given user has already logged in to application
      | username  | password |
      | Applicant | Issi123# |
    When user gets the title of the page
    Then page title should be "- Maryland Residential Portal"
    When user clicks on Applications menu
    When user gets the title of the page
    Then page title should be "ApplicationsList - Maryland Residential Portal"

  @NewApplication
  Scenario: Adding new application
    When user clicks on Add New Application link
    When user gets the title of the page





