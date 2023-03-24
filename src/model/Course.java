package model;

public class Course {

    private final String courseId;
    private final String name;
    private final int credits;
    private final Module module;
    private double grade;

    public final float PASS_MIN_GRADE = 3.0f;
    public final float MIN_GRADE = 1.0f;
    public final float MAX_GRADE = 6.0f;

    public Course(String courseId, String name, int credits, Module module) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.module = module;
        grade = 0.0;
    }

    public Course(Course source) {
        this.courseId = source.courseId;
        this.name = source.name;
        this.credits = source.credits;
        this.module = source.module;
        grade = 0.0;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public Module getModule() {
        return module;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        if (grade < MIN_GRADE || grade > MAX_GRADE || Double.isNaN(grade)) {
            throw new IllegalArgumentException("Grade has to be a double between 1.0 & 6.0.");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{" +
            " courseId='" + getCourseId() + "'" +
            ", name='" + getName() + "'" +
            ", credits='" + getCredits() + "'" +
            ", module='" + getModule() + "'" +
            ", grade='" + getGrade() + "'" +
            " }";
    }

}
