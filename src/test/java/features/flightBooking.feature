Feature: Flight Booking

@FlightBooking
Scenario Outline: Search for flights with the given search criteria

Given I navigate to the Flight Booking Home Page
When I enter the <FromCity> and <ToCity> with Departure Date <DepartDate>
And I click on the Search button
Then All the flights matching the Search Criteria should be shown

Examples:
|FromCity|ToCity|DepartDate|
|BLR|PNQ|30/12| 
