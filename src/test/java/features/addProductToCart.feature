Feature: Product Checkout
# Scenario: Search experience for product search in home page and offers page
#Given User is on Green cart landing page
#When user search with short name "Tom" and extract the actual name of the product
#Then user search with short name "Tom" in offers page to check if product exists

@CheckOutPage
Scenario Outline: Adding the item to cart and complete the Checkout

Given User is on Green cart landing page
When user search with short name <Name> and extract the actual name of the product
Then user adds the item <Count> times
Then user adds the item to cart
And user checkout the item

Examples:
| Name |  Count |
| Cucu  | 2 |
| Beans | 3 |
| Suts | 4|