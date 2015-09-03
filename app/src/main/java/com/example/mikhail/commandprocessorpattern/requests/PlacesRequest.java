package com.example.mikhail.commandprocessorpattern.requests;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import com.example.mikhail.commandprocessorpattern.handlers.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.model.Place;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class PlacesRequest extends CommonRequest{

    private MessageController handler_;
    public PlacesRequest(MessageController handler){
        this.handler_ = handler;
    }

    public void sendRequest(int id){
        sendFakeAsyncPlaceRequest(1);
    }

    private void sendFakeAsyncPlaceRequest(final int id){
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    List<Place> places = new ArrayList<>();
                    Place fakePlace = new Place("Place1","desc");
                    places.add(fakePlace);
                    handler_.sendMessage(handler_.obtainMessage(States.REQUEST_COMPLETED, places));
                } catch (Exception e) {
                }
            }
        });
        background.start();
    }
}
