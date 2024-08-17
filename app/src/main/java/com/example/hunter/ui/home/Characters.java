package com.example.hunter.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hunter.R;
import com.example.hunter.databinding.FragmentCharacterListBinding;
import com.example.hunter.model.ItemCharacterGrid;
import com.example.hunter.ui.adapter.CharacterAdapter;

import java.util.ArrayList;
import java.util.List;

public class Characters extends Fragment {

    private FragmentCharacterListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCharacterListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridView gridView = root.findViewById(R.id.character);
        List<ItemCharacterGrid> quotes = new ArrayList<>();
        quotes.add(new ItemCharacterGrid(R.mipmap.gon_foreground, "Gon", getString(R.string.gon_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.hisoka_foreground, "Hisoka", getString(R.string.hisoka_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.meruem_foreground, "Meruem", getString(R.string.meruem_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.kurabika_foreground , "Kurapika", getString(R.string.kurapika_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.kilua_foreground, "Kilua", getString(R.string.killua_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.leorio_foreground, "Leorio", getString(R.string.leorio_quote_1)));
            quotes.add(new ItemCharacterGrid(R.mipmap.netero_foreground, "Netero", getString(R.string.netero_quote_1)));
        quotes.add(new ItemCharacterGrid(R.mipmap.alluka_foreground, "Alluka", getString(R.string.alluka_quote_1)));

        CharacterAdapter adapter = new CharacterAdapter( getContext(), quotes);
        gridView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}