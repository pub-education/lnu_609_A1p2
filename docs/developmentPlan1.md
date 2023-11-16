# Development Plan

## Symbols

- Ships are denoted when not hit with capital letters and the hit parts of a ship with lower case letters.
  - Aircraft Carrier [A/a] (5 space)
  - Battleship [B/b] (4 spaces)
  - Cruiser [C/c] (3 spaces)
  - Submarine [S/s] (3 spaces)
  - Destroyer [D/d] (2 spaces)
- Non-hit areas are denoted by blank space
- Miss is denoted by an o and hits by a lower case letter denoting the type of ship, i.e., a for Aircraft Carrier s for Submarine etc.

## Iteration 1

- Start Game
    - Create all the ships for each player in Board
    - Place ships on board
    - Player do this through command line
    - Computer does this randomly automatically. All ships are hidden (cells hidden = true)

### Player placement of ships via terminal

  1. Asks for coordinate for the aft of the ship
  2. Player enters coordinate of the for letter number e.g., d4
  3. Print out the sea (Board) with the ship pointing East if possible otherwise West.
  4. Develop logic to handle what should happen if another ship is blocking the placement. Put as a rule in model.rules
  5. Asks for rotation n North, e East, s South, w West
  6. If ship placement is OK repaint the sea (Board) with the ship in the requested direction.
  7. Then next ship otherwise repeat.

### Classes responsibilities (to be deleted - Joakims damned notes)

#### Point

- x int
- y int

#### Cell

- position Point
- value [from Enum Ship -, A, a, B, b, C, c, D, d, S, s, +]
- hidden true/false
- hit?? true/false (conveniant but can be derived from value)

#### Ship

  Could be interface and different shiptypes could realize interface. Strategy to build ships in factory.

- aft Point (insertion point)
- rotation [enum ]
- cells []
- length int
- type [enum will give cell value/type]

#### Board

- cells [][]
- ships []

#### Game class

player
computer
rules

init() - build board,

Abstract player above humanPlayer and computerPlayer?

#### Player

board

#### Computer

board

### Game

- First print out the own sea (board)
- Print out the foreign sea.
- Print game rules. Offer game-start by pressing enter to continue
- Refresh boards and start rounds. HumanPlayer has the first turn as default.
- Game asks for hit coordinate.
- Player shoots by giving a coordinate of the form letter number e.g., d4
- Computer responds with saying "hit", "miss", or "hit and sunk"
- Check for winner (by rule). If player has no ships left...
- Present winner
- Opt user for new game or quit.
