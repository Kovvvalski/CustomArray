package by.kovalski.customarray.entity;

import java.util.StringJoiner;

public class ArrayStatistics {
  private double averageValue;
  private int sum;
  private int max;
  private int min;

  public ArrayStatistics(double averageValue, int sum, int max, int min) {
    this.averageValue = averageValue;
    this.sum = sum;
    this.max = max;
    this.min = min;
  }

  public double getAverageValue() {
    return averageValue;
  }

  public int getSum() {
    return sum;
  }

  public int getMax() {
    return max;
  }

  public int getMin() {
    return min;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ArrayStatistics.class.getSimpleName() + "[", "]")
            .add("averageValue=" + averageValue)
            .add("sum=" + sum)
            .add("max=" + max)
            .add("min=" + min)
            .toString();
  }
}
