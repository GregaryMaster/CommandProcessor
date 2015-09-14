package com.example.mikhail.commandprocessorpattern.executor;

import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.interfaces.UpdateCallbackListener;
import com.example.mikhail.commandprocessorpattern.model.Place;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.model.Track;
import com.example.mikhail.commandprocessorpattern.requests.CommonRequest;
import com.example.mikhail.commandprocessorpattern.requests.PlacesRequest;
import com.example.mikhail.commandprocessorpattern.requests.TracksRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class RequestProcessor {

    private UpdateCallbackListener clientActivity_;

    public RequestProcessor(UpdateCallbackListener clienActivity) {
        this.clientActivity_ = clienActivity;
    }

    public void execute(final MessageController controller, final CommonRequest request) {


        Thread background = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    request.getDataRequest();
                    Thread.sleep(5000);
                    List<Result> results = new ArrayList<>();
                    if (request instanceof PlacesRequest) {
                        Result fakePlace = new Place("Place", "description");
                        results.add(fakePlace);
                    } else if (request instanceof TracksRequest) {
                        Result fakeTrack = new Track("Track", "description");
                        results.add(fakeTrack);
                    }
                    controller.sendMessage(controller.obtainMessage(States.REQUEST_COMPLETED, results));
                } catch (Exception e) {
                }
            }
        });
        background.start();
    }

    public void updateActivity(List<? extends Result> results) {
        clientActivity_.onUpdate(results);
    }
}
