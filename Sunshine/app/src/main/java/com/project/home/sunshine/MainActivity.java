package com.project.home.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Create a dummy data set to show in the ListView
            ArrayList<String> weatherList = new ArrayList<>();
            weatherList.add("Mon 6/23 - Sunny - 31/17");
            weatherList.add("Tue 6/24 - Foggy - 21/8");
            weatherList.add("Wed 6/25 - Cloudy - 22/17");
            weatherList.add("Thurs 6/26 - Rainy - 18/11");
            weatherList.add("Fri 6/27 - Foggy - 21/10");
            weatherList.add("Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18");
            weatherList.add("Sun 6/29 - Sunny - 20/7");

            //Create the Array Adapter for the ListView
            ArrayAdapter forecastAdapter = new ArrayAdapter(getActivity(),
                    R.layout.list_item_forecast,        //list item layout
                    R.id.list_item_forecast_textview,   //textview
                    weatherList);

            // Get the ListView and set the Adapter
            ListView forecastView = (ListView) rootView.findViewById(R.id.listview_forecast);
            forecastView.setAdapter(forecastAdapter);

            return rootView;
        }
    }
}
