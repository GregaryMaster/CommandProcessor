package com.example.mikhail.commandprocessorpattern.requests;

import com.example.mikhail.commandprocessorpattern.executor.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.model.Place;

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

    public int  getDataRequest(){
        return this.id_;
    }

}
