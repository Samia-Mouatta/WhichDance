package my.wallpaper.WhichDance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by samia on 21/09/2019.
 */

public class HelpActivity extends AppCompatActivity {


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListGroup;
    HashMap<String, List<String>> expandableListItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListItem = ExpandableHelpListAdapter.getData();
        expandableListGroup = new ArrayList<String>(expandableListItem.keySet());
        expandableListAdapter = new ExpandableHelpListAdapter(this, expandableListGroup, expandableListItem);
        expandableListView.setAdapter(expandableListAdapter);
    }

}
