public class WordMatch {
    private String s;
    int guessL;
    public WordMatch(String secret){
        s = secret;
    }
    public int scoreGuess(String guess){
        if (guess.equals("")) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if(guess.length() > s.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int c = 0;
        guessL = guess.length();
        for(int i = 0 ; i < s.length() - (guessL - 1); i++)
        {
            if(s.substring(i,i+guessL).equals(guess))
            {
                c++;
            }
        }
        return (c * guessL * guessL);
    }



    public String findBetterGuess(String g1 , String g2){
        if (g1.equals ("") || g2.equals("")){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (g1.length()>(s.length()) || g2.length()>(s.length())) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int s1 = scoreGuess(g1);
        int s2 = scoreGuess(g2);
        if (s1>s2) {
            return g1;
        }
        else if (s2>s1) {
            return g2;
        }
        else {
            if(g1.compareTo(g2)>0)
            {
                return g1;
            }
            return g2;
        }
    }
}

