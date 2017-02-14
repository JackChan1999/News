
package com.google.topnews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "database.db";
    public static final int VERSION = 1;
    public static final String TABLE_CHANNEL = "ChannelItem";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ORDERID = "orderId";
    public static final String SELECTED = "selected";

    private final Context context;

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + TABLE_CHANNEL +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID + " INTEGER , " +
                NAME + " TEXT , " +
                ORDERID + " INTEGER , " +
                SELECTED + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*switch (oldVersion) {
        	case 1:
        		break;
            case 2:
                break;
        	default:
        		break;
        }*/
        onCreate(db);
    }

}
