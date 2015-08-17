package kaimou.android.bignerdranch.com.classroomapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
public class EditClassFragment extends Fragment {
    private Button add_class;
    private ListView listView;
    private ArrayAdapter<String> adapter = null;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.edit_class_fragment, container, false);
        return view;

    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        add_class = (Button)view.findViewById(R.id.add_button);
        listView = (ListView)view.findViewById(R.id.classListView);
    }

    public void onStart(){
        super.onStart();
        //initialize listView and populate with classes.
        updateData();



        //when user decides to add a class.
        add_class.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

                View promptView = layoutInflater.inflate(R.layout.alert_dialog_layout, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setView(promptView);

                final EditText input = (EditText) promptView.findViewById(R.id.userClassNameEntry);

                //setup the dialog window.
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                //get user input and set it to a string.
                                String userClassName = input.getText().toString();
                                MainActivity.addClass(userClassName);
                                updateData();


                            }

                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
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
        //Update and refresh the listView whenever a user adds/deletes a class.
        String[] newData = MainActivity.getClasses();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, MainActivity.getClasses());

        listView.setAdapter(adapter);
    }

}
