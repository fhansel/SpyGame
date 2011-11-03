package cs.onesixty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class FindFriends extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.findfriends);
	    
	    String[] friends = {"John","Andy","Mary"};

	    AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_friends);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.autocomplete_list_item, friends);
	    textView.setAdapter(adapter);
	}
}
