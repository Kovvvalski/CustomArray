package by.kovalski.customarray.service.impl;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.service.CountService;

public class CountServiceImpl implements CountService {
  private static CountServiceImpl INSTANCE;

  private CountServiceImpl() {
  }

  public static CountServiceImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new CountServiceImpl();
    }
    return INSTANCE;
  }

  @Override
  public double countAverageValue(CustomArray array) throws CustomException {
    return (double) countSumOfElements(array) / array.getArray().length;
  }

  @Override
  public int countSumOfElements(CustomArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    int sum = 0;
    for (int i : copy) {
      sum += i;
    }
    return sum;
  }

  @Override
  public int countNumberOfNegativeElements(CustomArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    int sum = 0;
    for (int i : copy) {
      if (i < 0) {
        sum++;
      }
    }
    return sum;
  }

  @Override
  public int countNumberOfPositiveElements(CustomArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    int sum = 0;
    for (int i : copy) {
      if (i > 0) {
        sum++;
      }
    }
    return sum;
  }


}
