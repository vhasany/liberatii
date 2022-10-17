package org.example;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Equation {
  private Random randomGenerator = new Random();
  private String operators = "*/-+";
  Calculation calculation = new Calculation();
  GameInfo gameInfo = new GameInfo();

  public Supplier<Integer> randomNumber = () -> randomGenerator.nextInt(99) + 1;
  public Function<String, Character> randomOperator =
      s -> s.charAt(randomGenerator.nextInt(s.length()));
  public Function<Integer, String> generateEquation =
      level -> {
        StringBuilder equation = new StringBuilder();
        equation.append(randomNumber.get());
        for (int i = 1; i < level; i++) {
          equation.append(randomOperator.apply(operators));
          equation.append(randomNumber.get());
        }
        return equation.toString();
      };

  public GameInfo createEquation(int level) {
    final String equation = generateEquation.apply(level);
    final Double answer = calculation.eval.apply(equation);
    if (calculation.isPositiveInteger(answer)) {
      gameInfo.setCorrectAnswer(answer.intValue());
      gameInfo.setEquation(equation);
      return gameInfo;
    }
        return createEquation(level);
  }
}
