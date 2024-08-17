package com.example.hunter.model;

public class ItemCharacterGrid {
    private int characterImage;
    private String characterName , quote;

    public ItemCharacterGrid(int imageResource, String characterName, String quote) {
        this.characterImage = imageResource;
        this.characterName = characterName;
        this.quote = quote;
    }

    public int getCharacterImage() {
        return characterImage;
    }

    public String getCharacterName() {
        return characterName;
    }
    public String getQuote() {
        return quote;
    }
}
