/**
 * 
 */
package at.karmel.karmelexerzitien;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * @author 
 *
 */
public class ContentViewActivity extends ActionBarActivity {

	/**
	 * 
	 */
	public static final String URL = "url";
	
	private WebView webview;
	private String url;
	
	public ContentViewActivity() {
		// TODO Auto-generated constructor stub
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    Bundle extras = getIntent().getExtras();
	    if(extras != null) {
	    	url = extras.getString(URL);
	    }
	    
	    webview = new WebView(this);
	    setContentView(webview);
	    webview.loadUrl(url);
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

}
