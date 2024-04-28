# Tic Tac Toe

## Description
This is a console-based Tic Tac Toe game implemented in Java. The game allows two players to play against each other, or a player can choose to play against a computer-controlled bot. The bot's difficulty level can be adjusted, providing players with varying levels of challenge.

## Features
- Two-player gameplay
- Single-player mode against a bot with adjustable difficulty levels (Easy, Medium, Hard)
- Clear console-based user interface
- Win detection algorithm for rows, columns, and diagonals
- Option to restart the game after completion

## Project Structure
The project structure is organized as follows:
- **src/main/java/org/example/**: Contains all Java source files.
  - `Main.java`: Entry point of the application.
  - `TicTacToeMain.java`: Main class responsible for running the Tic Tac Toe game.
  - `controllers/GameController.java`: Controller class managing the game flow.
  - `factories/BotPlayingFactory.java`: Factory class for creating bot players.
  - `models/`: Package containing all model classes representing game entities.
  - `strategyManager/`: Package containing strategy manager classes for bot playing and winning strategies.

## Getting Started
To run the Tic Tac Toe game locally, follow these steps:
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Navigate to the `TicTacToeMain.java` file and run it.
4. Follow the on-screen instructions to play the game.

## Usage
- Upon launching the game, you'll be prompted to choose between playing against another player or against the computer.
- If playing against the computer, you can choose the bot's difficulty level (Easy, Medium, Hard).
- Players take turns marking empty cells on a 3x3 grid with their respective symbols ('X' or 'O').
- The game ends when one player wins by achieving three of their symbols in a row, column, or diagonal, or when the board is filled without a winner, resulting in a draw.
- You have the option to restart the game after completion.


## Contributing
Contributions to this project are welcome! If you'd like to contribute, please follow these steps:
1. Fork this repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature-name`).
5. Create a new Pull Request.


## Contact
For any questions or feedback regarding this project, please feel free to contact the project maintainer:
- Email: [kvsmanikanta2612@gmail.com]
