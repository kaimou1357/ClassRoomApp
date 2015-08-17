package kaimou.android.bignerdranch.com.classroomapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    static ArrayList<Classroom> listOfClasses = new ArrayList<Classroom>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = fm.findFragmentById(R.id.mainActivity);

        if(fragment == null){
            transaction.add(R.id.mainActivity, new MainFragment()).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void addClass(String className){
        Classroom c = new Classroom(className);
        listOfClasses.add(c);

    }

    public static String[] getClasses(){
        String[] temp = new String[listOfClasses.size()];
        if(listOfClasses.size() == 0){
            return temp;
        }

        for(int i = 0; i<listOfClasses.size(); i++){
            temp[i] = listOfClasses.get(i).toString();
        }

        return temp;
    }
}
