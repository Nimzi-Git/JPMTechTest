Expectations
Treat this exercise as if it was a task you were implementing as part of a normal working day. In your submission you are expected to include everything you would commit to source control before signing off the task as production ready.
     No database or UI is required
     You can assume the code will only ever be executed in a single threaded environment
     Minimise the number of external jar dependencies your code has. We would expect a maximum of one or two would be required.
     All data to be in memory.
     Output format to be plain text, printed out to the console.
     Create more sample data as needed.
     We would expect you to spend somewhere in the region of about 3 hours on this exercise.

The problem
     A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday. No other holidays to be taken into account.
     A trade can only be settled on a working day.
     If an instructed settlement date falls on a weekend, then the settlement date should be changed to the next working day.
     USD amount of a trade = Price per unit * Units * Agreed Fx

Requirements
Create a report that shows
     Amount in USD settled incoming everyday
     Amount in USD settled outgoing everyday
     Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy
      instruction, then foo is rank 1 for outgoing

Solution
    The tradepackage application addresses the above requirements and is developed following TDD approach.
    >> Application reads the JSON input file located in resource folder(data.json). Any particular trade can be inserted
       in the file in the below format:
            {
              "Entity": "TIM",
              "TradeMetod": "B",
              "AgreedFx": 0.20,
              "Currency": "INR",
              "InstructionDate": "01 Jan 2016",
              "SettlementDate": "01 Jan 2016",
              "Units": 40,
              "UnitPrice": 150.5
            }

    >> MainClass holds the main method to run and print the report in Console
    >> One external library json-simple has been used to read JSON file
    >> The application is maven built