package validator;

public class CourseValidator {
  
  private static final String regexGradeCheck = "[0-9]+";

  public Boolean gradeValidator(Double grade) {
    String gradeString = Double.toString(grade);
    if (!gradeString.matches(regexGradeCheck)) {
      return true;
    }
    return false;
  }

}
