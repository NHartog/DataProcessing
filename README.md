
# InMemoryDatabase Implementation

## How to Run the Code

### Prerequisites
- Ensure you have Java Development Kit (JDK) installed (Version 8 or above recommended)
- Set up your Java development environment (e.g., IntelliJ IDEA, Eclipse, or a text editor with terminal access)

### Steps to Run
1. Open up a Java development environment and go to where the pre-made main.java file is
2. Copy the code from `src/main/java/org/example/InMemoryDatabase.java` into a file named `InMemoryDatabase.java` in your local project
3. Copy the code from `src/main/java/org/example/Main.java` into a file named `Main.java` in your local project
4. If all prior steps are followed correctly, you should be able to run the `public static void main(String[] args)` method
in the Main.java. This should produce an output

### Expected Output
- The program executes the test cases included in the `main` method.
- Ensure the output matches the expected results as shown below from the assignment problem: 

`null`

`Transaction is not in progress`

`null`

`6`

`No transaction in progress to commit`

`No transaction in progress to rollback`

`null`

`null`

---

## Future Improvements for Official Assignment

### Clarification of Instructions
- Explicitly define how transactions handle conflicting updates (such as overwriting the same key multiple times)
- Add clear explanations for edge cases, such as starting a new transaction without finalizing the previous one

### Additional Methods
- Introduce a `delete(key)` method to remove keys within a transaction
- Add a `has_key(key)` method to check the existence of a key in the databas

### Better Grading
- Provide automated test scripts to validate normal and edge case behavior
- Require students to implement unit tests to demonstrate their understanding

### Code Quality Requirements
- Encourage students to document their code with meaningful comments and follow consistent naming conventions
- Mention the use of `try-catch` blocks and proper logging for better error handling and debugging (realized this was how I had to do it)

