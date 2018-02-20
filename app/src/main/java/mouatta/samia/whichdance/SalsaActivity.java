package mouatta.samia.whichdance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

/**
 * Created by samia on 02/10/2017.
 */

public class SalsaActivity extends BaseActivity{
    public int[] idImg = {R.drawable.salsa, R.drawable.chacha, R.drawable.ballerine, R.drawable.pointesrose, R.drawable.salsa, R.drawable.ballerine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        GridView gridView = (GridView) findViewById(R.id.ballet_grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(SalsaActivity.this,idImg));
        // back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
