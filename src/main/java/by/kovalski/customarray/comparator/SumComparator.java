package by.kovalski.customarray.comparator;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class SumComparator implements Comparator<CustomArray> {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    CountService service = CountServiceImpl.getInstance();
    try {
      return service.countSumOfElements(o1) - service.countSumOfElements(o2);
    } catch (CustomException e) {
      logger.error("Cannot count sum of one of the arrays", e);
    }
    if (o1.getArray().length == o2.getArray().length) {
      return 0;
    }
    return o1.getArray().length == 0 ? -1 : 1;
  }
}
