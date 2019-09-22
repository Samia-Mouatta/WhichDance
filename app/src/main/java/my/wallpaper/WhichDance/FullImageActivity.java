package my.app.WhichDance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by samia on 06/10/2017.
 */

public class FullImageActivity extends AppCompatActivity {

    //public static Stack<Class<?>> parents = new Stack<Class<?>>();
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.full_image);



            // back button
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                Intent parentActivityIntent = new Intent(this, parents.pop());
//                parentActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(parentActivityIntent);
//                finish();
//                Intent intent = getIntent();
//                intent.getStringExtra("PreviousActivity");
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
