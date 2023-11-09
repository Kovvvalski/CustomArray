package by.kovalski.customarray.entity;

import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.util.IDGenerator;

import java.security.interfaces.EdECKey;
import java.util.Arrays;

public class CustomArray implements Cloneable{
  private int id;
  private int[] array;

  public CustomArray(int[]array)throws CustomException{
    setArray(array);
    this.id = IDGenerator.getID();
  }

  public int getId() {
    return id;
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
  public Object clone()
  {
    int[] copy = new int[array.length];
    for(int i = 0;i<array.length;i++){
      copy[i] = array[i];
    }
    Object result = null;
    try {
      result = super.clone();
    } catch (Exception e){
      e.printStackTrace();
    }
    try {
      ((CustomArray)result).setArray(copy);
    } catch (Exception e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public String toString() {
    return "CustomArray{" +
            "id='" + id + '\'' +
            ", array=" + Arrays.toString(array) +
            '}';
  }
}
