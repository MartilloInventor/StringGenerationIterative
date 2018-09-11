package edu.desktop.StringGenerationIterative;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {

    public static void buildstring(HashSet<String> word_strings, HashSet<Character> word, List<Character> cl, int level ) {
        if(level == 0) {
            for (int i = 0; i < cl.size(); ++i) {
                HashSet<Character> dup = new HashSet<Character>( word );
                dup.add(cl.get( i ));
                word_strings.add( dup.toString() );
            }
        } else {
            for(int i = 0; i < cl.size(); ++i) {
                HashSet<Character> dup = new HashSet<Character>(word);
                dup.add(cl.get(i));
                buildstring(word_strings, dup, cl, level - 1);
            }
        }
    }

    public static void main(String args[]) {
        String contents = null;
        String exclusion = null;
        List<Character> conversion = new ArrayList<Character>();
        HashSet<String> word_strings = new HashSet<String>();
        HashSet<Character> word = new HashSet<Character>();

        if (args.length == 0) {
            System.err.printf( "Program must have args.\n" );
            System.exit( -1 );
        }

        for (String tmp : args) {
            conversion.add( tmp.charAt( 0 ) );
        }

        buildstring(word_strings, word, conversion, conversion.size() -1 );

        for (String substring : word_strings) {
            System.out.println( substring );
        }

    }
}
