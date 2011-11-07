package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class DefuseBomb extends Activity {
    /** Called when the activity is first created. */
	Button accept;
	Button reject;
	Button defer;
	private View.OnTouchListener touchListener;

	// Listen for results.
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		try
		{
			if (resultCode == RESULT_OK)
			{
				switch (requestCode)
			    {
	    		case 444:
	    			break;
	    		case 555:
	    			break;
	    		case 666:
	    			String res = data.getStringExtra("myresult");
	    			if (res.equals("WON"))
	    			{
	    				
	    			}
	    			
	    			break;
		        default:
		            break;
			    }
			}
		}
		catch (Exception e)
		{
			Log.d("spygame", "error: " + e.toString());
		}
	}
	
	
	public void dobombmap()
	{
		Intent intent = new Intent(this,DefuseBomb_Map.class);
		Log.d("spygame", "dbm1");
		startActivityForResult(intent, 666);
		Log.d("spygame", "dbm2");
	}
	
	public void dodefer()
	{
		Intent intent = new Intent(this,DefuseBomb_Map.class);
		Log.d("spygame", "dbm1");
//		startActivityForResult(intent, 555);
		Log.d("spygame", "dbm2");
	}
	
	public void doreject()
	{
		Intent intent = new Intent(this,DefuseBomb_Map.class);
		Log.d("spygame", "dbm1");
//		startActivityForResult(intent, 444);
		Log.d("spygame", "dbm2");
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmission);

		touchListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (v == accept)
				{
					if (event.getAction() == MotionEvent.ACTION_UP)
					{
						dobombmap();
					}
				}
				else if (v == reject)
				{
					if (event.getAction() == MotionEvent.ACTION_UP)
					{
						doreject();
					}
				}
				else if (v == defer)
				{
					if (event.getAction() == MotionEvent.ACTION_UP)
					{
						dodefer();
					}
				}
				return false;
			}

		};

        accept = (Button)findViewById(R.id.accept);
        accept.setOnTouchListener(touchListener);

        reject = (Button)findViewById(R.id.reject);
        reject.setOnTouchListener(touchListener);
        defer = (Button)findViewById(R.id.defer);
        defer.setOnTouchListener(touchListener);

    }

    @Override
	public void onDestroy() {
    	super.onDestroy();
    	
		Intent resultIntent = new Intent();			
		resultIntent.putExtra("myresult", "WON");
		setResult(RESULT_OK, resultIntent);	
		finish();
	}
}