package org.example;

import java.util.Scanner;

public class Game {
  public static int level;
  private static Game instance = null;
  private final Equation equation;

  private Game() {
    equation = new Equation();
  }

  public static Game getInstance() {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  public void startGame() {
    System.out.println("The game is ready to challenge yourself! Let's go!");
    System.out.println("Level of equations is: " + level);
    GameInfo gameInfo = equation.createEquation(level);
    System.out.print(gameInfo.getEquation() + " = ");

    try (Scanner scanner = new Scanner(System.in)) {
      while (scanner.hasNext()) {
        try {
          Integer answer = Integer.parseInt(scanner.next());
          if (gameInfo.getCorrectAnswer().equals(answer)) {
            System.out.println("Bingo! You made it!");
            gameInfo = equation.createEquation(level);
            System.out.print(gameInfo.getEquation() + " = ");
          } else {
            System.out.println("The answer was wrong! Try again.");
          }
        } catch (Exception e) {
          System.out.println("Invalid number format, Try again!");
        }
      }
    }
  }
}
