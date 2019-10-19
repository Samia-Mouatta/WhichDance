package my.wallpaper.WhichDance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by samia on 02/10/2017.
 */

public class IceActivity extends AppCompatActivity {

    GridView gridView;
    public static int[] idImg = {R.drawable.ice_669822, R.drawable.ice_836175_1280, R.drawable.ice_836178_1280, R.drawable.ice_2460812_1280, R.drawable.ice_4529180_1280, R.drawable.ballerine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        // GridView
        gridView = (GridView) findViewById(R.id.ballet_grid_view);
        gridView.setAdapter(new ImageAdapter(IceActivity.this,idImg));

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {

                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + " selected",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(IceActivity.this,FullImageActivity.class);
                intent.putExtra("imgPos",position);
                intent.putExtra("actName",IceActivity.class.getSimpleName());
                startActivity(intent);
            }
        });
        // back button
/*        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }


}
