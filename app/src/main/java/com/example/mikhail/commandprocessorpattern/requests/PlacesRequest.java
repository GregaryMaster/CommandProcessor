package com.example.mikhail.commandprocessorpattern.requests;

import com.example.mikhail.commandprocessorpattern.executor.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.model.Place;
import com.example.mikhail.commandprocessorpattern.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class PlacesRequest extends CommonRequest {

   private int id_;

    public PlacesRequest(int id){
        id_ = id;
    }

    public int getDataRequest(){
        return this.id_;
    }

    public List<Result> parseRequest() {
        // Let's imagine we have parsed json
        List<Result> results = new ArrayList<>();
        Result fakePlace = new Place("Place", "description");
        results.add(fakePlace);
        return results;
    }
}
