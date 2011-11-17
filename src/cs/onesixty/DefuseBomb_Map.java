package cs.onesixty;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class DefuseBomb_Map extends MapActivity
{
		/** Called when the activity is first created. */
		ImageButton clock;
		private View.OnTouchListener touchListener;
	    ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	    MyItemizedOverlay itemizedOverlay;
		MyItemizedOverlay itemizedOverlay2;
		Double lat, lon;
		Drawable drawable, drawable2;
		GeoPoint point, point2;
		OverlayItem overlayItem, overlayItem2;
		
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

//zzz		    mapView.setSatellite(true);	// option for satellite images
		    
		    List<Overlay> mapOverlays = mapView.getOverlays();
		    
			drawable = getResources().getDrawable(R.drawable.marker);
			itemizedOverlay = new MyItemizedOverlay(drawable, mapView);
		
			lat = Menu.lat;
			lon = Menu.lon;
			point = new GeoPoint((int)(lat*1E6),(int)(lon*1E6));
			overlayItem = new OverlayItem(point, "You", "Here you are");
			itemizedOverlay.addOverlay(overlayItem);
			
			mapOverlays.add(itemizedOverlay);
			
			// second overlay
			drawable2 = getResources().getDrawable(R.drawable.marker2);
			itemizedOverlay2 = new MyItemizedOverlay(drawable2, mapView);
			
			lat = Menu.lat + 1;	// put bomb location here
			lon = Menu.lon + 1;
			point2 = new GeoPoint((int)(lat*1E6),(int)(lon*1E6));
			overlayItem2 = new OverlayItem(point2, "Bomb Location", "destroy this bomb!"); 
			itemizedOverlay2.addOverlay(overlayItem2);
			
			mapOverlays.add(itemizedOverlay2);
			
			final MapController mc = mapView.getController();
			mc.animateTo(point);
			mc.setZoom(16);
			
		    
		    
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
