package com.example.mikhail.commandprocessorpattern.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mikhail.commandprocessorpattern.R;
import com.example.mikhail.commandprocessorpattern.adapters.PlacesAdapter;
import com.example.mikhail.commandprocessorpattern.handlers.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.Constants;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.interfaces.UpdateCallbackListener;
import com.example.mikhail.commandprocessorpattern.model.Place;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.model.Track;
import com.example.mikhail.commandprocessorpattern.requests.PlacesRequest;

import java.util.List;

public class PlacesActivity extends FragmentActivity implements UpdateCallbackListener {

    private PlacesAdapter placesAdapter_;
    private ListView listView_;
    private List<Place> places_;
    private MessageController handler_ = null;
    private int selectedTrackId_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // Gets selected track id
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        selectedTrackId_ = extras.getInt(Constants.SELECTED_ITEM_ID, 0);

        handler_ = MessageController.getInstance();
        handler_.init(this);
        PlacesRequest placesRequest = new PlacesRequest(handler_);
        placesRequest.requestId = selectedTrackId_;
        handler_.sendMessage(handler_.obtainMessage(States.INIT_REQUEST, placesRequest));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_places, menu);
        return true;
    }

    public void onUpdate(List<? extends Result> results){
        updateUI(results);
    }

    public void updateUI(List<? extends Result> results) {
        places_ = (List<Place>) results;
        placesAdapter_ = new PlacesAdapter(this, places_);
        listView_ = (ListView) this.findViewById(R.id.placeListView);
        listView_.setAdapter(placesAdapter_);
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
}
