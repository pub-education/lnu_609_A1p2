# Software Requirements Specification (SRS) for Sink Ships

## 1. Introduction

### 1.1 Purpose
This document specifies the software requirements for Sink Ships, a terminal-based game inspired by Hasbro, Inc.'s Battleship board game. The game involves a player trying to sink all of the opponent's ships before the opponent sinks theirs.

### 1.2 Scope
Sink Ships is a command-line application where players input coordinates to target ships on a grid. The game is played against a computer opponent, with the goal of sinking all the opponent's ships.

### 1.3 Definitions, Acronyms, and Abbreviations
- **CLI:** Command Line Interface
- **TDD:** Test-Driven Development
- **SRS:** Software Requirements Specification

### 1.4 References
- Hasbro, Inc. Battleship Game Rules [[1](#ref-1-battleship-rules)]
- Sink Ships Game Rules [[2](#ref-2-sink-ships-rules)]

### 1.5 Overview
The following sections detail the functional and non-functional requirements, system features, and constraints of Sink Ships.

## 2. Overall Description

### 2.1 Product Perspective
Sink Ships is a standalone CLI application, simulating the Battleship game experience against a computer-controlled opponent.

### 2.2 Product Functions
- Placement of ships on a grid by the player.
- Turn-based gameplay against a computer opponent.
- Input of coordinates by the player to target ships.
- Automated targeting of player's ships by the computer.
- Tracking and display of hits, misses, and scores.

### 2.3 User Classes and Characteristics
- Players: Individuals seeking an engaging and strategic CLI-based game.

### 2.4 Operating Environment
The application will run in a CLI environment on systems supporting Java or a similar runtime environment.

### 2.5 Design and Implementation Constraints
- The application will be developed in a language suitable for CLI applications (e.g., Java, Python).
- The game interface will be text-based, with no graphical elements.

### 2.6 User Documentation
- A user manual will be provided, detailing gameplay mechanics and command-line options.

## 3. System Features

### 3.1 Ship Placement
- **Description:** Players can place 5 different ships on their board.
- **Functional Requirements:**
  - The system shall allow horizontal or vertical placement of ships.
  - The system shall prevent ships from overlapping or extending off the board.

### 3.2 Gameplay
- **Description:** Players and the computer take turns guessing ship locations.
- **Functional Requirements:**
  - The system shall accept coordinate inputs from the player.
  - The system shall provide feedback on hits or misses.
  - The system shall track and display the number of hits and misses after each round.

### 3.3 Winning Conditions
- **Description:** The game ends when all ships of a player are sunk.
- **Functional Requirements:**
  - The system shall announce when a ship is hit and sunk.
  - The system shall declare the winner when all ships of one player are sunk.

## 4. External Interface Requirements

### 4.1 User Interfaces
- The application shall provide a CLI for all interactions.
- The interface shall display the game grid, feedback on hits/misses, and scores.

### 4.2 Hardware Interfaces
- No specific hardware interface is required beyond a standard keyboard and display.

### 4.3 Software Interfaces
- The application shall run on a standard Java or Python runtime environment.

## 5. Non-Functional Requirements

### 5.1 Performance Requirements
- The game shall respond to user input within 2 seconds.

### 5.2 Safety Requirements
- The application shall not interfere with the operating system's stability.

### 5.3 Security Requirements
- No specific security requirements, as the game does not handle sensitive data.

### 5.4 Software Quality Attributes
- **Reliability:** The application should perform consistently.
- **Usability:** The game should be intuitive and easy to play.
- **Maintainability:** Code should be well-documented for future updates or modifications.

## 6. Other Requirements
Any additional requirements or considerations not previously covered should be listed here.

## References
##### Ref-1: Battleship [Rules](./battleship-classic-board-game-strategy-game-for-kids-ages-7-and-up.pdf)
##### Ref-2: Sink Ships [Rules](./GameRules.md)