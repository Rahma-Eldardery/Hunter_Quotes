package com.example.hunter.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hunter.R;
import com.example.hunter.model.ItemCharacterGrid;
import com.example.hunter.ui.home.DetailActivity;

import java.util.List;


public class CharacterAdapter extends BaseAdapter {
    private Context context;
    private List<ItemCharacterGrid> items;

    public CharacterAdapter(Context context, List<ItemCharacterGrid> quotes) {
        this.context = context;
        this.items = quotes;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_character, parent, false);
        }

        ItemCharacterGrid currentCharacter = (ItemCharacterGrid) getItem(position);
        ImageView quoteImage = view.findViewById(R.id.quoteImage);
        TextView quoteCharacterName = view.findViewById(R.id.quoteCharacterName);
        TextView quote = view.findViewById(R.id.quote);

        quoteImage.setImageResource(currentCharacter.getCharacterImage());
        quoteCharacterName.setText(currentCharacter.getCharacterName());
        quote.setText(currentCharacter.getQuote());

       view.setOnClickListener(v -> {
           Intent intent = new Intent(context, DetailActivity.class);
           intent.putExtra("imageResId", currentCharacter.getCharacterImage());
           intent.putExtra("name", currentCharacter.getCharacterName());
           intent.putExtra("quote", currentCharacter.getQuote());
           context.startActivity(intent);
       });
        return view;
    }
}
