package mouatta.samia.whichdance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by samia on 06/10/2017.
 */

public class FullImageActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.full_image);

            // get intent data
           /* Intent i = getIntent();

            // Selected image id
            int position = i.getExtras().getInt("id");
            ImageAdapter imageAdapter = new ImageAdapter(this,imagesIds);

            ImageView imageView = (ImageView) findViewById(R.id.full_image_view);

            imageView.setImageResource(imageAdapter.imagesIds[position]);*/
           // System.out.println("position: "+imageAdapter.imagesIds[position]);
        }
}
