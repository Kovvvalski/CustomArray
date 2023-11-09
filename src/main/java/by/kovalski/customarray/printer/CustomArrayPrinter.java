package by.kovalski.customarray.printer;

import by.kovalski.customarray.entity.CustomArray;

import java.util.List;

public class CustomArrayPrinter {
  private static CustomArrayPrinter INSTANCE;
  public void printArrays(List<CustomArray> arrays){
    for(CustomArray array:arrays)
      System.out.println(array);
  }
  private CustomArrayPrinter(){

  }
  public static CustomArrayPrinter getInstance(){
    if(INSTANCE == null)
      INSTANCE = new CustomArrayPrinter();
    return INSTANCE;
  }
}
