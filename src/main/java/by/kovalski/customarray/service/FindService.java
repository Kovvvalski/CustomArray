package by.kovalski.customarray.service;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;

public interface FindService {
  int findIndexOfMax(CustomArray array)throws CustomException;
  int findIndexOfMin(CustomArray array)throws CustomException;
}
