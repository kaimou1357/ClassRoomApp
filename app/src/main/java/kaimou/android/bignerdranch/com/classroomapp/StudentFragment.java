package kaimou.android.bignerdranch.com.classroomapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Kai on 8/16/2015.
 */
public class StudentFragment extends ListFragment {
    private ArrayAdapter<String> adapter = null;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;

    private Button add_student;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_fragment, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        mRecyclerView = (RecyclerView)view.findViewById(R.id.student_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mManager = new LinearLayoutManager(getActivity());

        //specify adapter.
        mAdapter = new StudentAdapter(MainActivity.getUserSelectedClass().getStudents());
        mRecyclerView.setAdapter(mAdapter);



        add_student = (Button)view.findViewById(R.id.add_student);

    }

    public void onStart(){
        super.onStart();
        //updateData();
        add_student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

                View promptView = layoutInflater.inflate(R.layout.alert_dialog_layout, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setView(promptView);

                final EditText input = (EditText) promptView.findViewById(R.id.userClassNameEntry);

                //setup the dialog window.
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //get user input and set it to a string.
                                String userStudentName = input.getText().toString();
                                MainActivity.getUserSelectedClass().addStudent(new Student(userStudentName));
                                updateData();


                            }

                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                //create an alert dialog

                AlertDialog alertD = alertDialogBuilder.create();

                alertD.show();


            }
        });


    }

    private void updateData(){
        Classroom c = MainActivity.getUserSelectedClass();
        String[] students = c.getStudentsString();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, students);

        //listView.setAdapter(adapter);

    }
}
