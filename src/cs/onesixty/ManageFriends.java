package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class ManageFriends extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setContentView(R.layout.manage_friends);
	  
	  String[] friends = {"John","Andy","Mary"};

	  AutoCompleteTextView autocomplete= (AutoCompleteTextView) findViewById(R.id.autocomplete_friends);
	  ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<String>(this, R.layout.autocomplete_list_item, friends);
	  autocomplete.setAdapter(autocompleteAdapter);
	  
	  ListView friendsList = (ListView)findViewById(R.id.friendsList);
	  ArrayAdapter<String> friendsListAdapter = new ArrayAdapter<String>(this, R.layout.normal_list_item, friends);	 
	  friendsList.setAdapter(friendsListAdapter);
	  

	  friendsList.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    	Intent in = new Intent().setClass(ManageFriends.this, InteractFriends.class);
	    	in.putExtra("friend_name", ((TextView) view).getText());
	    	startActivity(in);
	    /*
	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	          Toast.LENGTH_SHORT).show();*/
	    }
	  });
	  
	}
}
