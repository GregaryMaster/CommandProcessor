package com.example.mikhail.commandprocessorpattern.requests;

import android.content.res.Resources;
import android.util.Base64;
import android.util.Log;

import com.example.mikhail.commandprocessorpattern.handlers.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.model.Track;

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
public class TracksRequest extends CommonRequest {

    private MessageController handler_;

    public TracksRequest(MessageController handler) {
        this.handler_ = handler;
    }

    public void sendRequest(int id) {
        sendFakeAsyncTracksRequest();
    }

    private void sendFakeAsyncTracksRequest() {
        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    List<Track> tracks = new ArrayList<>();
                    Track fakeTrack = new Track(1,"SomeTrack","Description",23,45);
                    tracks.add(fakeTrack);
                    handler_.sendMessage(handler_.obtainMessage(States.REQUEST_COMPLETED, tracks));
                } catch (Exception e){}
            }
        });
        background.start();
    }

}
