package com.dnk.virtualattendance.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "VirtualAttendance.db";
    private static final int DATABASE_VERSION = 1;

    // Table Roles
    public static final String TABLE_ROLE = "roles";
    public static final String ROLE_FIELD_ID = "id";
    public static final String ROLE_FIELD_ROLE_NAME = "role_name";
    public static final String ROLE_FIELD_WORKING_START_TIME = "working_start_time";
    public static final String ROLE_FIELD_WORKING_END_TIME = "working_end_time";
    public static final String ROLE_FIELD_WORKING_SPARE_TIME = "working_spare_time";
    public static final String ROLE_FIELD_WORKING_LOCATION = "working_location";
    public static final String ROLE_FIELD_SALARY = "salary";

    // Table Users
    public static final String TABLE_USER = "users";
    public static final String USER_FIELD_ID = "id";
    public static final String USER_FIELD_NAME = "name";
    public static final String USER_FIELD_EMAIL = "email";
    public static final String USER_FIELD_ROLE = "role";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Query to create roles table
        String createRolesTable = "CREATE TABLE " + TABLE_ROLE + "("
                + ROLE_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ROLE_FIELD_ROLE_NAME + " TEXT, "
                + ROLE_FIELD_WORKING_START_TIME + " TEXT, "
                + ROLE_FIELD_WORKING_END_TIME + " TEXT, "
                + ROLE_FIELD_WORKING_SPARE_TIME + " TEXT, "
                + ROLE_FIELD_WORKING_LOCATION + " TEXT, "
                + ROLE_FIELD_SALARY + " TEXT "
                + ")";
        db.execSQL(createRolesTable);

        // Query to create users table
        String createUsersTable = "CREATE TABLE " + TABLE_USER + "("
                + USER_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_FIELD_NAME + " TEXT, "
                + USER_FIELD_EMAIL + " TEXT, "
                + USER_FIELD_ROLE + " TEXT "
                + ")";
        db.execSQL(createUsersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop existing tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROLE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Recreate tables
        onCreate(db);
    }
}