Feature: Verify the languages and Celebrities details for wiki website

  Background:
    Given I open browser to launch URL "https://en.wikipedia.org/wiki/Wiki"

  @TestScenario1
  Scenario Outline:
    Given I enter and select the language "<language>"
    Then I verify that page is displayed in the selected language "<language>" with "<PageTitle>"
    Examples:
      | language    | PageTitle                                |
      | Italiano    | Wiki - Wikipedia                         |
      | Nederlands  | Wiki - Wikipedia                         |
      | Interlingua | Wiki - Wikipedia, le encyclopedia libere |
      | Español     | Wiki - Wikipedia, la enciclopedia libre  |
      | Français    | Wiki — Wikipédia                         |
      | Português   | Wiki – Wikipédia, a enciclopédia livre   |
      | Română      | Wiki - Wikipedia                         |
      | Esperanto   | Vikio - Vikipedio                        |
      | Furlan      | Wiki - Vichipedie                        |
      | Corsu       | Wiki - Wikipedia                         |


  @TestScenario2
  Scenario Outline:
    Given I enter and select the celebrity "<CelebrityName>"
    Then I log the date of birth and spouse details for "<CelebrityName>"
    Examples:
      | CelebrityName      |
      | Scarlett Johansson |
      | Chris Hemsworth    |
      | Robert Downey Jr.  |
      | Dwayne Johnson     |
      | Chris Pratt        |
      | Don Cheadle        |
      | Mark Ruffalo       |
      | Ryan Reynolds      |
      | Paul Rudd          |
      | Tobey Maguire      |
