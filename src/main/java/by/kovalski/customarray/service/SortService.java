package by.kovalski.customarray.service;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;

public interface SortService {
  void bubbleSort(CustomArray array) throws CustomException;
  void quickSort(CustomArray array) throws CustomException;
  void recursiveQuickSort(CustomArray array,int left,int right) throws CustomException;
}
