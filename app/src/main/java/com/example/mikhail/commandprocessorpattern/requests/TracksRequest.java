package com.example.mikhail.commandprocessorpattern.requests;

import com.example.mikhail.commandprocessorpattern.executor.MessageController;
import com.example.mikhail.commandprocessorpattern.helpers.States;
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



}
