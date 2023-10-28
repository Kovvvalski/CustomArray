package by.kovalski.customarray.service;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;

public interface CountService {
  double countAverageValue(CustomArray array) throws CustomException;
  int countSumOfElements(CustomArray array) throws CustomException;
  int countNumberOfNegativeElements(CustomArray array) throws CustomException;
  int countNumberOfPositiveElements(CustomArray array) throws CustomException;
}
