package cn.edu.hqu.cst.android.chapter3_3;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2018/3/29.
 */

public class AppPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(hasHeaders()){
            Button button=new Button(this);
            button.setText("设置操作");
            setListFooter(button);
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target){
        loadHeadersFromResource(R.xml.preference_headers,target);
    }
    @Override
    public boolean isValidFragment(String fragmentName){
        return true;
    }

    public static class Preference1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
    public static class Preference2Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.displaypreferences);
            String website="http://www.cst.hqu.edu.cn";//getArguments().getString("website");
            Toast.makeText(getActivity(),"网站："+website,Toast.LENGTH_LONG).show();
        }
    }
}
