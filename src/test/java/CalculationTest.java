import org.example.Calculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {
  private Calculation calculation;

  @BeforeEach
  void setUp() {
    calculation = new Calculation();
  }

  @Test
  @DisplayName("Positive integer condition")
  void testIsPositiveInteger() {
    Assertions.assertTrue(calculation.isPositiveInteger(15), "error positive integer condition");
    Assertions.assertFalse(calculation.isPositiveInteger(-24), "error positive integer condition");
    Assertions.assertFalse(
        calculation.isPositiveInteger(0.1546), "error positive integer condition");
  }

  @Test
  @DisplayName("Evaluate string expression")
  void testVerifyResult() {
    Assertions.assertTrue(
        calculation.eval.apply("45+90*3/2").intValue() == 180, "Invalid evaluate");
  }
}
