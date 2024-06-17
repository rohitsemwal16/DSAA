package org.rosemwal.lld.designpatterns.structural.flyweight.wordProcessor;

public class DocumentCharacter implements ILetter {

    private char character;
    private String fontType;
    private int size;

    public DocumentCharacter(char characterValue, String arial, int i) {
        this.character = characterValue;
        this.fontType = arial;
        this.size = i;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("X "+ x + " Y "+ y);
    }
}
