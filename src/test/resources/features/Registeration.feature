
Feature: Customer Registration

  Background:
    Given User navigates to Registration page

  @Negative
  Scenario: Register with invalid customer information

    When User enters first name "Ahmed"
    And User enters last name "Ali"
    And User enters date of birth "01/01/2025"
    And User enters email "ahmedgmail.com"
    And User enters phone number "12sad"
    And User enters street "Cairo"
    And User enters city "Cairo"
    And User enters state "Cairo"
    And User enters country "Egypt"
    And User enters postcode "12345"
    And User enters House number "42"
    And User enters password "Password123"
    And User submits the registration form

    Then Date of birth validation message should be displayed
    And Email validation message should be displayed
    And Phone validation message should be displayed



  @Positive
  Scenario Outline: Successful customer registration and login

    When User enters first name "<firstName>"
    And User enters last name "<lastName>"
    And User enters date of birth "<dob>"
    And User enters street "<street>"
    And User enters postcode "<postcode>"
    And User enters House number "<House>"
    And User enters city "<city>"
    And User enters state "<state>"
    And User enters country "<country>"
    And User enters phone number "<phone>"
    And User enters email "<email>"
    And User enters password "<password>"
    And User submits the registration form

    And Registration should be successful
    And User navigates to Login page

    And User logs in with email "<email>" and password "<password>"

    Then User "<firstName>" and "<lastName>" should be displayed in the navigation bar

    Examples:
      | firstName | lastName | dob        | street     | postcode | city  | state | country | phone       | email                   | password   | fullName    | House|
      | Ahmed     | Ali      | 1998-12-20 | Nile Street| 12345    | Cairo | Cairo | Egypt   | 01012345678 | a2asasqdsxdsfsda001@gmail.com   | Test12@12345 | Ahmed Ali |  42  |
#      | Abdo      | Ali      | 1998-12-20 | Nile Street| 12345    | Cairo | Cairo | Egypt   | 01884654898 | abdfedaso@gmail.com     | Test12@12345 | Abdo Ali  |  45  |