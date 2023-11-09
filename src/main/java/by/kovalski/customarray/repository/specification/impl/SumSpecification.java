package by.kovalski.customarray.repository.specification.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.impl.CountServiceImpl;

public class SumSpecification implements Specification {
  private int sum;
  private static final CountService service = CountServiceImpl.getInstance();

  public SumSpecification(int sum) {
    this.sum = sum;
  }

  @Override
  public boolean specified(CustomArray array) throws CustomException {
      return sum == service.countSumOfElements(array);
  }
}
