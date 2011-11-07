package cs.onesixty;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class MyFriends extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  String[] friends = {"John", "Mary", "Andy"};
	  setListAdapter(new ArrayAdapter<String>(this, R.layout.myfriends, friends));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	Intent in = new Intent().setClass(MyFriends.this, InteractFriends.class);
	    	in.putExtra("friend_name", ((TextView) view).getText());
	    	startActivity(in);
	    /*
	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
	          Toast.LENGTH_SHORT).show();*/
	    }
	  });
	}
}
