package com.example.hunter.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hunter.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.detailImage);
        TextView characterNameView = findViewById(R.id.detailCharacterName);
        TextView quoteView = findViewById(R.id.detailQuote);

        int imageResId = getIntent().getIntExtra("imageResId", 0);
        String characterName = getIntent().getStringExtra("name");
        switch (characterName){
            case "Gon":
                quoteView.setText(getString(R.string.gon_quote_1));
                break;
            case "Hisoka":
                quoteView.setText(getString(R.string.hisoka_quote_1));
                break;
            case "Kilua":
                quoteView.setText(getString(R.string.killua_quote_1));
                break;
            case "Kurapika":
                quoteView.setText(getString(R.string.kurapika_quote_1));
                break;
            case "Leorio":
                quoteView.setText(getString(R.string.leorio_quote_1));
                break;
            case "Meruem":
                    quoteView.setText(getString(R.string.meruem_quote_1));
                    break;
            case "Netero":
                quoteView.setText(getString(R.string.netero_quote_1));
                break;
            case "Alluka":
                    quoteView.setText(getString(R.string.alluka_quote_1));
                    break;

        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imageView.setImageResource(imageResId);
        characterNameView.setText(characterName);
    }
}
