package by.kovalski.customarray.main;

import by.kovalski.customarray.creator.CustomArrayCreator;
import by.kovalski.customarray.entity.Condition;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.printer.CustomArrayPrinter;
import by.kovalski.customarray.reader.ReaderFromFile;
import by.kovalski.customarray.repository.CustomArrayRepository;
import by.kovalski.customarray.repository.specification.Specification;
import by.kovalski.customarray.repository.specification.impl.*;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.ReplaceService;
import by.kovalski.customarray.service.SortService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import by.kovalski.customarray.service.impl.ReplaceServiceImpl;
import by.kovalski.customarray.service.impl.SortServiceImpl;
import by.kovalski.customarray.validator.CustomArrayValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws CustomException {
    ReaderFromFile reader = ReaderFromFile.getInstance();
    List<String> input = reader.readCustomArraysFromFile("C:/Users/Acer/Desktop/ITA/projects/CustomArray/src/main/resources/input.txt");
    CustomArrayCreator creator = CustomArrayCreator.getInstance();
    List<CustomArray> arrays = creator.createArraysFromListOfString(input);
    CustomArrayPrinter printer = CustomArrayPrinter.getInstance();
    CustomArrayRepository repository = CustomArrayRepository.getInstance(arrays);
    Specification s1 = new AverageValueSpecification(2);
    Specification s2 = new IDSpecification(1,4);
    Specification s3 = new MaxValueSpecification(10);
    Specification s4 = new MinValueSpecification(2);
    Specification s5 = new SumSpecification(8);
    List<List<CustomArray>> spec = new ArrayList<>();
    spec.add(repository.query(s1));
    spec.add(repository.query(s2));
    spec.add(repository.query(s3));
    spec.add(repository.query(s4));
    spec.add(repository.query(s5));
    for(List<CustomArray> query:spec){
      printer.printArrays(query);
      System.out.println();
    }
  }
}
