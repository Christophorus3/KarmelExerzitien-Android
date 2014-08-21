/**
 * 
 */
package at.karmel.karmelexerzitien;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * @author chris
 *
 */
public class AboutActivity extends ActionBarActivity {

	/**
	 * 
	 */
	public AboutActivity() {
		// TODO Auto-generated constructor stub
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_about);
	    
	    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	public void showEdithVita(View view) {
		
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.edith-stein-gesellschaft.at/Edith-Stein-Gesellschaft/Lebensdaten"));
		
		startActivity(intent);
	}

	public void showESGOEWebsite(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.edith-stein-gesellschaft.at/"));
		
		startActivity(intent);
	}
	
	public void showKarmelWebsite(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://wien.karmel.at"));
		
		startActivity(intent);
	}
	
	public void showMarienschwesternWebsite(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.marienschwestern.at"));
		
		startActivity(intent);
	}
	
	public void showFacebook(View view) {
		try {
		    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/482656151779152"));
		    startActivity(intent);
		} catch(Exception e) {
		    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/karmeliten.wien")));
		}
	}
	
	public void showPixelio(View view) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.pixelio.de"));
		
		startActivity(intent);
	}
	
	public void sendMail(View view) {
		/*Intent data = new Intent();
		
		data.setAction(android.content.Intent.ACTION_SEND);
		data.setType("message/rfc822");
		data.putExtra(Intent.EXTRA_EMAIL, new String[] {"online-exerzitien@karmel.at"});
		data.putExtra(Intent.EXTRA_SUBJECT, "KarmelExerzitien Android App");
		data.putExtra(Intent.EXTRA_TEXT, "");
		
		startActivity(data);
		*/
		
		Intent email = new Intent(Intent.ACTION_SEND);
	    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"youremail@yahoo.com"});          
	    email.putExtra(Intent.EXTRA_SUBJECT, "subject");
	    email.putExtra(Intent.EXTRA_TEXT, "message");
	    email.setType("message/rfc822");
	    startActivity(Intent.createChooser(email, "Choose an Email client :"));
	}
}
