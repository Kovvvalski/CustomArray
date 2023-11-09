package by.kovalski.customarray.validator;

public class CustomArrayValidator {
  private static CustomArrayValidator INSTANCE;
  private static final String ELEMENT_REGEX = "-?\\d+";

  public boolean isValidElement(String element) {
    return element.matches(ELEMENT_REGEX);
  }

  private CustomArrayValidator() {

  }

  public static CustomArrayValidator getInstance() {
    if (INSTANCE == null)
      INSTANCE = new CustomArrayValidator();
    return INSTANCE;
  }

}
