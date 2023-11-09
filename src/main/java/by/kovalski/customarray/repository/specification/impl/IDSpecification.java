package by.kovalski.customarray.repository.specification.impl;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.repository.specification.Specification;

public class IDSpecification implements Specification {
  private final int minId;
  private final int maxId;

  public IDSpecification(int minId, int maxId) {
    this.minId = minId;
    this.maxId = maxId;
  }

  @Override
  public boolean specified(CustomArray array) {
    int current = array.getId();
    return current>=minId && current <= maxId;
  }
}
