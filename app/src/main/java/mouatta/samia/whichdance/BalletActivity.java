package mouatta.samia.whichdance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by samia on 02/10/2017.
 */

public class BalletActivity extends BaseActivity {


    public int[] idImg = {R.drawable.ballerine, R.drawable.pointesrose, R.drawable.pointesrouge, R.drawable.pointesrose, R.drawable.pointesrouge, R.drawable.ballerine};
    //0,1,2,3,4,5

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

       // Button btn = (Button) findViewById(R.id.btn);
        GridView gridView = (GridView) findViewById(R.id.ballet_grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(BalletActivity.this,idImg));

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //
                // Sending image id to FullScreenActivity
               // Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                /*i.putExtra("id", position);
                startActivity(i);*/
                setContentView(R.layout.full_image);

                ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
                imageView.setImageResource(new ImageAdapter(BalletActivity.this).idImg[position]);
/*                BitmapDrawable draw = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = draw.getBitmap();

                FileOutputStream outStream = null;
             //   File sdCard = Environment.getExternalStorageDirectory();
              //  File dir = new File(sdCard.getAbsolutePath() + "/YourFolderName");
                String tempFilePath = Environment.getExternalStorageDirectory() + "/"
                        + getPackageName() + "/" + "toto" + ".jpg";
               // dir.mkdirs();
               // String fileName = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(tempFilePath);
                try {
                    outStream = new FileOutputStream(outFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
                try {
                    outStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                intent.setData(Uri.fromFile(outFile));
                sendBroadcast(intent);*/
                //Toast.makeText(BalletActivity.this, "You Clicked at " +idImg[+ position], Toast.LENGTH_SHORT).show();
            }
        });

       /* btn.setOnClickListener(new View.OnClickListener(){

                                   @Override
                                   public void onClick(View v) {
                                       Drawable drawable = getResources().getDrawable(R.drawable.ballerine);
                                       Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                                       // Save image to gallery
                                       String savedImageURL = MediaStore.Images.Media.insertImage(
                                               getContentResolver(),
                                               bitmap,
                                               "Bird",
                                               "Image of bird"
                                       );

                                       // Parse the gallery image url to uri
                                       Uri savedImageURI = Uri.parse(savedImageURL);

                                       // Display saved image url to TextView
                                       Toast.makeText(BalletActivity.this,"Image saved to gallery."+savedImageURI, Toast.LENGTH_SHORT).show();
                                   }
        });*/
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

