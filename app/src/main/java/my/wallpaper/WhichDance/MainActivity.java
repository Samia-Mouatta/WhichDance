package my.wallpaper.WhichDance;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView grid;
    String[] list = {
            "Ballet", "Ice", "Salsa", "Chacha", "Valse", "Flamenco"
    };
    int[] idImg = {R.drawable.ballet, R.drawable.ice, R.drawable.salsa, R.drawable.chacha, R.drawable.valse, R.drawable.flamenco};
    private static final int REQUEST_CODE_PERMISSION = 2;
    String[] mPermission = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission[0])
                    != MockPackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(this, mPermission[1])
                            != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        mPermission, REQUEST_CODE_PERMISSION);

                // If any permission aboe not allowed by user, this condition will execute every tim, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CustomGrid adapter = new CustomGrid(MainActivity.this, list, idImg);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Quand click, ouvrir la page de list[position]
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), BalletActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), IceActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), SalsaActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), ChachaActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), ValseActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), FlamencoActivity.class));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "You Clicked at " +list[+ position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.action_about :
                //start about activity
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.action_help :
                //start help activity
                startActivity(new Intent(this, HelpActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
