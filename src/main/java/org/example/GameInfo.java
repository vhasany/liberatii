package org.example;

public class GameInfo {
  private  Integer correctAnswer;
  private  String equation;

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }
    public String getEquation() {
        return equation;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
