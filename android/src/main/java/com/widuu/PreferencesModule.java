package com.widuu;

/**
 * Created by widuu on 2017/6/26.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;


public class PreferencesModule extends ReactContextBaseJavaModule{

    private static  String TAG = "PreferencesModule";

    SharedPreferences preferences;

    SharedPreferences.Editor editor;

    public PreferencesModule(ReactApplicationContext reactContext)  {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "PreferencesModule";
    }


    @ReactMethod
    public void getSharedPreferences(String name ,int mode ) {
        if( preferences == null ){
            preferences = getReactApplicationContext().getSharedPreferences(name, mode);
            editor = preferences.edit();
        }

    }

    @ReactMethod
    public void putString(String name,String val){
        editor.putString(name,val);
    }

    @ReactMethod
    public void putInt(String name,int val){
        editor.putInt(name,val);
    }

    @ReactMethod
    public void putBoolean(String name,boolean val){
        editor.putBoolean(name,val);
    }

    @ReactMethod
    public void putLong(String name,long val){
        editor.putLong(name,val);
    }

    @ReactMethod
    public void putFloat(String name,float val){
        editor.putFloat(name,val);
    }

    @ReactMethod
    public void getString(String key,String defaultVal, Promise promise){
        if( preferences.contains(key) ){
            String result = preferences.getString(key,defaultVal);
            promise.resolve(result);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void getInt(String key,int defaultVal, Promise promise){
        if( preferences.contains(key) ){
            int result = preferences.getInt(key,defaultVal);
            promise.resolve(result);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void getFloat(String key,float defaultVal, Promise promise){
        if( preferences.contains(key) ){
            float result = preferences.getFloat(key,defaultVal);
            promise.resolve(result);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void getBoolean(String key,boolean defaultVal, Promise promise){
        if( preferences.contains(key) ){
            boolean result = preferences.getBoolean(key,defaultVal);
            promise.resolve(result);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void getLong(String key,long defaultVal, Promise promise){
        if( preferences.contains(key) ){
            long result = preferences.getLong(key,defaultVal);
            promise.resolve(result);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void contains(String key, Promise promise){
        if( preferences.contains(key) ){
            promise.resolve(true);
        }else{
            promise.reject("0","key not exists");
        }
    }

    @ReactMethod
    public void commit(){
        editor.commit();
    }

    @ReactMethod
    public void remove(String key){
        editor.remove(key);
    }

    @ReactMethod
    public void clear(){
        editor.clear();
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("MODE_PRIVATE", Context.MODE_PRIVATE);
        constants.put("MODE_WORLD_READABLE", Context.MODE_WORLD_READABLE);
        constants.put("MODE_WORLD_WRITEABLE", Context.MODE_WORLD_WRITEABLE);
        return constants;
    }

}