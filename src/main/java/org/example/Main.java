package org.example;

public class Main {
  public static void main(String[] args) {
    try {
      Game.level = Integer.parseInt(args[0]);
    } catch (Exception e) {
      System.out.println("invalid level");
      System.exit(0);
    }
    Game.getInstance().startGame();
  }
}
