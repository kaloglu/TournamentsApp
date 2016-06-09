package com.kaloglu.tournaments.databases.dao;

/**
 * Created by cihank on 09/06/16.
 */
public class ForeignKey {
    private String foriegnKey;
    private String tableName;

    public ForeignKey(String fk, String table) {
        foriegnKey = fk;
        tableName = table;
    }

    public String getForiegnKey() {
        return foriegnKey;
    }

    public String getTableName() {
        return tableName;
    }
}
