package com.example.mikhail.commandprocessorpattern.handlers;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.mikhail.commandprocessorpattern.helpers.States;
import com.example.mikhail.commandprocessorpattern.interfaces.UpdateCallbackListener;
import com.example.mikhail.commandprocessorpattern.managers.RequestProcessor;
import com.example.mikhail.commandprocessorpattern.model.Place;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.model.Track;
import com.example.mikhail.commandprocessorpattern.requests.CommonRequest;
import com.example.mikhail.commandprocessorpattern.requests.TracksRequest;

import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class MessageController extends Handler {

    private static MessageController instance = null;

    private RequestProcessor processor_;

    public void init (UpdateCallbackListener listener) {
        processor_ = new RequestProcessor(listener);
    }

    public static MessageController getInstance(){
        if (instance == null){
            instance = new MessageController();
        }
        return instance;
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case States.INIT_REQUEST:
                CommonRequest request = (CommonRequest)msg.obj;
                processor_.execute(request);
                break;

            case States.REQUEST_COMPLETED:
                List<Result> results = (List<Result>)msg.obj;
                processor_.updateActivity(results);
                break;

            default:
                break;
        }
    }
}
