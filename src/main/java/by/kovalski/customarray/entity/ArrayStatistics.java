package by.kovalski.customarray.entity;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.StringJoiner;

public class ArrayStatistics {
  private static final Logger logger = LogManager.getLogger();
  private double averageValue;
  private int sum;
  private int max;
  private int min;

  private static final CountService count = CountServiceImpl.getInstance();
  private static final FindService find = FindServiceImpl.getInstance();

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
