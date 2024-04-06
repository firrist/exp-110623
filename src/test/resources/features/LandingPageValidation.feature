Feature:
  Scenario: Landing page UI validation
    Given I open url "https://store-qa.portnov.com/"
    Then I verify page title is "e-commerce – Automation Practice Website"
#    Then I verify product categories "Mac,iPhone,Watch,Accessories"
    Then I verify product category "Mac" is displayed
    Then I verify product category "iPhone" is displayed
    Then I verify product category "Watch" is displayed
    Then I verify product category "Accessories" is displayed
    Then I verify cart icon is displayed
    Then I verify image slider is displayed