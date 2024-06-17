package org.rosemwal.lld.designpatterns.structural.flyweight.wordProcessor;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {

    private static Map<Character, ILetter> characterILetterMap = new HashMap<>();

    public static ILetter createLetter(char characterValue) {

        if(characterILetterMap.containsKey(characterValue)) {
            System.out.println("Object already created before, returning and not init again now");
            return characterILetterMap.get(characterValue);
        }

        ILetter letter = new DocumentCharacter(characterValue, "Arial", 10);
        characterILetterMap.put(characterValue, letter);
        return letter;
    }
}
