package kaimou.android.bignerdranch.com.classroomapp;

/**
 * Created by Kai on 8/15/2015.
 */
public class Student {
    private int totalPoints;
    private String sName = "";

    public Student(String name){
        totalPoints = 0;
        sName = name;
    }

    public void modPoints(int points){
        totalPoints+=points;

    }

    public int getPoints(){
        return totalPoints;

    }

    public String toString(){
        return sName;
    }

}
