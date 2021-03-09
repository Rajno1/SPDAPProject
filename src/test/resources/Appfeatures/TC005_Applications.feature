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
  Scenario Outline: Adding new application
    When user clicks on Add New Application link
    When user gets the title of the page
    Then page title should be "Index - Maryland Residential Portal"
    When user fills personal information from given sheet name "Personal_Information" and <RowNumber>
    And user clicks on Next button in Personal info field
    When user fills application questions from given sheet name "Application_Questions" and <RowNumber>
    And user clicks on Next button in application questions field
    When user fills Representative Information from given sheet name "Representative_Information" and <RowNumber>
    And user clicks on Next button in Representative Information field
    When user fills Houserhold income Information from given sheet name "Household_income" and <RowNumber>
    And user clicks on Next button in Household income field
    When user fills attachments Information from given sheet name "Attachments" and <RowNumber>
    And user clicks on Next button in attachment field
    When user user accepts the declaration
    And user enters captcha and login password
    When user click on submit button to confim the application
    Then user gets the confirmation as "Dear Applicant,Your Application has been Registered for The Senior Prescription Drug Assistance Program."

    Examples:
      | RowNumber |
      | 0         |

  @SearchByApplicantNumber
  Scenario: Searching applicant using Application number
    When user enters applicant number
    Then user sould found Application number in search field

  @SearchByApplicantName
  Scenario: Searching applicant using Applicant name
    When user enters applicant name
    Then user sould found Application name in search field

