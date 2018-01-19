package com.example;

import java.util.Random;

public class JokeEngine {
    //===================================================================
    public static String tellMeAJoke(){
        int size = mJokes.length;
        Random r = new Random();
        int index = r.nextInt(size);
        return mJokes[index];
    }
    //===================================================================
    private static final String[] mJokes = {
            "You ever accidentally go up to a real big fat person, and you accidentally ask them for a good place to eat? And they look at you and say they don't know. And you're looking at them, like, 'You do know. I bet if I follow you for an hour, we gonna be eatin'. '",
            "They always ask you dumb questions. 'Do you wanna be fat?' 'Oh yes, yes, I do. I wanna sweat for no reason.' Every time I breathe, they like, 'Why you breathing so hard?' 'So I can live.'",
            "My mom looks at my dad and goes, 'Do I look fat in this dress?' And my dad goes, 'Don't be stupid, you look fat in everything.'",
            "The best part about dating someone who is overweight is, if it's long distance, the distance is slightly less long. And gravity pulls you even closer. So, science really working for you.",
            "I love those restaurants because they cater to fat people. They know fat people are showing up. You walk in; they're like, 'Hey, we took chicken and put cake in it. Is that cool?'",
            "I love the dessert menu there, too, because it's so ridiculous. They actually take a color photo of the dessert, which is unnecessary. It's a photo like it had its own photo shoot day. It's almost a fat guy porno mag at that point.",
            "I'm a voluptuous woman -- a big, beautiful woman -- I don't date no fat men. If you fat, please stay out of my face. What two fat people gonna do? Have a World Wrestling Federation match?"
    };
    //===================================================================
}
