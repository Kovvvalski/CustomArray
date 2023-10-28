package by.kovalski.customarray.entity;

import by.kovalski.customarray.exception.CustomException;

import java.util.Arrays;

public class CustomArray {
  private String id;
  private int[] array;

  public CustomArray(String id,int[]array)throws CustomException{
    setArray(array);
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int[] getArray() {
    int [] array = new int[this.array.length];
    for(int i = 0;i<this.array.length;i++){
      array[i] = this.array[i];
    }
    return array;
  }

  public void setArray(int[] array) throws CustomException {
    if(array == null){
      throw new CustomException("Null pointer");
    }
    int [] copy = new int[array.length];
    for(int i = 0;i<array.length;i++){
      copy[i] = array[i];
    }
    this.array = copy;
  }

  @Override
  public String toString() {
    return "CustomArray{" +
            "id='" + id + '\'' +
            ", array=" + Arrays.toString(array) +
            '}';
  }
}
