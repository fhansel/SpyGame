package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;


public class ManageFriends extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setContentView(R.layout.manage_friends);
	  
	  String[] friends = {"John","Andy","Mary"};
	  String[] autocompleteFriends = {"David", "Darcy"};
	  
	  final AutoCompleteTextView autocomplete= (AutoCompleteTextView) findViewById(R.id.autocomplete_friends);
	  final Intent in = new Intent().setClass(ManageFriends.this, InteractFriends.class);
	  final ListView friendsList = (ListView)findViewById(R.id.friendsList);
	  
	  ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<String>(this, R.layout.autocomplete_list_item, autocompleteFriends);
	  autocomplete.setAdapter(autocompleteAdapter);
	  
	
	  ArrayAdapter<String> friendsListAdapter = new ArrayAdapter<String>(this, R.layout.normal_list_item, friends);	 
	  friendsList.setAdapter(friendsListAdapter);
	  

	  friendsList.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    
	    	in.putExtra("friend_name", ((TextView) view).getText());
	    	startActivity(in);
	    /*
	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	          Toast.LENGTH_SHORT).show();*/
	    }
	  });
	  
	  Button btnGo = (Button) findViewById(R.id.btnGo);
	  btnGo.setOnClickListener(new OnClickListener(){
		 public void onClick(View v){
		    	in.putExtra("friend_name", autocomplete.getText().toString());
		    	startActivity(in);
		 }
	  });
	  
	}
	

}
