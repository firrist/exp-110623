@flea3
  Scenario: Product Page
    Given I visit FLEA Market in the "qa" Environment
    Then I verify title is "e-commerce – Automation Practice Website" for the page
    When I wait and click on a product "Apple Watch Series 6" on the Landing Page
    When I verify Description contains text "Apple Watch Series 6"
    When I add "2" items to Cart and verify Cart

  @flea4
  Scenario Outline: Product Page Outline
    Given I visit FLEA Market in the "qa" Environment
    Then I verify title is "e-commerce – Automation Practice Website" for the page
    When I wait and click on a product "<product>" on the Landing Page
    When I verify Description contains text "<product>"
    When I add "2" items to Cart and verify Cart
    Examples:
      | product               |
      | Apple Watch Series 6  |
      | AirPods Pro           |
      | iMac                  |
      | IPhone 12             |
      | IPhone XR             |
      | Macbook Air           |