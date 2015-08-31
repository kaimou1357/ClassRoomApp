package kaimou.android.bignerdranch.com.classroomapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    private Button configure_points_button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.main_fragment, container,false);
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        classes_button = (Button)view.findViewById(R.id.classes_button);
        settings_button = (Button)view.findViewById(R.id.edit_button);
        configure_points_button = (Button) view.findViewById(R.id.configurePointsButton);

    }

    public void onStart(){
        super.onStart();
        settings_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment fragment = new EditClassFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.mainActivity, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        classes_button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                //if clicked, bring you to your classes fragment.
                Fragment fragment = new ClassFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.mainActivity, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        configure_points_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //this needs a button and Listview to add
                Fragment fragment = new PointsFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.mainActivity, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
