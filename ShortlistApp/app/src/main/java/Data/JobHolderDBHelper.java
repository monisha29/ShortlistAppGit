package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;

import Data.JobHolderContract.*;

import static Data.JobHolderContract.JobholderEntry.*;

/**
 * Created by FDUSER on 11/1/2017.
 */

public class JobHolderDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "jobholder.db";
    private static final int DATABASE_VERSION = 1;

    public JobHolderDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_JOBHOLDER_TABLE =

                "CREATE TABLE " +
                        TABLE_NAME + " (" +
                        _ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE       + " TEXT, "                 +
                        COLUMN_DEADLINE + " TEXT, "                 +
                        ");";
        sqLiteDatabase.execSQL(SQL_CREATE_JOBHOLDER_TABLE);
    }

    public void inserJobHolderValue(String title, String deadline ,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE,title);
        contentValues.put(COLUMN_DEADLINE,deadline);
        db.insert(JobholderEntry.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS" , "inserted"); 
            }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
