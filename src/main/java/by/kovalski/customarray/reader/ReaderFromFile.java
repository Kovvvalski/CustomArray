package by.kovalski.customarray.reader;

import by.kovalski.customarray.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class ReaderFromFile {
  private static ReaderFromFile INSTANCE;
  private static final Charset CHARSET = StandardCharsets.UTF_8;
  private static final Logger logger = LogManager.getLogger();

  public List<String> readCustomArraysFromFile(String path) throws CustomException{
    if(path == null){
      logger.error("Null pointer of path string");
      throw new CustomException("Null pointer of path String");
    }
    Path pathToFile = Paths.get(path);
    List<String> lines = null;
    try{
      lines = Files.readAllLines(pathToFile,CHARSET);
    }catch (IOException e){
      logger.error("Error opening the file "+path,e);
      throw new CustomException("Error opening the file "+path,e);
    }
    logger.info("Succesfull input from file");
    return lines;
  }

  private ReaderFromFile(){

  }

  public static ReaderFromFile getInstance(){
    if(INSTANCE == null){
      INSTANCE = new ReaderFromFile();
    }
    return INSTANCE;
  }

}
