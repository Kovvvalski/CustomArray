package by.kovalski.customarray.main;

import by.kovalski.customarray.creator.CustomArrayCreator;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.reader.ReaderFromFile;

import java.util.List;

public class Main {
  public static void main(String[] args) throws CustomException {
    ReaderFromFile reader = ReaderFromFile.getInstance();
    List<String> input = reader.readCustomArraysFromFile("C:/Users/Acer/Desktop/ITA/projects/CustomArray/src/main/resources/input.txt");
    CustomArrayCreator creator = CustomArrayCreator.getInstance();
    List<CustomArray> arrays = creator.createArraysFromListOfString(input);
//    CustomArrayPrinter printer = CustomArrayPrinter.getInstance();
//    CustomArrayRepository repository = CustomArrayRepository.getInstance(arrays);
//
//    for (CustomArray a : repository.getCustomArrays()) {
//      System.out.println(a);
//    }
//    Warehouse w = Warehouse.getInstance();
//    Map<Integer, ArrayStatistics> m = w.getMap();
//    for (CustomArray a : repository.getCustomArrays()) {
//      System.out.println(m.get(a.getId()));
//    }
//    repository.get(0).add(3);
//    System.out.println();
//    Map<Integer, ArrayStatistics> m1 = w.getMap();
//    for (CustomArray a : repository.getCustomArrays()) {
//      System.out.println(m1.get(a.getId()));
//    }

    arrays = arrays.stream().sorted((o1,o2) -> o2.getId()-o1.getId()).toList();
    arrays.stream().forEach(o -> System.out.println(o));


  }
}
