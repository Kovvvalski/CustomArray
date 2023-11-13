package by.kovalski.customarray.service;

import by.kovalski.customarray.entity.ArrayStatistics;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;

public class CreateStatisticsService {
  private static CreateStatisticsService instance;
  private final static CountService count = CountServiceImpl.getInstance();
  private final static FindService find = FindServiceImpl.getInstance();

  private CreateStatisticsService() {

  }

  public static CreateStatisticsService getInstance() {
    if (instance == null)
      instance = new CreateStatisticsService();
    return instance;
  }

  public ArrayStatistics countStatistics(CustomArray array) {
    ArrayStatistics statistics = null;
    try {
      int sum = count.countSumOfElements(array);
      double averageValue = (double) sum / array.getArray().length;
      int max = array.getArray()[find.findIndexOfMax(array)];
      int min = array.getArray()[find.findIndexOfMin(array)];
      statistics = new ArrayStatistics(averageValue, sum, max, min);
    } catch (CustomException e) {
      e.printStackTrace();
    }
    return statistics;
  }

}
