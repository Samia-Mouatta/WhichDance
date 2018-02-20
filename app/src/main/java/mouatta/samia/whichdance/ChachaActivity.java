package mouatta.samia.whichdance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

/**
 * Created by samia on 02/10/2017.
 */

public class ChachaActivity extends AppCompatActivity {
    public int[] idImg = {R.drawable.salsa, R.drawable.chacha, R.drawable.ballerine, R.drawable.pointesrose, R.drawable.salsa, R.drawable.ballerine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        // GridView
        GridView gridView = (GridView) findViewById(R.id.ballet_grid_view);
        gridView.setAdapter(new ImageAdapter(ChachaActivity.this,idImg));
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
