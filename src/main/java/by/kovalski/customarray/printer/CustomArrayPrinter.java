package by.kovalski.customarray.printer;

import by.kovalski.customarray.entity.CustomArray;

import java.util.List;

public class CustomArrayPrinter {
  private static CustomArrayPrinter instance;

  private CustomArrayPrinter(){

  }
  public static CustomArrayPrinter getInstance(){
    if(instance == null)
      instance = new CustomArrayPrinter();
    return instance;
  }

  public void printArrays(List<CustomArray> arrays){
    for(CustomArray array:arrays)
      System.out.println(array);
  }

}
