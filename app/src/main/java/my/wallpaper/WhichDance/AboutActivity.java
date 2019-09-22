package my.wallpaper.WhichDance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by samia on 22/09/2019.
 */

public class AboutActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        imageView = (ImageView) findViewById(R.id.aboutImgView);
        textView = (TextView) findViewById(R.id.aboutTextView);


    }

}
