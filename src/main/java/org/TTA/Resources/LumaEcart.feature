Feature: Ecart Scenarios

  Background:
    Given User is on login page
#    Given User is on login page "https://magento.softwaretestingboard.com/customer/account/login/"

  Scenario Outline: Login with invaid credentials
    When Enter invalid "<username>" and "<password>"
    Then User should not be able to login and respective error message is thrown "<error_msg>"
    Examples:
      | username                  | password           | error_msg
      | invalidjoebiden@gmail.com | invalid7878198@joe | "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."