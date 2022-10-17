import org.example.Equation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class EquationTest {
  private Equation equation;

  @BeforeEach
  void setUp() {
    equation = new Equation();
  }

  @Test
  @DisplayName("The generated number must be between 1 and 100")
  void testRandomNumberGenerator() {
    int generatedNumber = equation.randomNumber.get();
    Assertions.assertTrue(
        generatedNumber >= 1 && generatedNumber <= 100,
        "The generated number isn't between 1 and 100");
  }

  @Test
  @DisplayName("The generated operator must be one of +-*/")
  void testRandomOperatorGenerator() {
    Character generatedOperator = equation.randomOperator.apply("+-*/");
    Assertions.assertTrue(
        "+-*/".contains(generatedOperator.toString()), "Invalid operator generated!");
  }

  @Test
  @DisplayName("The generated numbers of the equation must be equal to the Level")
  void testEquationLength() {
    Random random = new Random();
    int level = random.nextInt(4) + 1;
    ArrayList<String> operands = new ArrayList<>();
    String generatedEquation = equation.generateEquation.apply(level);
    StringTokenizer tokenizer = new StringTokenizer(generatedEquation, "+-*/", true);
    while (tokenizer.hasMoreTokens()) {
      String token = tokenizer.nextToken();
      if (!"*/+-".contains(token)) {
        operands.add(token);
      }
    }
    Assertions.assertEquals(
        level, operands.size(), "The length of the generated equation is not equal to the Level");
  }
}
