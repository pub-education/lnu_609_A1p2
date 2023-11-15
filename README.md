<h1><center>Sinking Ships</center></h1>

A program by
Joakim Eriksson (je224cq)
Chris Johannesson (cj223bc)

When logging test to capture compilation errors use the following command-line
`>./gradlew test -PtestOutput="<log name>" > <path/to/<class name>Compile.log> 2>&1`
Where `<log name>` should be substituted for `<class name>Tests.log` e.g., `GameTests.log` and `GameCompile.log` respectively when testing the Game class.
