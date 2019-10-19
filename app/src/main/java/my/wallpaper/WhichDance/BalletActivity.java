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

public class BalletActivity extends AppCompatActivity {

    GridView gridView;
//    public static int[] idImg = {R.drawable.ballet1, R.drawable.ballet2, R.drawable.ballet3, R.drawable.ballet4, R.drawable.ballet5, R.drawable.ballet6, R.drawable.ballet7, R.drawable.ballet8, R.drawable.ballet9, R.drawable.ballet10, R.drawable.ballet11, R.drawable.ballet12, R.drawable.ballet13, R.drawable.ballet14, R.drawable.ballet15};
    public static int[] idImg = {R.drawable.ballet1, R.drawable.ballet2, R.drawable.ballet3, R.drawable.ballet4, R.drawable.ballet5, R.drawable.ballet6, R.drawable.ballet7, R.drawable.ballet8, R.drawable.ballet9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);



        gridView = (GridView) findViewById(R.id.ballet_grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(BalletActivity.this,idImg));

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

                Intent intent = new Intent(BalletActivity.this,FullImageActivity.class);
                intent.putExtra("imgPos",position);
                intent.putExtra("actName",BalletActivity.class.getSimpleName());
                startActivity(intent);
            }
        });

            // back button
           /* getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }





}

