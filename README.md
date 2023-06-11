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

    ![student-enroll-course](https://github.com/gideonfu55/student-management-system/assets/94817218/48a1a700-cf15-4084-8ec3-f3631a1b95f7)

- **Grade/Regrade a Student**

    **Grading a student enrolled in a course:**

    ![student-gradeA](https://github.com/gideonfu55/student-management-system/assets/94817218/e3033b60-f0f2-4e89-8e9e-4b8ee79431f8)

    **Regrading a student (with exception handling):**

    ![student-gradeB](https://github.com/gideonfu55/student-management-system/assets/94817218/31f17bd4-14a2-4787-a786-70a52405357c)

    **Grading a student not enrolled in any course:**

    ![student-gradeC](https://github.com/gideonfu55/student-management-system/assets/94817218/a3e7475d-abea-4aac-87f7-9bf699842c37)

- **Show Student Summary**

    ![image](https://github.com/gideonfu55/student-management-system/assets/94817218/089b08ef-8186-4ee9-bb51-04b2cfcba150)

- **Show Passed Courses By Student**

    **If student is not enrolled OR doesn't have any graded/passed courses:**

    ![passed_coursesA](https://github.com/gideonfu55/student-management-system/assets/94817218/2f92ee85-8339-4ccf-90dd-c4da78c4d074)

    **With passed courses (with grades > 3.0):**

    ![passed_coursesB](https://github.com/gideonfu55/student-management-system/assets/94817218/42286c60-3d08-4e04-9494-f2247f02e7ea)

- **Show Courses Summary**

    ![courses-summary](https://github.com/gideonfu55/student-management-system/assets/94817218/57017e3f-96f4-472b-9295-b07a652a4cdc)
