package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NewMission extends Activity {
	Button b_mission1, b_mission2, b_mission3;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.missions);
        b_mission1 = (Button) findViewById(R.id.b_mission1);
        b_mission1.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), null);
				startActivityForResult(intent, 0);
			}
        });
        b_mission2 = (Button) findViewById(R.id.b_mission2);
        b_mission2.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), null);
				startActivityForResult(intent, 0);
			}
        });
        b_mission3 = (Button) findViewById(R.id.b_mission3);
        b_mission3.setOnClickListener(new OnClickListener(){
        	@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), MeetContact.class);
				startActivityForResult(intent, 0);
			}
        });
    }
}