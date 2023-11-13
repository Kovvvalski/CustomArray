package by.kovalski.customarray.comparator;

import by.kovalski.customarray.entity.CustomArray;

import java.util.Comparator;

public class NumberOfElementsComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return o1.getArray().length - o2.getArray().length;
  }
}
