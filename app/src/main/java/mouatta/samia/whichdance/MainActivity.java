package mouatta.samia.whichdance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    GridView grid;
    String[] list = {
            "Ballet", "Ice", "Salsa", "Chacha", "Valse", "Flamenco"
    };
    //C:\Users\samia\Pictures\Application de danse
    int[] idImg = {R.drawable.ballet, R.drawable.ice, R.drawable.salsa, R.drawable.chacha, R.drawable.valse, R.drawable.flamenco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){

            case R.id.action_settings :
                //tutoriel d'application
                Toast.makeText(getApplicationContext(),
                        "A PROPOS...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.share :
                //tutoriel d'application
                Toast.makeText(getApplicationContext(),
                        "SHARE...",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
            Toast.makeText(getApplicationContext(),
                    "Unknown...",
                    Toast.LENGTH_SHORT).show();
            break;

        }
        //Return false to allow normal menu processing to proceed,
        //true to consume it here.
        return false;
    }*/

}
