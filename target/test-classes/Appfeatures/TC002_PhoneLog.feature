Feature: PhoneLog feature

  Background:
    Given user has already logged in to application
      | username  | password |
      | Admin | Issi123# |
    When user gets the title of the page
    Then page title should be "About"

  @NewApplication
  Scenario: Adding new PhoneLog
    When user clicks on PhoneLog button
    When user gets the title of the page
    Then page title should be "Index"






