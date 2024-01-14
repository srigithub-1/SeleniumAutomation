Feature: Flight Booking on the Test Website "www.phptravels.net"

@FlightBooking
Scenario Outline: Search for flights with the given search criteria

Given I navigate to the Flight Booking Home Page
When I enter the FromCity and ToCity with Departure Date from sheet <SheetName> with rowNumber <RowNumber>
And I click on the Search button
Then All the flights matching the Search Criteria should be shown

Examples:
|SheetName|RowNumber|
|Sheet1|1|
|Sheet1|2|
|Sheet1|3|
|Sheet1|4|

#|FromCity|ToCity|DepartDate|
#|BLR|PNQ|15-01-2024| 
#|DEL|CHN|20-01-2024| 
