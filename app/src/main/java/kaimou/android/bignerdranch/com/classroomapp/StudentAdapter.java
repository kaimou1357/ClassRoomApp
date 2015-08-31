package kaimou.android.bignerdranch.com.classroomapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kai on 8/31/2015.
 */
public class StudentAdapter extends
        RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView studentName;
        public Button add_points;
        public Button subtract_points;



        public ViewHolder(View itemView) {
            super(itemView);

            studentName = (TextView) itemView.findViewById(R.id.student_name);
            add_points = (Button) itemView.findViewById(R.id.add_button);
            subtract_points = (Button) itemView.findViewById(R.id.subtract_points_button);

        }
    }
    private ArrayList<Student> mStudents;
    public StudentAdapter(ArrayList<Student> students) {
        mStudents = students;
    }
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = inflater.inflate(R.layout.individual_student, parent ,false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    public void onBindViewHolder(StudentAdapter.ViewHolder viewHolder, int position){
        Student student = MainActivity.getUserSelectedClass().getStudents().get(position);

        TextView textView = viewHolder.studentName;
        textView.setText(student.toString());


    }
    @Override
    public int getItemCount(){return mStudents.size();}
}









