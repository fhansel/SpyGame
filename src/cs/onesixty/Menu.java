package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Menu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        Intent in = new Intent().setClass(Menu.this, ManageFriends.class);
        startActivity(in);
    }
}