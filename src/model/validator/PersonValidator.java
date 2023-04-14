package model.validator;

import java.util.Date;

public class PersonValidator {
  
  private static final String regexNameCheck = "^[A-Z\s-]+$";
  private static final String regexEmailCheck = "^(.+)@(\\S+)$";
  private static final String regexIdCheck = "";

  /*
   * nameValidator rejects name input on the following conditions:
   * 1. Name is blank.
   * 2. Name does not have only uppercase letters (no numbers or special characters allowed):
   * 
   */ 
  public Boolean nameValidator(String name) {
    if (name.isBlank() || !name.matches(regexNameCheck)) {
      return true;
    }
    return false;
  }

  /**
   * emailValidator rejects email input on the following condition(s):
   * 1. Email is blank.
   * 2. Email has white spaces (still not included)
   * 3. Email has @ in entry - the domain is auto-injected for final save. (currently based on checking if a @domain is entered instead)
   * 
   */
  public Boolean emailValidator(String email) {
    if (email.isBlank() || email.matches(regexEmailCheck)) {
      return true;
    }
    return false;
  }

  public Boolean birthDateValidator(Date birthDate) {
    if (birthDate == null) {
      return true;
    }
    return false;
  }

}
