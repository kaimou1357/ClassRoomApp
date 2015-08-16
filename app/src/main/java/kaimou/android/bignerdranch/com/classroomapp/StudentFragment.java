package kaimou.android.bignerdranch.com.classroomapp;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Kai on 8/16/2015.
 */
public class StudentFragment extends ListFragment {

    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.student_fragment, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        listView = (ListView)view.findViewById(R.id.studentList);

    }
}
