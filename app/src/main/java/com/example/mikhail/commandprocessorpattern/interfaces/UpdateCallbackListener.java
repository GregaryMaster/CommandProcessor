package com.example.mikhail.commandprocessorpattern.interfaces;

import com.example.mikhail.commandprocessorpattern.model.Result;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 25.08.2015.
 */
public interface UpdateCallbackListener {
    void onUpdate(List<? extends Result> results);
}
