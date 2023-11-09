package by.kovalski.customarray.repository.specification;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;

public interface Specification {
  boolean specified (CustomArray array) throws CustomException;
}
