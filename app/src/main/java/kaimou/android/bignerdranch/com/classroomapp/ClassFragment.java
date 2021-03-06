package kaimou.android.bignerdranch.com.classroomapp;

import android.app.Activity;
import android.content.ContentUris;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


    //container activity must implement this interface to communicate between two fragments.

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.class_fragment, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        listView = (ListView)view.findViewById(R.id.classList);

    }

    public void onStart(){
        super.onStart();



        //define a new adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, MainActivity.getClasses());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //as soon as a class is clicked, load another fragment and pass to the other fragment what the class is so the other fragment can load the list
                // of students associated with the class.
                passClass(position);
                //pass the classroom to Activity.

                Fragment fragment = new StudentFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.mainActivity, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }

        });

        //create values inside string that need to be shown.



    }
    /*
    This method should show the list of students that are associated with this class.
    Needs to pass the class argument to the student Fragment class.
     */
    public void passClass(int position){
        MainActivity.setUserSelectedClass(position);

    }
}
