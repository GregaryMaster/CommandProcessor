package com.example.mikhail.commandprocessorpattern.managers;

import com.example.mikhail.commandprocessorpattern.interfaces.UpdateCallbackListener;
import com.example.mikhail.commandprocessorpattern.model.Result;
import com.example.mikhail.commandprocessorpattern.requests.CommonRequest;

import java.util.List;

/**
 * Created by Mikhail on 02.08.2015.
 */
public class RequestProcessor {

    private UpdateCallbackListener clientActivity_;

    public RequestProcessor(UpdateCallbackListener clienActivity) {
        this.clientActivity_ = clienActivity;
    }

    public void execute(CommonRequest request) {
        request.sendRequest(request.requestId);
    }

    public void updateActivity(List<? extends Result> results) {
        clientActivity_.onUpdate(results);
    }
}
