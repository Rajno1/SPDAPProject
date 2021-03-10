Feature: Medicare plans feature

  Background:
    Given user has already logged in to application
      | username  | password |
      | Applicant | Issi123# |
    When user gets the title of the page
    Then page title should be "- Maryland Residential Portal"
    When user clicks on MedicarePlans menu
    When user gets the title of the page
    Then page title should be "Medicare Plans - Maryland Residential Portal"

  Scenario Outline: Searching medicare plan using organization and plan name
    When user enters organization name "<organization>" and "<planName>"
    Then user should found "<organization>" name and "<planName>" name in search field
    Examples:
      | organization       | planName                       |
      | United Health Care | AARP MedicareRx Walgrees (PDP) |