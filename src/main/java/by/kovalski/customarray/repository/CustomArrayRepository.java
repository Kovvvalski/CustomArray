package by.kovalski.customarray.repository;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepository {
  private static CustomArrayRepository instance;
  private List<CustomArray> customArrays;
  private static final Logger logger = LogManager.getLogger();

  private CustomArrayRepository(List<CustomArray> customArrays) {
    this.customArrays = new ArrayList<>();
    for (CustomArray array : customArrays) {
      this.customArrays.add(array);
    }
  }

  public static CustomArrayRepository getInstance(List<CustomArray> arrays) {
    if (instance == null)
      instance = new CustomArrayRepository(arrays);
    return instance;
  }

  public int size() {
    return customArrays.size();
  }

  public CustomArray get(int index) {
    return (CustomArray) customArrays.get(index);
  }

  public boolean add(CustomArray array) {
    logger.info("Object with id " + array.getId() + " added to the repository");
    return customArrays.add(array);
  }

  public CustomArray remove(int index) {
    logger.info("Trying to remove object from repository with index " + index);
    return customArrays.remove(index);
  }

  public int indexOf(CustomArray o) {
    return customArrays.indexOf(o);
  }

  public List<CustomArray> query(Specification specification) {
    List<CustomArray> out = new ArrayList<>();
    for (CustomArray array : customArrays) {
      try {
        if (specification.specified(array))
          out.add(array.clone());
      } catch (CustomException e) {
        logger.error("Error during checking specification of object with id " + array.getId(), e);
      }

    }
    return out;
  }

  public List<CustomArray> getCustomArrays() {
    List<CustomArray> copy = new ArrayList<>();
    copy.addAll(customArrays);
    return copy;
  }

  public void sort(Comparator<CustomArray> c) {
    customArrays.sort(c);
  }

}
