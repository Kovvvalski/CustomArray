package by.kovalski.customarray.repository.specification.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.impl.CountServiceImpl;

public class AverageValueSpecification implements Specification {
  private int value;
  private static final CountService service = CountServiceImpl.getInstance();

  public AverageValueSpecification(int value) {
    this.value = value;
  }

  @Override
  public boolean specified(CustomArray array) throws CustomException {
    return service.countAverageValue(array) == value;
  }
}
