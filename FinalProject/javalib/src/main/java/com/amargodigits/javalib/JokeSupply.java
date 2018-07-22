package com.amargodigits.javalib;

import java.util.Random;

public class JokeSupply {
public String[] jokesArray = {
        "A man goes to the doctor and says, 'It hurts when I touch myself here, here and here.\n The doctor says 'Your finger is broken'",
        "A woman walks into a library and asked if they had any books about paranoia.\n Librarian: 'They’re right behind you!!'",
        " - Why do you never see hippopotamuses hiding in trees?\n - They are really good at it.",
        "A dog walks into a bar from the construction site across the street and says 'Gimme a beer.'\n " +
                "The bartender says 'Wow! A talking dog. You should get a job at the circus.'\n The dog says 'They do need Android developers there?'",
        " - What’s blue and smells like red paint?\n - Blue paint.",
        " - Why did the scarecrow win the agriculture award?\n - He was out standing in his field."
};

public String getJoke(){
    return  getRandom(jokesArray) ;
}

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
