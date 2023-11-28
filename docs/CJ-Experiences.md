# Problems and thoughts I have had during the development process

I started this document way too late but better late than never I guess.

* Problem: 
  * While developing the Board class I realized I can't implement the Point class and I don't find any method to mock it either since it is a part of the Board class and not used in the BoardTest class.
* Solution:
  * I used int and char as separate variables instead of using the Point class. A solution I'm not really happy with.

