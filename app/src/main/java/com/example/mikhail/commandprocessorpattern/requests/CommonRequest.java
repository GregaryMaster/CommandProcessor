package com.example.mikhail.commandprocessorpattern.requests;

/**
 * Created by Mikhail Valuyskiy on 24.08.2015.
 */
public abstract class CommonRequest {

    public abstract void sendRequest(int i);
    public int requestId;
}
