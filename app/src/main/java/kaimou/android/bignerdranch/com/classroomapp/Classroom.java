package kaimou.android.bignerdranch.com.classroomapp;

import java.util.ArrayList;

/**
 * Created by Kai on 8/15/2015.
 */
public class Classroom {
    //classroom should be a list of students.
    ArrayList<Student> wholeClass;

    public Classroom(){
        wholeClass = new ArrayList<Student>();
    }

    public void addStudent(Student s){
        wholeClass.add(s);
    }


}
