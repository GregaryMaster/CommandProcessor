package com.example.mikhail.commandprocessorpattern.requests;

import com.example.mikhail.commandprocessorpattern.model.Result;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 24.08.2015.
 */
public abstract class CommonRequest {
    public abstract int getDataRequest();
    public abstract List<Result> parseRequest();
}