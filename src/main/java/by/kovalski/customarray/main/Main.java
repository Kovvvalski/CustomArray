package by.kovalski.customarray.main;

import by.kovalski.customarray.comparator.*;
import by.kovalski.customarray.creator.CustomArrayCreator;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.printer.CustomArrayPrinter;
import by.kovalski.customarray.reader.ReaderFromFile;
import by.kovalski.customarray.repository.CustomArrayRepository;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.repository.specification.impl.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws CustomException {
    ReaderFromFile reader = ReaderFromFile.getInstance();
    List<String> input = reader.readCustomArraysFromFile("C:/Users/Acer/Desktop/ITA/projects/CustomArray/src/main/resources/input.txt");
    CustomArrayCreator creator = CustomArrayCreator.getInstance();
    List<CustomArray> arrays = creator.createArraysFromListOfString(input);
    CustomArrayPrinter printer = CustomArrayPrinter.getInstance();
    CustomArrayRepository repository = CustomArrayRepository.getInstance(arrays);

    for (CustomArray a : repository.getCustomArrays()) {
      System.out.println(a);
    }
    System.out.println();
    Comparator<CustomArray> c = new NumberOfElementsComparator();
    Comparator<CustomArray> comparator = new Comparator<CustomArray>() {
      @Override
      public int compare(CustomArray o1, CustomArray o2) {
        return 0;
      }
    };
    System.out.println(comparator);

    repository.sort(comparator);
    for (CustomArray a : repository.getCustomArrays()) {
      System.out.println(a);
    }
  }
}
