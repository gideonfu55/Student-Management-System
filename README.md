# Student-Management-System

Simple Student Management System project to manage student data, course enrollment and grading

Reworked on the Java Assessment which I had during my bootcamp to familiarize with concepts of OOP and make further improvements. Further things to work on:

1. Update regex to validate id and email inputs for spaces during student registration.
2. Include failed courses option (branched) within selection in Option 7.
3. Option to add new courses to module. Option to add instructors with relationship to course.
4. Expanding this into a Full-Stack project with UI and security features.

**Specific changes:**

1. Refactored into 3 layer design.
2. Added specific input validation requirements for Student particulars for adding Student object.
3. Include Runtime Error(s) handling for inputs on menu entries + inputs for Student particulars and Grades.
4. Added feature to check for ungraded courses for student upon retrieving an enrolled student.
5. Fixed a previous Reference Trap problem for enrolled courses in Students, where changing one grade changes for all.

**Features:**

- **Register and Find Student (with validations)**

    ![student-register](https://github.com/gideonfu55/student-management-system/assets/94817218/a92d5725-a32f-428e-9a3a-d3d109c39bfc)

- **Enroll Student to Course**

    ![student-enroll-course](https://github.com/gideonfu55/student-management-system/assets/94817218/d69cdaa2-a688-4c44-a5bf-019c78a95497)

- **Grade/Regrade a Student**

    ![student-gradeA](https://github.com/gideonfu55/student-management-system/assets/94817218/e3033b60-f0f2-4e89-8e9e-4b8ee79431f8)
    ![student-gradeB](https://github.com/gideonfu55/student-management-system/assets/94817218/31f17bd4-14a2-4787-a786-70a52405357c)

- **Show Passed Courses By Student**
