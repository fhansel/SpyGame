package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {
	Button b_new_mission, b_deferred_mission;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button btnManageMissions = (Button)this.findViewById(R.id.b_main_1);
		Button btnManageFriends = (Button)this.findViewById(R.id.b_main_2);
		Button btnHighScores = (Button)this.findViewById(R.id.b_main_3);
		
		btnManageMissions.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ManageMissions.class);
				startActivityForResult(intent, 0);
			}
		});
		btnManageFriends.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ManageFriends.class);
				startActivityForResult(intent, 0);
			}
        });
		btnHighScores.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), HighScores.class);
				startActivityForResult(intent, 0);
			}
        });
	}
}
