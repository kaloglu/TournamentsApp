package com.kaloglu.tournaments.databases.dao.interfaces;

import android.database.Cursor;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by cihank on 09/06/16.
 */
public interface ISqliteDAO {
    ISqliteDAO table(String table);
    ISqliteDAO fields(String... fields);
    ISqliteDAO find();
    ISqliteDAO findOne();
    ISqliteDAO select(ISqliteDAO... daos);
    ISqliteDAO select(String selection);
    ISqliteDAO createJoins(ISqliteDAO... daos);
    ISqliteDAO save(String values);
    ISqliteDAO insert(String... values);
    ISqliteDAO update(String[] columns, Object[] values);
    ISqliteDAO where(String clause);
    ISqliteDAO join(ISqliteDAO dao);
    ISqliteDAO join(String table);
    ISqliteDAO leftJoin(String table);
    ISqliteDAO on(String on);
    ISqliteDAO orWhere(String clause);
    ISqliteDAO limit(Integer limit);
    ISqliteDAO sort(String field, String sortby);
    ISqliteDAO execute();
    ISqliteDAO execute(String queryString);
    ISqliteDAO json();
    ISqliteDAO jsonList();
    void execSql();
    Cursor cursor();
    <T> T getObject(Class<T> classOfT);
    <T, V> ArrayList<T> getArray(TypeToken<V> token);
    String getTable();
    String[] getFields();
    String getDropScript();
    String getCreateScript();
    void setCreateScript(String s);
}
