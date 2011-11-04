package cs.onesixty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Menu extends Activity {
	Button b_new_mission, b_deferred_mission;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.main);
       Button btnManageMissions = (Button)this.findViewById(R.id.button1);
       Button btnManageFriends = (Button)this.findViewById(R.id.button2);
       Button btnHighScores = (Button)this.findViewById(R.id.button3);
    }
}