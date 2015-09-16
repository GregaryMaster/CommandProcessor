package com.example.mikhail.commandprocessorpattern.requests;

import com.example.mikhail.commandprocessorpattern.executor.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.model.Place;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.model.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class TracksRequest extends CommonRequest {

    private int id_;

    public int  getDataRequest(){
        return this.id_;
    }

    public List<Result> parseRequest() {
        // Let's imagine we have parsed json
        List<Result> results = new ArrayList<>();
        Result fakeTrack = new Track("Track", "description");
        results.add(fakeTrack);
        return results;
    }

}
