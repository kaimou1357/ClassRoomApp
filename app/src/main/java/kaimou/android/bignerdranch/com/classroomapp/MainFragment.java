package kaimou.android.bignerdranch.com.classroomapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Kai on 8/14/2015.
 */
public class MainFragment extends Fragment {
    private Button classes_button;
    private Button settings_button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.main_fragment, container,false);
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        classes_button = (Button)view.findViewById(R.id.classes_button);
        settings_button = (Button)view.findViewById(R.id.edit_button);

    }
}
