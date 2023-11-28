# Use Case 1 - Place Ship on Board

When the game starts the player will have to decide where to place his/her ship.
We do this during the initialization process of the Board object.

1) Call to Board constructor.
2) Set the xMax and yMax giving the size of the board.
3) Generate a ship.
4) Place ship on Board, making sure it stays within the boundaries of the Board and doesn't cover any other ship already on the board.
5) If ships array < 5 goto 3 and repeat.
6) Ship and Board initialization process complete.