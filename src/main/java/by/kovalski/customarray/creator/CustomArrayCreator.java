package by.kovalski.customarray.creator;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayCreator {
  private static final Logger logger = LogManager.getLogger();
  private static final String SEPARATOR_REGEX = "[,\\s]+";
  private static final int DEFAULT_VALUE = 0;
  private static CustomArrayCreator instance;

  private CustomArrayCreator() {

  }

  public static CustomArrayCreator getInstance() {
    if (instance == null) {
      instance = new CustomArrayCreator();
    }
    return instance;
  }

  public List<CustomArray> createArraysFromListOfString(List<String> strings) {
    List<CustomArray> out = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] array = null;
    CustomArrayValidator validator = CustomArrayValidator.getInstance();
    for (String string : strings) {
      String[] elements = string.split(SEPARATOR_REGEX);
      for (int i = 0; i < elements.length; i++) {
        if (validator.isValidElement(elements[i])) {
          try {
            temp.add(Integer.parseInt(elements[i]));
          } catch (NumberFormatException e) {
            logger.error(elements[i] + " is out of int range", e);
            temp.add(DEFAULT_VALUE);
          }
        } else {
          logger.error("Cannot parse int from " + elements[i]);
        }
      }
      if (!temp.isEmpty()) {
        array = new int[temp.size()];
        for (int i = 0; i < array.length; i++) {
          array[i] = temp.get(i);
        }
        try {
          out.add(new CustomArray(array));
        } catch (CustomException e) {
          logger.error("Error during creating custom array", e);
        }
      }
      temp.clear();
    }
    logger.info("Successfully created list of custom arrays");
    return out;
  }


}
