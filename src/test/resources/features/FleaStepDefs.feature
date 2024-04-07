Feature: Automate the FLEA Market

  @flea1
  Scenario: Landing Page
    Given I visit FLEA Market in the "qa" Environment
    Then I verify title is "e-commerce – Automation Practice Website" for the page
    When I verify and Click on "Mac" Category on the Top Bar
    Then I verify Cart Icon is present
    Then I verify Image Slider is present
    Then I verify Contact button functionality
    Then I take screenshot

  @flea1
  Scenario Outline: Landing page category tests
    Given I visit FLEA Market in the "qa" Environment
    Then I verify title is "e-commerce – Automation Practice Website" for the page
    Then I verify and Click on "<name>" Category on the Top Bar
    Then I take screenshot
    Examples:
      | name        |
      | Mac         |
      | iPhone      |
      | Watch       |
      | Accessories |

  @flea1
  Scenario Outline: Product Page
#      Find the Product By Name and Click it
#      Verify Product Description Page contains Product Name
#      Increase the Counter and Add to Cart
#      Verify Product has been added
    Given I visit FLEA Market in the "qa" Environment
    Then I find the Product with "<name>" and click it
    Then I verify product description page contains product "<name>"
    Then I increase the counter and add to cart
    Then I verify product "<name>" has been added
    Then I take screenshot
    Examples:
      | name                 |
      | iMac                 |
      | AirPods Pro          |
      | Apple Watch Series 6 |
      | IPhone 12            |
      | IPhone XR            |
      | Macbook Air          |

  @flea1
  Scenario Outline: Add to Cart functionality
    Given I visit FLEA Market in the "qa" Environment
    Then I add "<product>" to cart from landing page
    Then I click view cart and verify "<product>" is in cart
    Then I change the quantity of the "<product>" to "<quantity>" and click update
    Then I verify items are updated
    Then I click the remove icon and verify "<product>" is updated
    Then I take screenshot
    Examples:
      | product              | quantity |
      | iMac                 | 2        |
      | AirPods Pro          | 2        |
      | Apple Watch Series 6 | 3        |
      | IPhone 12            | 3        |
      | IPhone XR            | 2        |
      | Macbook Air          | 4        |