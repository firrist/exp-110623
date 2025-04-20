Feature: Automate the FLEA Market

  @flea1
  Scenario: Landing Page v2
    Given I visit FLEA Market in the "qa" Environment v2
    Then I verify title is "e-commerce – Automation Practice Website" for the page v2
    When I verify and Click on "Mac" Category on the Top Bar v2
    Then I verify Cart Icon is present v2
    Then I verify Image Slider is present v2
    Then I verify Contact button functionality v2
    Then I take screenshot

  @flea1
  Scenario Outline: Landing page category tests v2
    Given I visit FLEA Market in the "qa" Environment v2
    Then I verify title is "e-commerce – Automation Practice Website" for the page v2
    Then I verify and Click on "<name>" Category on the Top Bar v2
    Then I take screenshot
    Examples:
      | name        |
      | Mac         |
      | iPhone      |
      | Watch       |
      | Accessories |

  @flea1
  Scenario Outline: Product Page v2
#      Find the Product By Name and Click it
#      Verify Product Description Page contains Product Name
#      Increase the Counter and Add to Cart
#      Verify Product has been added
    Given I visit FLEA Market in the "qa" Environment v2
    Then I find the Product with "<name>" and click it v2
    Then I verify product description page contains product "<name>" v2
    Then I increase the counter and add to cart v2
    Then I verify product "<name>" has been added v2
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
  Scenario Outline: Add to Cart functionality v2
    Given I visit FLEA Market in the "qa" Environment v2
    Then I add "<product>" to cart from landing page v2
    Then I click view cart and verify "<product>" is in cart v2
    Then I change the quantity of the "<product>" to "<quantity>" and click update v2
    Then I verify items are updated v2
    Then I click the remove icon and verify "<product>" is updated v2
    Then I take screenshot
    Examples:
      | product              | quantity |
      | iMac                 | 2        |
      | AirPods Pro          | 2        |
      | Apple Watch Series 6 | 3        |
      | IPhone 12            | 3        |
      | IPhone XR            | 2        |
      | Macbook Air          | 4        |