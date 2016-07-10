package com.kaloglu.tournaments.models;

/**
 * Created by kaloglu on 05/06/16.
 */
public abstract class BaseModel {
    public abstract String getSaveableString();

    public long NullCheck(long longField, long ifNull) {
        if (longField == 0 || longField == Long.MAX_VALUE) return ifNull;
        else return longField;

    }

}
