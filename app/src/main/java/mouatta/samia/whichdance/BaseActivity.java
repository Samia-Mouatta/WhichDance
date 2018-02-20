package mouatta.samia.whichdance;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ShareActionProvider;

/**
 * Created by samia on 06/10/2017.
 */

public class BaseActivity extends ActionBarActivity {
    ShareActionProvider mShare;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

       /* MenuItem menuItem = menu.findItem(R.id.share);
        mShare = (ShareActionProvider)menuItem.getActionProvider();*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.action_settings :
                //tutoriel d'application
                Toast.makeText(getApplicationContext(),
                        "A PROPOS...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.share :
                //tutoriel d'application
                Toast.makeText(getApplicationContext(),
                        "SHARE...",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "Unknown...",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        //Return false to allow normal menu processing to proceed,
        //true to consume it here.
        return false;
    }
}
