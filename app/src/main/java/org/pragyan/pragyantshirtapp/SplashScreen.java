package org.pragyan.pragyantshirtapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Utilities.init();
        Utilities.prefs = getSharedPreferences("check_" + "status", 0);
        Utilities.status = Utilities.prefs.getInt("status", 0);
        if(Utilities.status!=0)
        {
            Utilities.username = Utilities.prefs.getString("user_name","User");
            Utilities.password = Utilities.prefs.getString("user_pass","Password");
        }
        Intent i;
        switch(Utilities.status)
        {
            case 0:i=new Intent(this,LoginActivity.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this,Coupon.class);
                startActivity(i);
                break;
            default:
                i = new Intent(this,WelcomePage.class);
                startActivity(i);
                break;
        }
        finish();
    }
}
