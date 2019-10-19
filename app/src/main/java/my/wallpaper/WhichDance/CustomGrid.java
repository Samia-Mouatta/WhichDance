package my.wallpaper.WhichDance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by samia on 29/09/2017.
 */

public class CustomGrid extends BaseAdapter {

    private Context theContext;
    private final String[] list;
    private final int[] img_id;

    public CustomGrid(Context c, String[] l,int[] id){
        theContext = c;
        this.list  = l;
        this.img_id = id;
    }

    public int getCount(){
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) theContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            grid = new View(theContext);
            grid = inflater.inflate(R.layout.gridlayout,null);

            ImageView imgV = (ImageView) grid.findViewById(R.id.image);
            //stocker l'image dans le champ image
            imgV.setImageResource(img_id[position]);

            TextView textView = (TextView)grid.findViewById(R.id.text);
            //stocker le texte de l'image dans le champ text
            textView.setText(list[position]);

        }else{
            grid = (View) convertView;
        }
        return grid;
    }
}
