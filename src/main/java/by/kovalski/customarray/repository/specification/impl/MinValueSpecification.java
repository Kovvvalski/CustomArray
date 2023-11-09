package by.kovalski.customarray.repository.specification.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;

public class MinValueSpecification implements Specification {
  private int value;
  private static final FindService service = FindServiceImpl.getInstance();


  public MinValueSpecification(int value) {
    this.value = value;
  }

  @Override
  public boolean specified(CustomArray array) throws CustomException {
    return value == array.getArray()[service.findIndexOfMin(array)];
  }
}
