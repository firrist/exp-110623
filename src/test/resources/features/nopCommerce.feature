Feature:

  Scenario: Test scenario nop cart
    Given I open url "https://nop-qa.portnov.com/"
    Then I click on element using JavaScript with xpath "(//a[contains (text(), 'Computers')])[1]"
    Then I click on element using JavaScript with xpath "(//a[@href='/desktops'])[1]"
    Then I should see page title contains "Desktops"
    Then I wait for 2 sec
    Then I click on element using JavaScript with xpath "//h2/a[contains(text(), 'Build your')]"
    Then I should see page title contains "Build"
    Then I click on element using JavaScript with xpath "//dd[@id='product_attribute_input_2']"
    Then I click on element using JavaScript with xpath "//select[@name='product_attribute_2']//option[@value=3]"
    Then I click on element using JavaScript with xpath "//select[@name='product_attribute_2']//option[contains(text(), '2 GB')]"
#    Then I click on element using JavaScript with xpath "//input[@class='qty-input valid']"
#    Then I type "2" into element with xpath "//input[@class='qty-input valid']"
    Then I click on element with xpath "//button[@id='add-to-cart-button-1']"
    Then I wait for 2 sec
    Then I click on element with xpath "//button[@id='add-to-cart-button-1']"
    Then I wait for 2 sec
    Then I click on element using JavaScript with xpath "//span[@class='cart-label']"
    Then I should see page title contains "Cart"
    Then element with xpath "//span[contains(text(),'1,315')]/.." should be displayed
    Then element with xpath "//span[contains(text(),'2,630')]/." should be displayed
    Then element with xpath "//strong[contains(text(), '2,630')]/." should be displayed

  Scenario: Test the shopping cart Artem's correct version
    Given I open url "https://nop-qa.portnov.com/"
    Then I mouse over element with xpath "//li[contains(a/text(),'Computers')]"
    Then I wait for element with xpath "//a[@href='/desktops']" to be present
    Then I click on element with xpath "//a[@href='/desktops']"
    Then I click on element with xpath "//h2[@class='product-title']//a[contains(text(),'Build')]"
    Then I click on element with xpath "//select[@name='product_attribute_2']//option[@value='3']"
    Then I click on element with xpath "//input[@id='product_attribute_3_6']"
    Then I clear element with xpath "//input[@id='product_enteredQuantity_1']"
    Then I type "2" into element with xpath "//input[@id='product_enteredQuantity_1']"
    Then I click on element with xpath "//button[@id='add-to-cart-button-1']"
    Then I click on element with xpath "//span[contains(text(),'Shopping cart')]"
    Then I wait for element with xpath "//td[@class='unit-price' and contains(span[@class='product-unit-price'],'$1,315.00')]" to be present
    Then element with xpath "//*[contains(text(), 'Build your own computer')]//../..//span[@class='product-subtotal']" should contain text "$2,630.00"
    Then element with xpath "//tr[@class='order-total']/td/span/strong" should contain text "$2,630.00"
    And I wait for 5 sec

    # Given client open the main page https://nop-qa.portnov.com (Deepa's)
