package by.kovalski.customarray.comparator;

import by.kovalski.customarray.entity.CustomArray;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return o1.getId()-o2.getId();
  }
}
