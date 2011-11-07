package cs.onesixty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class InteractFriends extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.intefactfriends);
		
		Bundle extra = getIntent().getExtras();
		if (extra !=null){	
			TextView interactFriendsLabel = (TextView) findViewById(R.id.interactFriendsLabel);
			interactFriendsLabel.setText("Interact with " + extra.getString("friend_name"));
		}
	}
}
