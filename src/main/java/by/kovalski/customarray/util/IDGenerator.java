package by.kovalski.customarray.util;

public class IDGenerator {
  private static int current;
  public static int getID(){
    return ++current;
  }
}
