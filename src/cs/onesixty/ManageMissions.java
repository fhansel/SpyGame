package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageMissions extends Activity {
	Button b_new_mission, b_deferred_mission;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_missions);
        b_new_mission = (Button) findViewById(R.id.b_new_mission);
        b_deferred_mission = (Button) findViewById(R.id.b_deferred_mission);
		b_new_mission.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), NewMission.class);
				startActivityForResult(intent, 0);
			}
		});
		b_deferred_mission.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), DeferredMissions.class);
				startActivityForResult(intent, 0);
			}
		});
    }
}