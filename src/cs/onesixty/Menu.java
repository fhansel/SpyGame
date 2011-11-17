package cs.onesixty;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {
	Button b_new_mission, b_deferred_mission;
	LocationManager locationManager;
	LocationListener locationListener;
	String locationstring;
	public static double lat, lon; 
	private Handler heartbeatHandler = new Handler();
	int	heartbeattime = 30000;				// milliseconds between heartbeats
	int messagenumber = 0;
	String messages[] = {"Disarm a Bomb", "Camouflage Pactice", "Meet A Contact"};
	NotificationManager notificationManager = null;	
	Notification notification;
	Intent notificationIntent;
	PendingIntent pendingIntent;
	Intent notificationIntent2;
	Notification notification2;
	PendingIntent pendingIntent2;
	
	// heartbeat timer routine
	private Runnable heartbeatTask = new Runnable()
	{
		   public void run()
		   {
			   try
			   {
					Log.d("spygame", "Got Heartbeat");
					if (messagenumber == 0)
					{
						notificationIntent2 = new Intent(getApplication(), NewMission.class);
						pendingIntent2 = PendingIntent.getActivity(getApplication(), 0, notificationIntent2, 0);
					}
					else
					{
						notificationIntent2 = new Intent(getApplication(), Menu.class);
						pendingIntent2 = PendingIntent.getActivity(getApplication(), 0, notificationIntent2, 0);
					}
					
					notification2.tickerText = "New Mission: " + messages[messagenumber];
					notification2.setLatestEventInfo(getApplicationContext(), "New Mission", messages[messagenumber], pendingIntent2);
					notification2.defaults |= Notification.DEFAULT_VIBRATE;
					notification2.defaults |= Notification.DEFAULT_LIGHTS;
					notification2.defaults |= Notification.DEFAULT_SOUND;
					notification2.flags = Notification.FLAG_AUTO_CANCEL;
					notificationManager.notify(2, notification2);
					messagenumber++;
					if (messagenumber > messages.length - 1)
						messagenumber = 0;
			   }
			   catch (Exception e)
			   {
					Log.d("spygame", "heartbeat failed: " + e.toString());
			   }
				heartbeatHandler.removeCallbacks(heartbeatTask);
				heartbeatHandler.postDelayed(heartbeatTask, heartbeattime);
		   }
	};	

	
	
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

	
		// Acquire a reference to the system Location Manager
		lat = 0;
		lon = 0;
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		if (locationManager == null)
		{
			lat = 0;
			lon = 0;
			Log.d("spygame", "no location");
		}
		else
		{
			Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (lastKnownLocation == null)
			{
				lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			}
			
			if (lastKnownLocation == null)
			{
				lat = 0;
				lon = 0;
				Log.d("spygame", "no last known location");
			}
			else
			{
				lat = lastKnownLocation.getLatitude();
				lon = lastKnownLocation.getLongitude();
			}
		}

		// Define a listener that responds to location updates
		locationListener = new LocationListener()
		{
			public void onLocationChanged(Location location)
			{
				lat = location.getLatitude();
				lon = location.getLongitude();
				Log.d("spygame", "location is Lat:" + lat + " lon:" + lon);
			}

			public void onStatusChanged(String provider, int status, Bundle extras)
			{
			}

			public void onProviderEnabled(String provider)
			{
			}

			public void onProviderDisabled(String provider)
			{
			}
		};

		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 100, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 100, locationListener);

		Log.d("spygame", "location is Lat:" + lat + " lon:" + lon);
	
		heartbeatHandler.removeCallbacks(heartbeatTask);
		heartbeatHandler.postDelayed(heartbeatTask, heartbeattime);
		
    	notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);	
		
    	notification2 = new Notification(R.drawable.icon, "Spygame", System.currentTimeMillis());
		notificationIntent2 = new Intent(this, Menu.class);
		pendingIntent2 = PendingIntent.getActivity(this, 0, notificationIntent2, 0);
		notification2.tickerText = "Spygame";
		notification2.setLatestEventInfo(this, "Spygame", "Started", pendingIntent2);
		notification2.defaults |= Notification.DEFAULT_SOUND;
		notification2.defaults |= Notification.DEFAULT_VIBRATE;
		notification2.defaults |= Notification.DEFAULT_LIGHTS;
		notification2.flags = Notification.FLAG_AUTO_CANCEL;
//		notificationManager.notify(2, notification2);
	}

	@Override
	public void onDestroy()
	{
    	super.onDestroy();
		try
		{
			if (notificationManager != null)
				notificationManager.cancel(2);
			
			heartbeatHandler.removeCallbacks(heartbeatTask);
			locationManager.removeUpdates(locationListener);
		}
		catch (Exception e)
		{
		}
	}
}
