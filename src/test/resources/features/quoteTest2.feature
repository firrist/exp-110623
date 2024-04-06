Feature: Test Quote
  Scenario Outline: Smoke test - fill out required fields of Quote
    Given I visit Quote Page in the "Stage" Environment
    When I enter "<username>" for the Username field
    And I enter "<firstName>" for first name and "<lastName>" for the last name in the Name field
    And I enter "<email>" for the Email field
    When I enter "<password>" for the Password field
    And I enter "<password>" for the Confirm Password field
    Then I "check" the Privacy Policy Policy checkbox
    When I click on the "Submit" button at the bottom of the page
    Then I verify username is "<username>", first name is "<firstName>", last name is "<lastName>", email is "<email>", and password is ""
    Then I take screenshot

    Examples:
      |username| firstName|lastName|email|password|
      |tkan    |Tatyana   |Kan     |tkan@gmail.com   |12345abcd|
      |annbbq1 |Anna      |khurkina|annaqa@gmail.com |password123|
      |bblade  |Boris     |Danski  |borisb@gmail.com |1234qwerty |
      |jj12xd  |Jyothi    |Pradhan |jj12xd@gmail.com |io12xd*    |
      |sanSan45|Sanjay    |Patel   |sanjalp@gmail.com|admin123  |
