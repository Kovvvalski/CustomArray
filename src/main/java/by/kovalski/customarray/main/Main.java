package by.kovalski.customarray.main;

import by.kovalski.customarray.creator.CustomArrayCreator;
import by.kovalski.customarray.entity.Condition;
import by.kovalski.customarray.exception.CustomException;
import by.kovalski.customarray.entity.CustomArray;
import by.kovalski.customarray.reader.ReaderFromFile;
import by.kovalski.customarray.repository.CustomArrayRepository;
import by.kovalski.customarray.service.CountService;
import by.kovalski.customarray.service.FindService;
import by.kovalski.customarray.service.ReplaceService;
import by.kovalski.customarray.service.SortService;
import by.kovalski.customarray.service.impl.CountServiceImpl;
import by.kovalski.customarray.service.impl.FindServiceImpl;
import by.kovalski.customarray.service.impl.ReplaceServiceImpl;
import by.kovalski.customarray.service.impl.SortServiceImpl;
import by.kovalski.customarray.validator.CustomArrayValidator;

import java.util.List;

public class Main {

  public static void main(String[] args) throws CustomException {
    ReaderFromFile reader = ReaderFromFile.getInstance();
    List<String> input = reader.readCustomArraysFromFile("C:/Users/Acer/Desktop/ITA/projects/CustomArray/src/main/resources/input.txt");
    CustomArrayCreator creator = CustomArrayCreator.getInstance();
    List<CustomArray> arrays = creator.createArraysFromListOfString(input);
    for(CustomArray array:arrays)
      System.out.println(array);
    CustomArrayRepository r = CustomArrayRepository.getInstance(arrays);
    System.out.println(r.get(1).getArray()[1]);

  }
}
