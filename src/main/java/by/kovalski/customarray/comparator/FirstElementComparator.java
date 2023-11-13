package by.kovalski.customarray.comparator;

import by.kovalski.customarray.entity.CustomArray;

import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return o1.getArray()[0] - o2.getArray()[0];
  }
}
