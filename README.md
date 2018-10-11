CLI RPN Calculator
==================

High-level Description
--------------------

This is an implementation of a command-line reverse polish notation (RPN) calculator with the below features:

1. It uses standard input and standard output
2. It currently implements (but can be extended) the four standard arithmetic operators
3. It takes a valid number, operator, or an RPN-expression (please see Example Input/Output), and displays result for a successful calculation
4. In case of an invalid input, it displays error message and allows user to re-enter input
5. It exits when it receives a 'q' command or an end of input indicator (Ctrl+C on Windows)

Example Input/Output
--------------------

    > 5 
    5
    > 8
    8
    > +
    Calculating...: 5 + 8
	13.0
	q
	Exited.
---

    > 5 8 +
    Calculating...: 5 + 8
    13.0
    > 13 -
    Calculating...: 13.0 - 13
    0.0
	q
	Exited.

---

    > -3
    -3
    > -2
    -2
    > *
    Calculating...: -3 * -2
    6.0
    > 5
    5
    > +
    Calculating...: 6.0 + 5
    11.0
	q
	Exited.

---

    > 5
    5
    > 9
    9
    > 1
    1
    > -
    Calculating...: 9 - 1
    8.0
    > /
    Calculating...: 5 / 8.0
    0.625
	q
	Exited.

Reasoning Behind Technical Choices
--------------------
Since an operation always occurs on the *most recently entered last two operand numbers*, a Stack has been used to keep track of the entered numbers.
As soon as a valid operator sign is entered, the last two operands are removed from the Stack and the operation is applied on them. If the operation is successful, the result, which now becomes the last number, is added back to the Stack.
When the operation fails (for e.g. attempted to devide by zero), the removed operand numbers are put back in the Stack.
The Stack essentially makes removing the most recent operands, and restoring them back (after a failed operation), easy.   

The RPN-style calculation  has been implemented as a stand-alone service. Other styles of calculations may also be added, provided they implement the calculateExpression method in the ICalculatorService interface.

An OperatorFactory has also been used to abstract out the underlying operation or behavior of specific operator types. The factory returns  the  appropriate type of Operator based on the requested operator sign. This should make adding other new operators in future easier. 

Finally, while the current Calculator uses standard input and output, it should be possible to re-use the RPNCalculationService with other interfaces too, as long as they can invoke the calculateExpression method with the expected input.

Trade-offs
--------------------
While entering a 'q' allows the application exit gracefully, Occassionally, entering Ctrl+C on Window occassionally seems to be throwing an exception. Need to look into this more.

How to Run
--------------------
The ANT build framework is used to build the application.
Please run the below commands to build and run:

	ant

	java -cp bin calculator.Calculator

 