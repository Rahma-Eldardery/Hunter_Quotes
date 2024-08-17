package com.example.hunter.ui.quotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hunter.R;
import com.example.hunter.databinding.FragmentQuotesListBinding;

public class QuotesActivity extends Fragment {
    String[] quotes ;
    private FragmentQuotesListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentQuotesListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        quotes = getResources().getStringArray(R.array.quotes);

        ListView listView = root.findViewById(R.id.listQuotes);

        // Use ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), R.layout.item_quotes,R.id.text_quote,quotes
        );

        listView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}