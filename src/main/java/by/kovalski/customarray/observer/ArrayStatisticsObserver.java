package by.kovalski.customarray.observer;

import by.kovalski.customarray.entity.CustomArray;

@FunctionalInterface
public interface ArrayStatisticsObserver {
  void changeArrayElement(CustomArray array);
}
