package by.kovalski.customarray.main;

import by.kovalski.customarray.entity.Condition;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.ReplaceService;
import by.kovalski.customarray.service.SortService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import by.kovalski.customarray.service.impl.ReplaceServiceImpl;
import by.kovalski.customarray.service.impl.SortServiceImpl;

public class Main {

  public static void main(String[] args) throws CustomException {
    CustomArray a = new CustomArray("New", new int[]{-123123213,435345435,1, 2, 3, 5,5,5,5,5,5,4,-1,-2,0,-7,-7,-8,-9,-6,-5});
    System.out.println(a);
    SortService service = SortServiceImpl.getInstance();
    service.recursiveQuickSort(a,0,a.getArray().length-1);
    System.out.println(a);
  }
}