# Then client opens Electronics->Cell phones category
# Then client clicks on Nokia Lumia
# And client clicks ‘Add to cart button’
# Then client opens Apparel->Shoes category
# Then the client clicks on Nike Floral Roshe Customized Running Shoes
# Then the client selects 9 from the Size dropdown menu
# Then the client selects White/Blue from the Color dropdown menu
# Then the client select the Fresh floral image
# And client clicks ‘Add to cart button’
# Then client clicks on Books menu
# Then the client clicks on Pride and Prejudice
# Then the client clicks ‘Add to cart button’
# Then client opens shopping cart
# And client should see Nokia Lumia 1020 product with the price as $349
# And client should see Nike Floral Roshe Customized Running Shoes Size:9,
# Color:White/Blue,Print:Fresh with the price as $40
# And client should see Pride and Prejudice with the price as $24
# And client should see the Total as $413.00
# Then the client removes Pride and Prejudice from the Shopping Cart
# And client should see Total as $389

  Scenario: A test to add and delete items from the shopping cart (Deepa's)
    Then I mouse over element with xpath "(//ul[@class='top-menu notmobile']/li[2])"
    Then I click on element with xpath "(//a[contains(text(),'Cell phones')])[1]"
    Then I click on element with xpath "//h2/a[contains(text(),'Nokia Lumia 1020')]"
    Then I click on element with xpath "//button[@id='add-to-cart-button-20']"
    Then I mouse over element with xpath "(//ul[@class='top-menu notmobile']/li[3])"
    Then I click on element with xpath "(//a[contains(text(),'Shoes')])[1]"
    Then I click on element with xpath "//h2/a[contains(text(),'Nike Floral')]"
    Then I click on element with xpath "//select[@name='product_attribute_6']//option[@value='14']"
    Then I click on element with xpath "//select[@name='product_attribute_7']//option[@value='17']"
    Then I click on element with xpath "(//span[@class='attribute-square'])[2]"
    Then I mouse over element with xpath "//div[@class='master-wrapper-page']"
    Then I click on element with xpath "//button[@id='add-to-cart-button-24']"

    Then I click on element with xpath "(//ul[@class='top-menu notmobile']/li[5])"
    Then I click on element with xpath "//h2/a[contains(text(),'Pride and Prejudice')]"
    Then I click on element with xpath "//button[@id='add-to-cart-button-39']"
    Then I wait for element with xpath "//span[@class='cart-label']" to be present
    Then I click on element with xpath "//span[@class='cart-label']"

    Then I wait for element with xpath "//td[@class='unit-price' and contains(span[@class='product-unit-price'],'$349.00')]" to be present
    Then element with xpath "//*[contains(text(), 'Nokia Lumia 1020')]//../..//span[@class='product-subtotal']" should contain text "$349.00"

    Then I wait for element with xpath "//td[@class='unit-price' and contains(span[@class='product-unit-price'],'$40.00')]" to be present
    Then element with xpath "//*[contains(text(), 'Nike Floral Roshe Customized Running Shoes')]//../..//span[@class='product-subtotal']" should contain text "$40.00"

    Then I wait for element with xpath "//td[@class='unit-price' and contains(span[@class='product-unit-price'],'$24.00')]" to be present
    Then element with xpath "//*[contains(text(), 'Pride and Prejudice')]//../..//span[@class='product-subtotal']" should contain text "$24.00"

    Then element with xpath "//tr[@class='order-total']/td/span/strong" should contain text "$413.00"
    Then I click on element with xpath "//td/a[contains(text(), 'Pride and Prejudice')]/../..//button[@name='updatecart']"

    Then element with xpath "//td/a[contains(text(), 'Pride and Prejudice')]/../.." should not be present
    Then element with xpath "//tr[@class='order-total']/td/span/strong" should contain text "$389.00"
    Then I scroll to the element with xpath "//tr[@class='order-total']/td/span/strong" with offset 5
    Then I wait for 5 sec


  Scenario: testing Delete from Shopping Cart functionality (one item)
    Given I open url "https://nop-qa.portnov.com/"
    Then I mouse over element with xpath "//li[contains(a/text(),'Electronics')]"
    Then I wait for element with xpath "//a[@href='/cell-phones']" to be present
    Then I click on element with xpath "//a[@href='/cell-phones']"
    Then I click on element with xpath "//div[@data-productid='18']//button[contains(text(), 'Add to cart')]"
    Then I wait for 5 sec
    Then I click on element with xpath "//span[contains(text(),'Shopping cart')]"
    Then element with xpath "//div[@class='page shopping-cart-page']" should contain text "Android"
    Then I click on element with xpath "//td[@class='remove-from-cart']/button[@class='remove-btn']"
    Then I wait for 2 sec
    Then element with xpath "//div[@class='page shopping-cart-page']" should contain text "Your Shopping Cart is empty"
    Then I take screenshot

  Scenario: testing Delete from Shopping Cart functionality (multiple items)
    Given I open url "https://nop-qa.portnov.com/"
    Then I mouse over element with xpath "//li[contains(a/text(),'Electronics')]"
    Then I wait for element with xpath "//a[@href='/cell-phones']" to be present
    Then I click on element with xpath "//a[@href='/cell-phones']"
    Then I click on element with xpath "//div[@data-productid='18']//button[contains(text(), 'Add to cart')]"
    Then I wait for 2 sec
    Then I click on element with xpath "//div[@data-productid='20']//button[contains(text(), 'Add to cart')]"
    Then I wait for 5 sec
    Then I click on element with xpath "//span[contains(text(),'Shopping cart')]"
    Then element with xpath "//div[@class='order-summary-content']" should contain text "Android"
    Then element with xpath "//div[@class='order-summary-content']" should contain text "Nokia"
    Then I click on element with xpath "//td[@class='remove-from-cart']/button[@class='remove-btn']"
    Then element with xpath "//div[@class='order-summary-content']" should not contain text "Android"
    Then I click on element with xpath "//td[@class='remove-from-cart']/button[@class='remove-btn']"
    Then I wait for 2 sec
    Then element with xpath "//div[@class='page shopping-cart-page']" should contain text "Your Shopping Cart is empty"
    Then I take screenshot


    Scenario Outline: Quotes requests for users
      Given I open url "https://quote-stage.portnov.com/"
      Then I click on element with xpath "//input[@id='name']"
      Then I type "<FirstName>" into element with xpath "//input[@id='firstName']"
      Then I type "<MiddleName>" into element with xpath "//input[@id='middleName']"
      Then I type "<LastName>" into element with xpath "//input[@id='lastName']"
      Then I click on element with xpath "//span[contains(text(), 'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "<FullName>"
      Examples:
        |FirstName  | MiddleName  | LastName | FullName |
        |Test       |Testovich    |Testov    |Test Testovich Testov|
        |John       |             |Doe       |John Doe             |
        |Artem      |             |Oganesyan |Artem Oganesyan      |


#  Scenario: Searching for a Leather Moccasin
#    Given I visit the Ferragamo website
#    When I enter "Leather Moccasin" into the search bar
#    And I click the search button
#    Then I should see search results related to "Leather Moccasin"
#    And the results should mention "Leather Moccasin"
  
  Feature: Verifying Details on a Ferragamo Leather Moccasin Page

    Scenario: Searching for a Leather Moccasin
      Given I open url "https://www.ferragamo.com/"
      Then I click on element with xpath "//button[@data-test='icon-search']"
      Then I type "Leather Moccasin" into element with xpath "//input[@id='search-input']"
      Then I press enter for element with xpath "//input[@id='search-input']"
      


