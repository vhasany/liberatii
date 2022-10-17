package org.example;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Calculation {
  public boolean isPositiveInteger(double aDouble) {
    long longValue = (long) aDouble;
    if (aDouble >= 0 && longValue == aDouble) {
      return true;
    }
    return false;
  }

  public Function<String, Double> eval =
      equation -> {
        var tokenizer = new StringTokenizer(equation, "+-*/", true);
        var splitEquation = tokenizerToList(tokenizer);
        return calc(splitEquation);
      };

  public double calc(LinkedList<String> tokens) {
    if (tokens.size() == 1) {
      return Double.parseDouble(tokens.getFirst());
    }
    calcMulDiv(tokens);
    calcSubAdd(tokens);
    return Double.parseDouble(tokens.getFirst());
  }

  public void calcMulDiv(LinkedList<String> equationList) {
    for (int index = 0; index < equationList.size(); index++) {
      String token = equationList.get(index);
      if ("*/".contains(token)) {
        String result;
        Double leftValue = Double.parseDouble(equationList.get((index - 1)));
        Double rightValue = Double.parseDouble(equationList.get((index + 1)));
        if (token.equals("*")) {
          result = String.valueOf(leftValue * rightValue);
        } else {
          result = String.valueOf(leftValue / rightValue);
        }
        equationList.remove(index - 1);
        equationList.add(index - 1, result);
        equationList.remove(index + 1);
        equationList.remove(index);
        calcMulDiv(equationList);
      }
    }
  }

  public void calcSubAdd(LinkedList<String> equationList) {
    for (int index = 0; index < equationList.size(); index++) {
      String token = equationList.get(index);
      if ("+-".contains(token)) {
        String result;
        Double leftValue = Double.parseDouble(equationList.get((index - 1)));
        Double rightValue = Double.parseDouble(equationList.get((index + 1)));
        if (token.equals("+")) {
          result = String.valueOf(leftValue + rightValue);
        } else {
          result = String.valueOf(leftValue - rightValue);
        }
        equationList.remove(index - 1);
        equationList.add(index - 1, result);
        equationList.remove(index + 1);
        equationList.remove(index);
        calcSubAdd(equationList);
      }
    }
  }

  public LinkedList<String> tokenizerToList(StringTokenizer tokenizer) {
    var stringList = new LinkedList<String>();
    while (tokenizer.hasMoreTokens()) {
      stringList.add(tokenizer.nextToken());
    }
    return stringList;
  }
}
