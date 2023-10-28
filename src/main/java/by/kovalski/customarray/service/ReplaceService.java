package by.kovalski.customarray.service;

import by.kovalski.customarray.entity.Condition;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.impl.ReplaceServiceImpl;

public interface ReplaceService {
  void ReplaceElementByCondition(CustomArray array, Condition condition, int ofNumber,int toNumber)throws CustomException;
}
