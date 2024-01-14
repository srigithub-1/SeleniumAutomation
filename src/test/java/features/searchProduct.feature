Feature: Search and Place order for products

# Scenario: Search experience for product search in home page and offers page
#Given User is on Green cart landing page
#When user search with short name "Tom" and extract the actual name of the product
#Then user search with short name "Tom" in offers page to check if product exists

@OffersPage
Scenario Outline: Search experience for product search in home page and offers page

Given User is on Green cart landing page
When user search with short name <Name> and extract the actual name of the product
Then user search with short name <Name> in offers page to check if product exists

Examples:
| Name |
| Tom  |
| Beet |