package by.kovalski.customarray.observer.impl;

import by.kovalski.customarray.entity.ArrayStatistics;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.entity.Warehouse;
import by.kovalski.customarray.observer.ArrayStatisticsObserver;
import by.kovalski.customarray.service.CreateStatisticsService;
import by.kovalski.customarray.service.impl.CountServiceImpl;

public class ArrayStatisticsObserverImpl implements ArrayStatisticsObserver {
  private static final CreateStatisticsService service = CreateStatisticsService.getInstance();
  @Override
  public void changeArrayElement(CustomArray array) {
    ArrayStatistics statistics = service.countStatistics(array);
    Warehouse.getInstance().put(array.getId(),statistics);
  }
}
