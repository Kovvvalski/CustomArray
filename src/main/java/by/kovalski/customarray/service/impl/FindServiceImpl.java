package by.kovalski.customarray.service.impl;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.service.FindService;

public class FindServiceImpl implements FindService {
  private static FindServiceImpl INSTANCE;

  @Override
  public int findIndexOfMax(CustomArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    int indexOfMax = 0;
    for (int i = 0; i < copy.length; i++) {
      if (copy[i] > copy[indexOfMax]) {
        indexOfMax = i;
      }
    }
    return indexOfMax;
  }

  @Override
  public int findIndexOfMin(CustomArray array) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    int indexOfMin = 0;
    for (int i = 0; i < copy.length; i++) {
      if (copy[i] < copy[indexOfMin]) {
        indexOfMin = i;
      }
    }
    return indexOfMin;
  }

  private FindServiceImpl() {
  }

  public static FindServiceImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new FindServiceImpl();
    }
    return INSTANCE;
  }
}
