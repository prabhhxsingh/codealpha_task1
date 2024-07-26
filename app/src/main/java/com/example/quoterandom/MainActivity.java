package com.example.quoterandom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quoterandom.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView, likeCountTextView;
    private Button generateButton, shareButton, likeButton;

    private String[] quotes = {
            "Be yourself; everyone else is already taken. - Oscar Wilde",
            "In three words I can sum up everything I've learned about life: it goes on. - Robert Frost",
            "The only way to do great work is to love what you do. - Steve Jobs",
            "You know you're in love when you can't fall asleep because reality is finally better than your dreams. ― Dr. Seuss",
            "You only live once, but if you do it right, once is enough.― Mae West",
            "Be the change that you wish to see in the world. ― Mahatma Gandhi",
            "In three words I can sum up everything I've learned about life: it goes on.― Robert Frost",
            "If you tell the truth, you don't have to remember anything.― Mark Twain",
            "Friendship ... is born at the moment when one man says to another \"What! You too? I thought that no one but myself. ― C.S. Lewis, The Four Loves",
            "A friend is someone who knows all about you and still loves you.― Elbert Hubbard"
    };

    private int likeCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        generateButton = findViewById(R.id.generateButton);
        shareButton = findViewById(R.id.shareButton);
        likeButton = findViewById(R.id.likeButton);
        likeCountTextView = findViewById(R.id.likeCountTextView);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeQuote();
            }
        });
    }

    private void generateQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        String randomQuote = quotes[index];
        quoteTextView.setText(randomQuote);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        startActivity(Intent.createChooser(shareIntent, "Share Quote via"));
    }

    private void likeQuote() {
        likeCount++;
        likeCountTextView.setText("Likes: " + likeCount);
    }
}
