package kaimou.android.bignerdranch.com.classroomapp;

import android.app.Activity;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Kai on 8/15/2015.
 */
public class ClassFragment extends ListFragment {
    private ArrayAdapter<String> adapter = null;
    ListView listView;
    OnArticleSelectedListener mListener;

    //container activity must implement this interface to communicate between two fragments.

    public interface OnArticleSelectedListener{
        public void onArticleSelected(Classroom room);
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (OnArticleSelectedListener) activity;

        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement OnArticleSelectedListener");
        }
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.class_fragment, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        listView = (ListView)view.findViewById(R.id.classList);

    }

    public void onStart(){
        super.onStart();

        String[] classRoomNames = {"Test Classroom", "TestClassroom2", "TestClass3"};

        //define a new adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, classRoomNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showStudents(position);

            }

        });

        //create values inside string that need to be shown.



    }

    public void showStudents(int position){

    }
}
