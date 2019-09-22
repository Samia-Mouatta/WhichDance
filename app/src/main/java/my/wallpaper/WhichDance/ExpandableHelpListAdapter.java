package my.wallpaper.WhichDance;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by samia on 21/09/2019.
 */

public class ExpandableHelpListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> mParentItem;
    private HashMap<String, List<String>> mChildItem;

    TextView listTitleTextView,itemTextView;

    public ExpandableHelpListAdapter(Context context, List<String> ParentItem,
                                 HashMap<String, List<String>> ChildItem) {
        this.context = context;
        this.mParentItem = ParentItem;
        this.mChildItem = ChildItem;
    }


    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> ParentItem = new HashMap<String, List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("Application pour télécharger des photos de danse, les partager avec votre entourage et les mettre en arrière plan de votre téléphone. ");

        List<String> list2 = new ArrayList<String>();
        list2.add("L'application est gratuite.");

        List<String> list3 = new ArrayList<String>();
        list3.add("Pour les passionné(e)s de la danse. Mais également pour les autres. ");

        List<String> list4 = new ArrayList<String>();
        list4.add("En cas de problème technique ou pour plus d'aide envoyer un mail à l'adresse toto@gmail.com.");
        list4.add("Première version de l'application.");

        ParentItem.put("Qu'est-ce que l'application mobile WhichDance ?",list1);
        ParentItem.put("L'application est-elle gratuite ?",list2);
        ParentItem.put("Qui peut utiliser l'application ?",list3);
        ParentItem.put("Plus d'informations", list4);

        return ParentItem;

    }

    @Override
    public int getGroupCount() {
        return this.mParentItem.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.mChildItem.get(this.mParentItem.get(i))
                .size();
    }

    @Override
    public Object getGroup(int i) {
        return this.mParentItem.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.mChildItem.get(this.mParentItem.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View actualView = view;
        String listTitle = (String) getGroup(i);
        if (actualView == null) {
            LayoutInflater
                    layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            actualView = layoutInflater.inflate(R.layout.list_group_help, viewGroup, false);
        }

        listTitleTextView = (TextView) actualView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        return actualView;
    }


    @Override
    public View getChildView(int i, int i1, boolean b,View view,ViewGroup viewGroup) {
        View actualView = view;
        String expandedListText = (String) getChild(i,i1);
        if (actualView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            actualView = layoutInflater.inflate(R.layout.list_item_help, viewGroup,false);
        }
        itemTextView = (TextView) actualView.findViewById(R.id.expandedListItem);
        itemTextView.setText(expandedListText);

        return actualView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
