package by.kovalski.customarray.repository.specification.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.impl.FindServiceImpl;

public class MaxValueSpecification implements Specification {
  private int value;
  private static final FindService service = FindServiceImpl.getInstance();

  public MaxValueSpecification(int value) {
    this.value = value;
  }

  @Override
  public boolean specified(CustomArray array) throws CustomException {
    return value == array.getArray()[service.findIndexOfMax(array)];
  }
}
