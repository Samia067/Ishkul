package com.example.isshkul.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.isshkul.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter{
	private Context mContext;
	 
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;

    public FileAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);

        items.add(new Item("slide1.ppt", R.drawable.file));
        items.add(new Item("sample.jpg", R.drawable.image));
        items.add(new Item("problems.doc", R.drawable.file));
        items.add(new Item("slide2.pptx", R.drawable.file));
        items.add(new Item("Image.jpg", R.drawable.image));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i)
    {
        return items.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null)
        {
           v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
           v.setTag(R.id.picture, v.findViewById(R.id.picture));
           v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private class Item
    {
        final String name;
        final int drawableId;

        Item(String name, int drawableId)
        {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}


