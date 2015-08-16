package kaimou.android.bignerdranch.com.classroomapp;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Kai on 8/15/2015.
 */
public class Classroom {
    //classroom should be a list of students.
    ArrayList<Student> wholeClass;
    String name;

    public Classroom(String className){
        wholeClass = new ArrayList<Student>();
        name = className;
    }

    public void addStudent(Student s){
        wholeClass.add(s);
    }

    public String[] getStudents(){
        String[] studentList = new String[wholeClass.size()];
        for(int i = 0; i<wholeClass.size(); i++){
            studentList[i] = wholeClass.get(i).toString();
        }
        return studentList;

    }

    public String toString(){
        return name;
    }


}
