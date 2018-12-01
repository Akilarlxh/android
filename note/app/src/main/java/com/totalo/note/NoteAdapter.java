package com.totalo.note;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends ArrayAdapter {
    private int id;
    public NoteAdapter(Context context,int textViewResourceId,List<Note> objects){
        super(context,textViewResourceId,objects);
        id = textViewResourceId;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Note note = (Note) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(id,parent,false);
        TextView tile = view.findViewById(R.id.title);
        TextView time = view.findViewById(R.id.time);
        TextView add = view.findViewById(R.id.add);
        tile.setText(note.getTitle());
        time.setText(note.getTime());
        add.setText(note.getAdd());
        return view;

    }
}
