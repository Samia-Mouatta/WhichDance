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

public class SalsaActivity extends AppCompatActivity{

    Button btn;
    GridView gridView;
    ImageView imageView;
    public int[] idImg = {R.drawable.salsa, R.drawable.chacha, R.drawable.ballerine, R.drawable.pointesrose, R.drawable.salsa, R.drawable.ballerine};
    private FloatingActionMenu fabMenu;
    private FloatingActionButton fabShare,fabSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        gridView = (GridView) findViewById(R.id.ballet_grid_view);
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(SalsaActivity.this,idImg));

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {

                setContentView(R.layout.full_image);

                imageView = (ImageView) findViewById(R.id.full_image_view);
                imageView.setImageResource(idImg[position]);
                fabMenu = (FloatingActionMenu) findViewById(R.id.fab_menu);
                fabSave = (FloatingActionButton) findViewById(R.id.fab_save);
                fabSave.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        saveImage();
                    }
                });
                fabShare = (FloatingActionButton) findViewById(R.id.fab_share);
                fabShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bitmap = convertViewToBitmap(imageView,imageView.getWidth(),imageView.getHeight());
                        sharePicture(bitmap,getApplicationContext());
                        Toast.makeText(SalsaActivity.this, "Souhaitez-vous partager cette image?", Toast.LENGTH_SHORT).show();
                    }
                });
/*                btn = (Button) findViewById(R.id.btnSave);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveImage();
                    }
                });*/
            }
        });

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

    //save imageView
    public void saveImage(){
        FileOutputStream fileOutputStream = null;
        File file = getDirc();

        // verifier si le fichier ou dossier existe
        if(!file.exists() && !file.mkdirs()){
            Toast.makeText(this,"Impossible de créer un répertoire",Toast.LENGTH_SHORT).show();
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = simpleDateFormat.format(new Date());
        String photofile = "Img" + date + ".jpg";
        String file_name = file.getPath() + "/" + photofile;
        File picfile = new File(file_name);
        try {
            fileOutputStream = new FileOutputStream(picfile);
            Bitmap bitmap = convertViewToBitmap(imageView,imageView.getWidth(),imageView.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            Toast.makeText(getApplicationContext(), "Sauvegarde réussie", Toast.LENGTH_SHORT).show();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        MajGallery(picfile);
    }

    //convert imageview to bitmap
    public static Bitmap convertViewToBitmap(View view, int width, int height){
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    //update gallery
    public void MajGallery(File file) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        sendBroadcast(intent);
    }

    //create a new folder in DCIM Directory
    public File getDirc() {
        File dics = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(dics, " Which_Dance_Salse_Folder");
    }

    public void sharePicture(Bitmap bmp, Context context) {

        String sImageUrl = MediaStore.Images.Media.insertImage(context.getContentResolver(), bmp, "title" , "description");
        Uri savedImageURI = Uri.parse(sImageUrl);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        share.putExtra(Intent.EXTRA_STREAM, savedImageURI);

        startActivity(Intent.createChooser(share, "Share Image!"));
    }
}