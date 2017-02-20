
package com.codemodel.gettingstarted;



/**
 * Template to contain student details
 * 
 */
public class Student {

    private String studentName;

    /**
     * Creates a new Student.
     * 
     */
    public Student() {
    }

    /**
     * Set the student name.
     * 
     * @param studentName
     *     the new student name.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Returns the student name.
     * 
     * @return
     *     studentName
     */
    public String getStudentName() {
        return studentName;
    }

}
