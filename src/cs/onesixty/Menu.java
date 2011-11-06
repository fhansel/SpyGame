package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Menu extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        //setContentView(R.layout.main);
        
        Intent in = new Intent().setClass(Menu.this, ManageFriends.class);
        startActivity(in);
=======
        setContentView(R.layout.main);
       Button btnManageMissions = (Button)this.findViewById(R.id.button1);
       Button btnManageFriends = (Button)this.findViewById(R.id.button2);
       Button btnHighScores = (Button)this.findViewById(R.id.button3);
       
       
>>>>>>> f1aa3a211e7adb9040155194025cd833a8b4e4c5
    }
}