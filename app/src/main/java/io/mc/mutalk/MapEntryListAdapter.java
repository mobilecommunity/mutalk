package io.mc.mutalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

public class MapEntryListAdapter extends ArrayAdapter<Map.Entry<Integer, MusicPost>>
{
    public MapEntryListAdapter(Context context, List<Map.Entry<Integer, MusicPost>> entryList)
    {
        super(context, android.R.layout.simple_list_item_2, entryList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View currentItemView = convertView != null ? convertView :
                LayoutInflater.from(getContext()).inflate (
                        android.R.layout.simple_list_item_2, parent, false);

        Map.Entry<Integer, MusicPost> currentEntry = this.getItem(position);

        TextView textViewKey = currentItemView.findViewById(android.R.id.text1);
        TextView textViewValue = currentItemView.findViewById(android.R.id.text2);

        textViewKey.setText(currentEntry.getValue().getTitle());
        textViewValue.setText("by " + currentEntry.getValue().getAuthor());

        return currentItemView;
    }
}