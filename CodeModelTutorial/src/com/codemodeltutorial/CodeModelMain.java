/**
 * 
 */
package com.codemodeltutorial;

import java.io.File;
import java.io.IOException;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;

/**
 * @author Irudaya Raj K L
 * Main class for generating a Student class with studentName as private variable and creating getter and setter methods.
 */
public class CodeModelMain {

	/**
	 * @param args
	 * @throws JClassAlreadyExistsException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JClassAlreadyExistsException, IOException {
	
		// Instantiate a new class
		JCodeModel codeModel = new JCodeModel();
		
		// Create a new package 
		JPackage jPackage = codeModel._package("com.codemodel.gettingstarted");
		
		// Create a new class
		JDefinedClass jDefinedClass = jPackage._class("Student");
		
		// Add Javadoc
		jDefinedClass.javadoc().add("Template to contain student details");
		
		// Add a default constructor
		jDefinedClass.constructor(JMod.PUBLIC).javadoc().add("Creates a new " + jDefinedClass.name() +".");
		
		// Adding a private variable
		JFieldVar studentName = jDefinedClass.field(JMod.PRIVATE, String.class, "studentName");
		
		// Adding setStudentName setter method
		JMethod studentNameSetter = jDefinedClass.method(JMod.PUBLIC, codeModel.VOID, "setStudentName");
		studentNameSetter.param(studentName.type(), studentName.name());
		studentNameSetter.body().assign(JExpr._this().ref(studentName.name()), JExpr.ref(studentName.name()));
		studentNameSetter.javadoc().add("Set the student name.");
		studentNameSetter.javadoc().addParam(studentName.name()).add("the new student name.");
		
		// Adding getStudentName setter method
		JMethod studentNameGetter = jDefinedClass.method(JMod.PUBLIC, studentName.type(), "getStudentName");
		studentNameGetter.body()._return(studentName);
		studentNameGetter.javadoc().add("Returns the student name.");
		studentNameGetter.javadoc().addReturn().add(studentName.name());
		
		
		// Generate the code
		codeModel.build(new File("src/"));
	}

}
