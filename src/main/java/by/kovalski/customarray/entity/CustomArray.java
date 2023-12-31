package by.kovalski.customarray.entity;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.observer.ArrayStatisticsObserver;
import by.kovalski.customarray.service.CreateStatisticsService;
import by.kovalski.customarray.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray implements Cloneable {
  private static final Logger logger = LogManager.getLogger();
  private int id;
  private int[] array;
  private ArrayStatisticsObserver observer;

  public CustomArray(int[] array) throws CustomException {
    setArray(array);
    this.id = IdGenerator.getID();
    addObserver();
    notifyObserver();
  }

  public int getId() {
    return id;
  }

  public int[] getArray() {
    int[] array = new int[this.array.length];
    for (int i = 0; i < this.array.length; i++) {
      array[i] = this.array[i];
    }
    return array;
  }

  public void setArray(int[] array) throws CustomException {
    if (array == null) {
      logger.error("Input array is null pointer");
      throw new CustomException("Input array is null pointer");
    }
    this.array = Arrays.copyOf(array, array.length);
    notifyObserver();
  }

  public void removeByIndex(int index) {
    if (index >= 0 && index < array.length) {
      int[] copy = new int[array.length - 1];
      for (int i = 0; i < array.length; i++) {
        if (i != index)
          copy[i] = array[i];
      }
      array = copy;
      notifyObserver();
    } else {
      logger.error("Cannot remove element with index +" + index);
    }
    notifyObserver();
  }

  public void replaceByIndex(int index, int newElement) {
    if (index >= 0 && index < array.length) {
      array[index] = newElement;
    } else {
      logger.error("Cannot replace element with index " + index);
    }
    notifyObserver();
  }

  public void add(int element) {
    int[] copy = new int[array.length + 1];
    for (int i = 0; i < array.length; i++)
      copy[i] = array[i];
    copy[copy.length - 1] = element;
    array = copy;
    notifyObserver();
  }

  public void removeObserver() {
    observer = null;
  }

  public void addObserver() {
    observer = o1 -> {
      CreateStatisticsService service = CreateStatisticsService.getInstance();
      try {
        ArrayStatistics statistics = service.countStatistics(o1);
        Warehouse.getInstance().put(o1.getId(), statistics);
      } catch (CustomException e) {
        logger.error("Error during creating statistics", e);
      }

    };
  }


  @Override
  public String toString() {
    return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("array=" + Arrays.toString(array))
            .toString();
  }

  @Override
  public CustomArray clone() {
    int[] copy = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      copy[i] = array[i];
    }
    CustomArray result = null;
    try {
      result = (CustomArray) super.clone();
    } catch (CloneNotSupportedException e) {
      logger.error("Error during cloning", e);
    }
    try {
      result.setArray(copy);
    } catch (CustomException e) {
      logger.error("Error during setting array", e);
    }
    return result;
  }

  private void notifyObserver() {
    if (observer != null) {
      observer.changeArrayElement(this);
    }
  }
}
