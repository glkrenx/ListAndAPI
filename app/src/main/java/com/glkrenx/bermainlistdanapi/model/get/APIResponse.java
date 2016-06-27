package com.glkrenx.bermainlistdanapi.model.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glkrenx on 24/06/16.
 */
public class APIResponse {
    @SerializedName("result")
    @Expose
    private Result result = new Result();

    public Result getResult() {
        return result;
    }
}
