package by.kovalski.customarray.comparator;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.CustomArrayRepository;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class MaxComparator implements Comparator<CustomArray> {
  private final static Logger logger = LogManager.getLogger();
  @Override
  public int compare(CustomArray o1,CustomArray o2){
    FindService service = FindServiceImpl.getInstance();
    try {
      return o1.getArray()[service.findIndexOfMax(o1)] - o2.getArray()[service.findIndexOfMax(o2)];
    } catch (CustomException e) {
      logger.info("Cannot find index of max element of one of arrays",e);
    }
    if(o1.getArray().length == o2.getArray().length)
      return 0;
    if(o1.getArray().length == 0)
      return -1;
    return 1;
  }
}
