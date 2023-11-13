package by.kovalski.customarray.validator;

public class CustomArrayValidator {
  private static final String ELEMENT_REGEX = "-?\\d+";
  private static CustomArrayValidator instance;


  private CustomArrayValidator() {

  }

  public static CustomArrayValidator getInstance() {
    if (instance == null)
      instance = new CustomArrayValidator();
    return instance;
  }

  public boolean isValidElement(String element) {
    return element.matches(ELEMENT_REGEX);
  }
}
