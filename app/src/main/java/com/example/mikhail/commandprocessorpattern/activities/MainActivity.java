package com.example.mikhail.commandprocessorpattern.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mikhail.commandprocessorpattern.R;
import com.example.mikhail.commandprocessorpattern.adapters.TrackAdapter;
import com.example.mikhail.commandprocessorpattern.handlers.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.Constants;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.interfaces.UpdateCallbackListener;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.model.Track;
import com.example.mikhail.commandprocessorpattern.requests.TracksRequest;

import java.util.List;


public class MainActivity extends FragmentActivity implements UpdateCallbackListener{

    private  List<Track> tracks_;
    private  ListView listView_;
    private MessageController controller_ = null;

    public void onUpdate(List<? extends Result> results){
        tracks_ = (List<Track>) results;
        TrackAdapter trackAdapter = new TrackAdapter(this,tracks_);
        listView_.setAdapter(trackAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_ = (ListView) this.findViewById(R.id.track_list);

        // Get the instnace of controller
        controller_ = MessageController.getInstance();
        // Init controller by passing listener
        // It is necessary for updating current activity when request completed
        controller_.init(this);
        // Create tracks request
        TracksRequest tracksRequest = new TracksRequest(controller_);
        // Send request
        controller_.sendMessage(controller_.obtainMessage(States.INIT_REQUEST,tracksRequest));

        listView_.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemId = tracks_.get(position).getTrackId();
                Intent intent = new Intent(MainActivity.this,PlacesActivity.class);
                intent.putExtra(Constants.SELECTED_ITEM_ID,itemId);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
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
}
