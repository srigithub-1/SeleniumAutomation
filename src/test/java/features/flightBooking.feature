Feature: Flight Booking on the Test Website "www.phptravels.net"

# Flight Booking tag is used in main file i.e. TestNGTestRunner.java. Scenario Outline is used when there are multiple data sets to be run
@FlightBooking
Scenario Outline: Search for flights with the given search criteria

# Given, When, And and Then is part of the Cucumber BDD framework
Given I navigate to the Flight Booking Home Page
When I enter the FromCity and ToCity with Departure Date from sheet <SheetName> with rowNumber <RowNumber>
And I click on the Search button
Then All the flights matching the Search Criteria should be shown

# Examples calls out the different test data sets to be run
Examples:
|SheetName|RowNumber|
|Sheet1|1|
|Sheet1|2|
|Sheet1|3|
|Sheet1|4|
