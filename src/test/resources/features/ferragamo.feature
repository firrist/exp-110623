Feature: Verifying Details on a Ferragamo Leather Moccasin Page
#  Scenario: Searching for a Leather Moccasin
#    Given I visit the Ferragamo website
#    When I enter "Leather Moccasin" into the search bar
#    And I click the search button
#    Then I should see search results related to "Leather Moccasin"
#    And the results should mention "Leather Moccasin"


  Scenario: Searching for a Ferragamo Leather Moccasin
    Given I open url "https://www.ferragamo.com/"
    Then I wait for 2 sec
    Then I click on element with xpath "//button[@data-test='icon-search']"
    Then I type "moccasin" into element with xpath "//input[@id='search-input']"
    And I wait for 2 sec
    Then I mouse over element with xpath "(//p[contains(text(), 'Moccasin')]/..)[1]"
    Then I click on element with xpath "(//p[contains(text(), 'Moccasin')]/..)[1]"
#    Then I press enter for element with xpath "//input[@id='search-input']"
#    Then I click on element with xpath "//div[@data-test='banner-close-icon']"
#    Then I wait for 3 sec
    Then I wait for element with xpath "//div[@class='custom-xo4j54 e1us0qi80']" to be present
    Then element with xpath "//div[@class='custom-xo4j54 e1us0qi80']" should contain text "moccasin"

#  Scenario: Verifying Product Details
#    Given I am on the product page for "Moccasin with Gancini ornament"
#    Then I should see the product image displayed
#    And the product name should be "Moccasin with Gancini ornament"
#    And the product description should contain "calfskin"
#    And the price details should be clearly displayed
#    And color and size options should be available
#    And there should be an "Add to Bag" button
  
  Scenario: Verifying Product Details (Moccasin with Gancini ornament)
    Given I open url "https://www.ferragamo.com/en-us/shopping/moccasin-with-gancini-ornament-12540739"
    And I wait for element with xpath "//p[@data-test='details-name']" to be present
    Then element with xpath "//p[@data-test='details-name']" should contain text "Gancini ornament"
    Then element with xpath "(//picture[@data-test='responsive-image']//img[@alt='Moccasin with Gancini ornament | color: Black | materials: Calf Leather,Leather,Rubber Image 1 of 4 '])[1]" should be displayed
    Then I take screenshot
    Then element with xpath "//span[@id='details-info-0']" should contain text "calfskin"
    Then element with xpath "//button[@data-test='details-add-to-bag']" should be displayed
    Then element with xpath "//span[@data-test='details-price-normal']" should be displayed
    Then element with xpath "//div[@data-test='details-sizes-size-selector']" should be displayed


#Feature: Searching for the Cartier Love Bracelet

#  Background:  As a jewelry enthusiast,
#  I want to learn more about the Cartier Love Bracelet,
#  So I can appreciate its design, features, and history.
#
#  Scenario: Searching for a Cartier Love Bracelet
#    Given I visit the Cartier website
#    When I enter "Love Bracelet" into the search bar
#    And I click the search button
#    Then I should see search results related to "Love Bracelet"
#    And result should mention "Love Bracelet"

  Scenario: Searching for the Cartier Love bracelet

    Given I open url "https://www.cartier.com/"
    Then I click on element using JavaScript with xpath "(//button[@title='Toggle search bar'])[2]"
    Then I type "Love bracelet" into element with xpath "//input[@id='siteSearch']"
    Then I click on element with xpath "//button[@title='Submit search']"
    Then I should see page title contains "Love bracelet"
    Then I wait for element with xpath "//div[@data-search-component='product-grid']" to be present
    Then element with xpath "//div[@data-search-component='product-grid']" should contain text "love bracelet"
    Then I take screenshot