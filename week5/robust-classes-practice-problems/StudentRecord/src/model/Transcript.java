package model;

import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.LinkedList;
import java.util.List;

public class Transcript {

    private String name;
    private int year;
    private int id;
    private double gpa;
    private List<Course> currentCourses;
    private List<Course> pastCourses;

    public Transcript(String studentName, int academicYear, int studentID) {
        name = studentName;
        year = academicYear;
        id = studentID;

        gpa = 0;
        currentCourses = new LinkedList<>();
        pastCourses = new LinkedList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public int getAcademicYear() {
        // TODO: complete the implementation of this method
        return year;
    }
    public int getId() {
        // TODO: complete the implementation of this method
        return id;
    }
    public List<Course> getCurrentCourses() {
        // TODO: complete the implementation of this method
        return currentCourses;
    }

    public List<Course> getPastCourses() {
        return pastCourses;
    }

    // EFFECTS: computes cGPA
    //          if the list of past courses is empty, throws NoCoursesTakenException
    public double computeGPA() throws NoCoursesTakenException {
        //          HINTS:
        //          use the following formula to convert into a GPA
        //          GPA (4.0 scale) = (total percentage/20) - 1
        //          **Do you need a helper method?**
        
        if(pastCourses.size() == 0){
            throw new NoCoursesTakenException("No courses taken. Can't compute GPA.");
        }

        gpa = convertToGPA();
        return gpa;
    }

    // EFFECTS: promotes the student represented by the transcript
    //          to the next academic year if GPA is over 2.6 on a 4.0 scale, and return true
    //          else return false with no change to the year field
    //          if GPA is not over 2.6 on a 4.0 scale, throws GPATooLowException
    //          if no courses have been taken, throws NoCoursesTakenException
    public boolean promoteStudent() throws GPATooLowException, NoCoursesTakenException {

        double currentGPA = convertToGPA();

        if(pastCourses.isEmpty()){
            throw new NoCoursesTakenException("This student has not taken any courses");
        }
        else if(currentGPA <= 2.6){
            throw new GPATooLowException("GPA is too low to promote student");
        }
        else{
            year++;
            return true;
        }


    }


    // MODIFIES: this
    // EFFECTS: adds the given course to the list of past courses and returns true,
    //          unless pastCourses contains given course, then does not add and returns false
    public boolean addToPastCourses(Course c) {
        if(pastCourses.contains(c)){
            return false;
        }

        pastCourses.add(c);
        return true;
    }

    // MODIFIES: this
    // EFFECTS: adds a course (c) into the record
    //          if the transcript is missing prerequisites, throws a MissingPrereqException
    //          if the course has no space for more students to register, throws a CourseFullException
    public void addCourse(Course course) throws MissingPrereqException, CourseFullException {
        // TODO: implement this method.
        // You have to realize that there are a number of cases that your code needs to consider. What if the course
        // you wish to add has no prerequisites? What if the course you want to add is already full?
        // Careful consideration of these cases will lead to code that is correct


        List<Course> preReqCourses = course.getPrereq();


        if(course.isCourseFull()){
            throw new CourseFullException("Course is currently full");
        }
        else if(preReqCourses.isEmpty()){
            currentCourses.add(course);
            course.addStudent();
        }
        else{
            for(Course c : preReqCourses){
                if(!pastCourses.contains(c)){
                    throw new MissingPrereqException("Missing prerequisites to take the course");
                }
            }

            currentCourses.add(course);
            course.addStudent();

        }

    }


    private double convertToGPA(){
        double totalGradeSum = 0;

        for(Course c : pastCourses){
            totalGradeSum += c.getGrade();
        }


        double percentage = totalGradeSum / pastCourses.size();

        return ( percentage / 20 ) - 1;
    }

}
