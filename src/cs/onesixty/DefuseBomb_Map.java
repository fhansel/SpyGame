package cs.onesixty;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DefuseBomb_Map extends MapActivity
{
		/** Called when the activity is first created. */
		ImageButton clock;
		private View.OnTouchListener touchListener;
	    ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
		
		// Listen for results.
		protected void onActivityResult(int requestCode, int resultCode, Intent data){
			try
			{
				if (resultCode == RESULT_OK)
				{
					switch (requestCode)
				    {
		    		case 666:
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
/*		
		public HelloItemizedOverlay(Drawable defaultMarker)
		{
			  super(boundCenterBottom(defaultMarker));
			  
			}
		
		public void addOverlay(OverlayItem overlay) {
		    mOverlays.add(overlay);
		    populate();
		}
*/		
		public void dobombgame()
		{
			Log.d("spygame", "made it");
	        String url = "http://www.funny-games.biz/defuse_bomb.html";  
	        Intent i = new Intent(Intent.ACTION_VIEW);  
	        i.setData(Uri.parse(url));  
	        startActivity(i);
//			Intent intent = new Intent(this,bombgame.class);
//			Log.d("spygame", "dbg1");
//			startActivityForResult(intent, 666);
			Log.d("spygame", "dbg2");
		}
		
		
	    @Override
	    public void onCreate(Bundle savedInstanceState)
	    {
			Log.d("spygame", "dbm3");
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.map);
			Log.d("spygame", "dbm4");

	    
		    MapView mapView = (MapView) findViewById(R.id.mapview);
		    mapView.setBuiltInZoomControls(true);
		    
//		    List<Overlay> mapOverlays = mapView.getOverlays();
		    List<Overlay> mapOverlays = mapView.getOverlays();
		    
		    Drawable drawable = this.getResources().getDrawable(R.drawable.icon);

//		    HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable);		    
//zzz need code here
		    
		    touchListener = new View.OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					if (v == clock)
					{
						if (event.getAction() == MotionEvent.ACTION_UP)
						{
							dobombgame();
						}
					}
					return false;
				}
		    };
		    
		    clock = (ImageButton)findViewById(R.id.imageButton1);
	        clock.setOnTouchListener(touchListener);
	    }

	    @Override
	    protected boolean isRouteDisplayed() {
	        return false;
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
