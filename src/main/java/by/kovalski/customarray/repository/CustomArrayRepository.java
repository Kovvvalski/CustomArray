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
  private static CustomArrayRepository INSTANCE;
  private List<CustomArray> customArrays;
  private static Logger logger = LogManager.getLogger();

  public void sort(Comparator<? super CustomArray> c) {
    customArrays.sort(c);
  }

  public int size() {
    return INSTANCE.customArrays.size();
  }

  public CustomArray get(int index){
    return (CustomArray) INSTANCE.customArrays.get(index).clone();
  }

  public boolean add(CustomArray array) {
    logger.info("Object with id "+array.getId()+" added to the repository");
    return INSTANCE.customArrays.add((CustomArray) array.clone());
  }

  public CustomArray remove(int index) {
    logger.info("Trying to remove object from repository with index "+index);
    return INSTANCE.customArrays.remove(index);
  }

  public int indexOf(CustomArray o) {
    return INSTANCE.customArrays.indexOf(o);
  }

  public List<CustomArray> query(Specification specification){
    List<CustomArray> out = new ArrayList<>();
    for(CustomArray array: INSTANCE.customArrays){
      try {
        if(specification.specified(array))
          out.add((CustomArray)array.clone());
      }catch (CustomException e){
        logger.error("Error during checking specification of onject with id "+ array.getId(),e);
      }

    }
    return out;
  }

  private CustomArrayRepository(List<CustomArray> customArrays) {
   this.customArrays = new ArrayList<>();
    for(CustomArray array :customArrays){
      this.customArrays.add((CustomArray) array.clone());
    }
  }

  public static CustomArrayRepository getInstance(List<CustomArray> arrays) {
    if (INSTANCE == null)
      INSTANCE = new CustomArrayRepository(arrays);
    return INSTANCE;
  }
}
