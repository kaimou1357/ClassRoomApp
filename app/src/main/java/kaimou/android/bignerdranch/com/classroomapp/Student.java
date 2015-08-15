package kaimou.android.bignerdranch.com.classroomapp;

/**
 * Created by Kai on 8/15/2015.
 */
public class Student {
    private int totalPoints;

    public Student(){
        totalPoints = 0;
    }

    public void modPoints(int points){
        totalPoints+=points;

    }

    public int getPoints(){
        return totalPoints;

    }

}
