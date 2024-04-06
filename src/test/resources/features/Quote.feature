Feature: Quote tests


  Background:
    Given I open url "https://quote-stage.portnov.com/"


  Scenario: Required fields validation
    Then I click on element with xpath "//button[@name='formSubmit']"
    Then  element with xpath "//label[contains (text(), 'This field is required')]/." should be displayed
    Then element with xpath "//label[@for='agreedToPrivacyPolicy']" should be displayed
    Then I take screenshot
    
  Scenario: Successful form submission
    Then I type "Tatyana" into element with xpath "//input[@name='firstName']"
    Then I type "t_kan" into element with xpath "//input[@name='username']"
    Then I type "tkan@gmail.com" into element with xpath "//input[@name='email']"
    Then I type "1234567890" into element with xpath "//input[@name='password']"
    Then I type "1234567890" into element with xpath "//input[@name='confirmPassword']"
    Then I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then I click on element using JavaScript with xpath "//button[@name='formSubmit']"




  Scenario Outline: Quotes requests for users
    Given I open url "https://quote-stage.portnov.com/"
    Then I click on element with xpath "//input[@id='name']"
    Then I type "<FirstName>" into element with xpath "//input[@id='firstName']"
    Then I type "<MiddleName>" into element with xpath "//input[@id='middlename']"
    Then I type "<LastName>" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "//span[contains(text(), 'Save')]"
    Examples:
      | FirstName | MiddleName  | LastName |
      |Test       | Testovich   |Testov    |
      |John       |             |Doe       |
      |Artem      |             |Oganesyan |

      


