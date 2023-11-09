package by.kovalski.customarray.repository;

import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomArrayRepository {
  private static CustomArrayRepository INSTANCE;
  private List<CustomArray> customArrays;

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
    return INSTANCE.customArrays.add((CustomArray) array.clone());
  }

  public CustomArray remove(int index) {
    return INSTANCE.customArrays.remove(index);
  }

  public int indexOf(CustomArray o) {
    return INSTANCE.customArrays.indexOf(o);
  }

  public List<CustomArray> query(Specification specification){
    List<CustomArray> out = new ArrayList<>();
    for(CustomArray array: INSTANCE.customArrays){
      if(specification.specified(array))
        out.add((CustomArray)array.clone());
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
