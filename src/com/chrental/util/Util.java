package com.chrental.util;

import java.util.TimeZone;

import com.google.gson.Gson;

public class Util {

	   /**
     * Null check Method
     * 
     * @param txt
     * @return
     */
    public static boolean isNotNullOREmpty(String txt) {
        // System.out.println("Inside isNotNull");
        return txt != null && txt.trim().length() > 0 ? true : false;
    }
 
    /**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @return
     */
    public static Object constructJSON(String tag, boolean status,Object response) {
    	  ReturnType obj=null;
          Gson gson = null;
          String json=null;
        try {
        	gson = new Gson();
        	obj = new ReturnType(response,tag,status);
            json = gson.toJson(obj);

        } catch (Exception e) {
        }
        return json;
    }
 
    /**
     * Method to construct JSON with Error Msg
     * 
     * @param tag
     * @param status
     * @param err_msg
     * @return
     */
    public static Object constructJSON(String tag,Object err_msg,boolean status) {
    	 ReturnType obj=null;
         Gson gson = null;
         String json=null;
        try {
        	gson = new Gson();
        	obj = new ReturnType(err_msg,tag,status);
            json = gson.toJson(obj);
        } catch (Exception e) {
        }
        return json;
    }
    
    public static java.sql.Timestamp getCurrentTimeStamp() {
    	java.util.Date today = new java.util.Date();
    	TimeZone.setDefault(TimeZone.getTimeZone("Europe/Istanbul"));
    	return new java.sql.Timestamp(today.getTime());
    }
}
