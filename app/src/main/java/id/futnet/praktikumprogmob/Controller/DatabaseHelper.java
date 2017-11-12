package id.futnet.praktikumprogmob.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.futnet.praktikumprogmob.Controller.Config;
import id.futnet.praktikumprogmob.model.Member;
import id.futnet.praktikumprogmob.model.MemberResult;

//import static it.creative.contactphone.Model.Config.TABLE_MEMBER;

/**
 * Created by Devtian Dicky on 08-Nov-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TABLE_MEMBER = "TABLE_MEMBER";

    public DatabaseHelper(Context context) {
        super(context, Config.DATABASE_NAME, null, Config.DATABASE_VERSION);
        Log.d("STATUS", "Database on excute");
    }

    @Override
    public void onCreate(SQLiteDatabase db ) {
        String CREATE_TABLE = "CREATE TABLE" + Config.TABLE_MEMBER + " ( " +
                Config.MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Config.MEMBER_NAME + " TEXT, " +
                Config.EMAIL + " TEXT," +
                Config.PASSWORD + " TEXT ";

                db.execSQL(CREATE_TABLE);
        Log.d("STATUS ", "Tabel Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        // Create tables again
        onCreate(db);
        Log.d("STATUS ", "Tabel on upgraded");
    }

    // Adding new MEMBER
    public void addContact(Member contact) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Config.MEMBER_ID, contact.getMEMBER_id()); // member ID
            values.put(Config.MEMBER_NAME, contact.getMEMBER_name()); // member Name
            values.put(Config.EMAIL, contact.getEMAIL());//  Email
            values.put(Config.PASSWORD, contact.getPASSWORD());// Password
            //values.put(Config.CONTACT_IMAGE, contact.getContact_img_uri());// Contact Image

            // Inserting Row
            db.insert(TABLE_MEMBER, null, values);
            db.close(); // Closing database connection
            Log.d("STATUS TAMBAH ", "SUKSES");
        } catch (Exception e) {
            Log.d("STATUS TAMBAH ", e.getMessage());
        }
    }
}
