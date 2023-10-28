package by.kovalski.customarray.service.impl;

import by.kovalski.customarray.entity.Condition;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.ReplaceService;

public class ReplaceServiceImpl implements ReplaceService {
  private static ReplaceServiceImpl INSTANCE;
  @Override
  public void ReplaceElementByCondition(CustomArray array, Condition condition, int ofNumber, int toNumber) throws CustomException {
    if (array == null) {
      throw new CustomException("Null pointer");
    }
    int[] copy = array.getArray();
    if (copy.length == 0) {
      throw new CustomException("Empty array");
    }
    switch (condition) {
      case LESS -> {
        for (int i = 0; i < copy.length; i++)
          if (copy[i] < ofNumber)
            copy[i] = toNumber;
      }
      case MORE -> {
        for (int i = 0; i < copy.length; i++)
          if (copy[i] > ofNumber)
            copy[i] = toNumber;
      }
      case EQUALS -> {
        for (int i = 0; i < copy.length; i++)
          if (copy[i] == ofNumber)
            copy[i] = toNumber;
      }
      case MORE_OR_EQUALS -> {
        for (int i = 0; i < copy.length; i++)
          if (copy[i] >= ofNumber)
            copy[i] = toNumber;
      }
      case LESS_OR_EQUALS -> {
        for (int i = 0; i < copy.length; i++)
          if (copy[i] <= ofNumber)
            copy[i] = toNumber;
      }
    }
    array.setArray(copy);
  }

  private ReplaceServiceImpl() {

  }

  public static ReplaceServiceImpl getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ReplaceServiceImpl();
    }
    return INSTANCE;
  }
}
