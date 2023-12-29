package by.kovalski.customarray.service;

import by.kovalski.customarray.entity.ArrayStatistics;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateStatisticsService {
  private static final Logger logger = LogManager.getLogger();
  private final static CountService count = CountServiceImpl.getInstance();
  private final static FindService find = FindServiceImpl.getInstance();
  private static CreateStatisticsService instance;

  private CreateStatisticsService() {

  }

  public static CreateStatisticsService getInstance() {
    if (instance == null)
      instance = new CreateStatisticsService();
    return instance;
  }

  public ArrayStatistics countStatistics(CustomArray array) throws CustomException{
    ArrayStatistics statistics = null;

    int sum = count.countSumOfElements(array);
    double averageValue = (double) sum / array.getArray().length;
    int max = array.getArray()[find.findIndexOfMax(array)];
    int min = array.getArray()[find.findIndexOfMin(array)];
    statistics = new ArrayStatistics(averageValue, sum, max, min);
    return statistics;
  }

}
