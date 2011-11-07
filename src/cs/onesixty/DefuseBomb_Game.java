package cs.onesixty;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class DefuseBomb_Game extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bombgame);
        
        String url = "http://www.proprofs.com/games/jigsaw/bomb-defuse/";  
        Intent i = new Intent(Intent.ACTION_VIEW);  
        i.setData(Uri.parse(url));  
        startActivity(i);
	}

}
