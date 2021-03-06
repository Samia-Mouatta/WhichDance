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
 * Created by samia on 06/10/2017.
 */

public class FullImageActivity extends AppCompatActivity {
    ImageView imageView;
    private FloatingActionMenu fabMenu;
    private FloatingActionButton fabShare,fabSave;
    String Dvalue;
    int posActivity;

    //public static Stack<Class<?>> parents = new Stack<Class<?>>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        int position = getIntent().getExtras().getInt("imgPos");
        String name = getIntent().getExtras().getString("actName");
        System.out.println("actName = " + name);
        imageView = (ImageView) findViewById(R.id.full_image_view);

        if (name.equals("BalletActivity")) {
            imageView.setImageResource(BalletActivity.idImg[position]);
        } else if (name.equals("IceActivity")) {
            imageView.setImageResource(IceActivity.idImg[position]);
        } else if (name.equals("SalsaActivity")) {
            imageView.setImageResource(SalsaActivity.idImg[position]);
        } else if (name.equals("ChachaActivity")) {
            imageView.setImageResource(ChachaActivity.idImg[position]);
        } else if (name.equals("ValseActivity")) {
            imageView.setImageResource(ValseActivity.idImg[position]);
        } else if (name.equals("FlamencoActivity")) {
            imageView.setImageResource(FlamencoActivity.idImg[position]);
        }

        posActivity = name.indexOf("Activity");
        Dvalue = name.substring(0, posActivity);

        fabMenu = (FloatingActionMenu) findViewById(R.id.fab_menu);

        fabSave = (FloatingActionButton) findViewById(R.id.fab_save);
        fabSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                saveImage(Dvalue);
            }
        });

        fabShare = (FloatingActionButton) findViewById(R.id.fab_share);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = convertViewToBitmap(imageView,imageView.getWidth(),imageView.getHeight());
                sharePicture(bitmap,getApplicationContext());
                Toast.makeText(getApplicationContext(), "Souhaitez-vous partager cette image?", Toast.LENGTH_SHORT).show();
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

    public void saveImage(String dirName) {
        FileOutputStream fileOutputStream = null;
        File file = getDirc(dirName);

        // verifier si le fichier ou dossier existe
        if (!file.exists() && !file.mkdirs()) {
            Toast.makeText(this, "Impossible de créer un répertoire", Toast.LENGTH_SHORT).show();
            return;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = simpleDateFormat.format(new Date());
        String photofile = "Img" + date + ".jpg";
        String file_name = file.getPath() + "/" + photofile;
        File picfile = new File(file_name);
        try {
            fileOutputStream = new FileOutputStream(picfile);
            Bitmap bitmap = convertViewToBitmap(imageView, imageView.getWidth(), imageView.getHeight());
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
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
    public static Bitmap convertViewToBitmap(View view, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
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
    public File getDirc(String DValue) {
        File dics = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return new File(dics, " Which_Dance_"+DValue+"_Folder");
    }

    public void sharePicture(Bitmap bmp, Context context) {

        String sImageUrl = MediaStore.Images.Media.insertImage(context.getContentResolver(), bmp, "title", "description");
        Uri savedImageURI = Uri.parse(sImageUrl);

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/*");
        share.putExtra(Intent.EXTRA_STREAM, savedImageURI);

        startActivity(Intent.createChooser(share, "Share Image!"));
    }

}