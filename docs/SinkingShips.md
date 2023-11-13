<h1><center>Sinking ships</center></h1>

**Application:** Terminal application

[Game Rules](./GameRules.md)

Decide the matrix size on initialization.
Show each cell that has been shot at and each hit.
1)	Start Game
2)	Place ships, computer and player
3)	Player starts, 
4)	Player giving a coordinate.
5)	Result hit or miss printed to terminal
6)	isPlayerWinner? I.e., does computer have any non-hit ships? If yes continue else goto 10)
7)	Computer picks a coordinate and we print that to terminal
8)	Register if it was a hit or miss
9)	isComputerWinner? I.e., has the player any non-hit ships? If yes goto 4) else continue
10)	Print winner to terminal
11)	New game?
12)	End Game!

 
Game Start
Standard size: 10x10 Board [a1-a10] [j1-j10]
Read args if exists otherwise use standard size.
Instantiate Game, Computer and Player
