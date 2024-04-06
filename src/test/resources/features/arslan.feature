Feature:

  Scenario: (Smoke Test) Fill out the required fields of quote and arrive - Arslan
    Given I visit Quote Page in the "Stage" environment
    When I enter "Test" for the Username Field
    And I enter "Test" for the first name and "Test" for the last name in the Name field
    And I enter "test@gmail.com" for the Email field
    When I enter "12345" for the Password field
    And I enter "12345" for the Confirm Password field
    Then I "check" the Privacy Policy Checkbox
    When I click on the "" button at the bottom of the Page
    Then I verify we see the Submitted Application Page