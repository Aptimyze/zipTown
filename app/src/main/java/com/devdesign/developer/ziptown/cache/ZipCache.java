package com.devdesign.developer.ziptown.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZipCache {

    public static final String OFFERS = "Offers";
    public static final String USER_DATA = "UserData";
    public static final String REQUESTS = "Requests";
    public static final String USER_OFFERS = "UserOffers";
    public static final String USER_REQUESTS = "UserRequests";
    public static final String REQUESTS_SEARCH = "RequestsSearch";
    public static final String OFFERS_SEARCH = "OffersSearch";
    private static ZipCache instance;
    private static SQLiteDatabase mDatabase;
    private ArrayList<String> postKeys;


    private ZipCache(){}


    public void init(SQLiteDatabase db){
        this.mDatabase = db;
        postKeys = new ArrayList<>();
    }
    public void clearTable(String table){

        createRequestsTable();
        createOffersTable();
        createOffersSearchTable();
        createRequestsSearchTable();

        createUserDataTable();
        createUserOffersTable();
        createUserRequestsTable();

        mDatabase.delete(table, null, null);
    }

    private static void createUserDataTable(){

        String sqlSite = "CREATE TABLE IF NOT EXISTS UserData (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tfullName varchar(200) , \n" +
                "\tcity  varchar(200),\n" +
                "\tpassword  varchar(200),\n" +
                "\tuserType  varchar(200), \n" +
                "\tcontact varchar(200) \n, " +
                "\tcreated varchar(200) \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }

    private static void createUserOffersTable(){

        String sqlSite = "CREATE TABLE IF NOT EXISTS UserOffers (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }


    private static void createRequestsTable(){

        String sqlSite = "CREATE TABLE IF NOT EXISTS Requests (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }
    private static void createUserRequestsTable(){

        String sqlSite = "CREATE TABLE IF NOT EXISTS UserRequests (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }
    private static void createOffersTable(){

        String sqlSite = "CREATE TABLE IF NOT EXISTS Offers (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }
    public  void addRequests(ContentValues values){
        createRequestsTable();
        mDatabase.insertWithOnConflict(REQUESTS, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public  void addOffers(ContentValues values){
        createOffersTable();
        mDatabase.insertWithOnConflict(OFFERS, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public  void addRequestsSearch(ContentValues values){
        createRequestsSearchTable();
        mDatabase.insertWithOnConflict(REQUESTS_SEARCH, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    private void createRequestsSearchTable() {
        String sqlSite = "CREATE TABLE IF NOT EXISTS RequestsSearch (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }

    public  void addOffersSearch(ContentValues values){
        createOffersSearchTable();
        mDatabase.insertWithOnConflict(OFFERS_SEARCH, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    private void createOffersSearchTable() {
        String sqlSite = "CREATE TABLE IF NOT EXISTS OffersSearch (\n" +
                "\tid int  PRIMARY KEY,\n" +
                "\tpublisherId int , \n" +
                "\tcity  varchar(200),\n" +
                "\tdays  varchar(200),\n" +
                "\tdepatureTime  varchar(200), \n" +
                "\treturnTime  varchar(200), \n" +
                "\tcontact varchar(200), \n" +
                "\torigin varchar(200), \n" +
                "\tdestination varchar(200), \n" +
                "\tpublisher varchar(200), \n" +
                "\tcreated varchar(200), \n" +
                "\tpostType varchar(200)  \n" +
                ");";
        mDatabase.execSQL(sqlSite);
    }

    public  void addUserOffers(ContentValues values){
        createUserOffersTable();
        mDatabase.insertWithOnConflict(USER_OFFERS, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public  void addUserRequests(ContentValues values){
        createUserRequestsTable();
        mDatabase.insertWithOnConflict(USER_REQUESTS, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
    public void addUserData(ContentValues values){
        createUserDataTable();
        mDatabase.insertWithOnConflict(USER_DATA, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    private Cursor getOffersTable(){
        createOffersTable();
        String select = "SELECT * FROM  " + OFFERS;
        return  mDatabase.rawQuery(select, null);
    }
    private Cursor getRequestsTable(){
        createRequestsTable();
        String select = "SELECT * FROM  " + REQUESTS;
        return  mDatabase.rawQuery(select, null);
    }
    private Cursor getOffersSearchTable(){
        createOffersSearchTable();
        String select = "SELECT * FROM  " + OFFERS_SEARCH;
        return  mDatabase.rawQuery(select, null);
    }
    private Cursor getRequestsSearchTable(){
        createRequestsSearchTable();
        String select = "SELECT * FROM  " + REQUESTS_SEARCH;
        return  mDatabase.rawQuery(select, null);
    }
    private Cursor getUserTable(){
        createUserDataTable();
        String select = "SELECT * FROM  " + USER_DATA;
        return  mDatabase.rawQuery(select, null);
    }
    private Cursor getUserOffersTable(){
        createUserOffersTable();
        String select = "SELECT * FROM  " + USER_OFFERS;
        return  mDatabase.rawQuery(select, null);
    }

    private Cursor getUserRequestsTable(){
        createUserRequestsTable();
        String select = "SELECT * FROM  " + USER_REQUESTS;
        return  mDatabase.rawQuery(select, null);
    }
    public  ContentValues toContentValues(Map<String, Object> dataMap) {
        ContentValues values = new ContentValues();
        Object[] keys = dataMap.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            values.put(keys[i].toString(), dataMap.get(keys[i].toString()).toString());
        }
        return values;
    }
    public String[] getColumnNames(int index) {
        List<String[]> columns = new ArrayList<>();
        String[] userColumn = {"id", "fullName", "city", "contact", "userType", "created", "password"};
        columns.add(userColumn);
        String[] post = {"id", "publisherId", "depatureTime", "returnTime", "days", "publisher", "contact", "postType", "city","origin","destination", "created"};
        columns.add(post);
        return columns.get(index);
    }
    public Map<String, Object> getLocalUserData(){

        //query local cache database
        String[] tableCols = getColumnNames(0); //get all columns in the database
        Cursor userDataCursor = getUserTable(); //return all data on table

        Map<String, Object> data = new HashMap<>();
        if(userDataCursor.moveToNext()){
            do{
                for(int i = 0 ; i < tableCols.length ; i++){
                    String colContent = userDataCursor.getString(userDataCursor.getColumnIndex(tableCols[i]));

                    switch (tableCols[i]){
                        case "id":
                            data.put("id", colContent);
                            break;
                        case "fullName":
                            data.put("fullName", colContent);
                            break;
                        case "city":
                            data.put("city", colContent);
                            break;
                        case "contact":
                            data.put("contact", colContent);
                            break;
                        case "created":
                            data.put("created", colContent);
                            break;
                        case "userType":
                            data.put("userType", colContent);
                            break;
                        case "password":
                            data.put("password", colContent);
                            break;

                    }

                }

            }while (userDataCursor.moveToNext());
        }
        Log.i("WSX", "getLocalUserData: "+data);
        return data;
    }
    private Cursor getMatch(String table, String field, String value){
        String select = "SELECT * FROM " + table + " WHERE " +field + " = ?";
        return  mDatabase.rawQuery(select, new String[]{value});
    }

    public Map<String, Map<String, Object>> getLocalPost(String table) {
        Cursor dataCursor;
        if (table.equals(OFFERS)) {
            Log.i("WSX", "getLocalPost: OFFERS");
            dataCursor = getOffersTable(); //return all data on table
        } else if (table.equals(REQUESTS)) {
            Log.i("WSX", "getLocalPost: REQUESTS");
            dataCursor = getRequestsTable(); //return all data on table
        } else if (table.equals(USER_OFFERS)) {
            Log.i("WSX", "getLocalPost: USER_OFFERS");
            dataCursor = getUserOffersTable(); //return all data on table
        } else if (table.equals(REQUESTS_SEARCH)) {
            Log.i("WSX", "getLocalPost: REQUESTS_SEARCH");
            dataCursor = getRequestsSearchTable(); //return all data on table
        } else if (table.equals(OFFERS_SEARCH)) {
            Log.i("WSX", "getLocalPost: OFFERS_SEARCH");
            dataCursor = getOffersSearchTable(); //return all data on table
        }else {
            Log.i("WSX", "getLocalPost: USER_REQUESTS");
            dataCursor = getUserRequestsTable(); //return all data on table
        }
        //query local cache database
        String[] tableCols = getColumnNames(1); //get all columns in the database
        Map<String, Map<String, Object>> tableData = new HashMap<>();
        if (dataCursor.moveToNext()) {
            do {
                Map<String, Object> data = new HashMap<>();
                for (int i = 0; i < tableCols.length; i++) {
                    String colContent = dataCursor.getString(dataCursor.getColumnIndex(tableCols[i]));

                    switch (tableCols[i]) {
                        case "id":
                            data.put("id", colContent);

                            break;
                        case "publisherId":
                            data.put("publisherId", colContent);
                            break;
                        case "depatureTime":
                            data.put("depatureTime", colContent);
                            break;
                        case "returnTime":
                            data.put("returnTime", colContent);
                            break;
                        case "city":
                            data.put("city", colContent);
                            break;
                        case "days":
                            data.put("days", colContent);
                            break;
                        case "publisher":
                            data.put("publisher", colContent);
                            break;
                        case "postType":
                            data.put("postType", colContent);
                            break;
                        case "origin":
                            data.put("origin", colContent);
                            break;
                        case "destination":
                            data.put("destination", colContent);
                            break;
                        case "contact":
                            data.put("contact", colContent);
                            break;
                        case "created":
                            data.put("created", colContent);
                            break;

                    }

                }
                tableData.put(data.get("id").toString(), data);
            } while (dataCursor.moveToNext());
        }
        Log.i("WSX", "getLocalPost: " + tableData);
        return tableData;
    }

    public static ZipCache getInstance() {
        if (instance == null)
            instance = new ZipCache();

        return instance;
    }

}
