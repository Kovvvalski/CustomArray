package by.kovalski.customarray.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
  private static Warehouse instance;
  private Map<Integer, ArrayStatistics> map = new HashMap<>();

  private Warehouse() {

  }

  public static Warehouse getInstance() {
    if (instance == null)
      instance = new Warehouse();
    return instance;
  }

  public ArrayStatistics put(Integer key, ArrayStatistics value) {
    return map.put(key, value);
  }

  public ArrayStatistics remove(Integer key) {
    return map.remove(key);
  }

  public ArrayStatistics replace(Integer key, ArrayStatistics value) {
    return map.replace(key, value);
  }

  public Map<Integer, ArrayStatistics> getMap(){
    return new HashMap<>(map);
  }

}
