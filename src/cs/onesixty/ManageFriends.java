package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class ManageFriends extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setContentView(R.layout.manage_friends);
	  
	  Button btnMyFriends = (Button)this.findViewById(R.id.btnMyFriends);
	  Button btnFindFriends = (Button)this.findViewById(R.id.btnFindFriends);
	  
	  btnMyFriends.setOnClickListener(new OnClickListener(){
		 public void onClick(View v){
			 Intent in = new Intent().setClass(ManageFriends.this, MyFriends.class);
			 startActivity(in);
		 }
	  });
	  
	  btnFindFriends.setOnClickListener(new OnClickListener(){
		  public void onClick(View v){
			  Intent in = new Intent().setClass(ManageFriends.this, FindFriends.class);
			  startActivity(in);
		  }
	  });
	 
	}
}
