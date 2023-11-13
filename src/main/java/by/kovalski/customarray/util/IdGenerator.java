package by.kovalski.customarray.util;

public class IdGenerator {
  private static int current;
  public static int getID(){
    return ++current;
  }
}
