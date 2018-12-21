package ggps.shubham.newsfinal;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private  static Context mcontext;
    private static  final String SHARED_PREF_NAME="demo";
    private static  final String KEY_ACCESS_TOKEN="demo";
    private static  SharedPrefManager msharedPrefManager;

    private SharedPrefManager(Context context){
    mcontext=context;
}

    public static synchronized SharedPrefManager getInstance(Context context){
if(msharedPrefManager == null)
    msharedPrefManager=new SharedPrefManager(context);
return  msharedPrefManager;
}

    public boolean storeToken(String Token){
    SharedPreferences sharedPreferences=mcontext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
    editor.putString(KEY_ACCESS_TOKEN,Token);
    editor.apply();
    return true;
}

    public String getToken(){
    SharedPreferences sharedPreferences=mcontext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    return sharedPreferences.getString(KEY_ACCESS_TOKEN,null);

}

}
