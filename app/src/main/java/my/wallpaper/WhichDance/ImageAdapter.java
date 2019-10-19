package my.wallpaper.WhichDance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by samia on 05/10/2017.
 */

public class ImageAdapter extends BaseAdapter {
    int[] idImg = {R.drawable.ballerine, R.drawable.pointesrose, R.drawable.pointesrouge, R.drawable.pointesrose, R.drawable.pointesrouge, R.drawable.ballerine};
    int[] idImg1 = {R.drawable.salsa, R.drawable.chacha, R.drawable.ballerine, R.drawable.pointesrose, R.drawable.salsa, R.drawable.ballerine};

    private Context theContext;
    public  int[] imagesIds;

    public ImageAdapter(Context c){
        theContext = c;
    }

    public ImageAdapter(Context c, int[] img){
        theContext = c;
        imagesIds = img;
    }

    @Override
    public int getCount() {
        return imagesIds.length;
    }

    @Override
    public Object getItem(int position) {
        return imagesIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(theContext);
        imageView.setImageResource(imagesIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int size = theContext.getResources().getDimensionPixelSize(R.dimen.gridview);
        imageView.setLayoutParams(new GridView.LayoutParams(size, size));
        //imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
        return imageView;
    }

}
