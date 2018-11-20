package model;

import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase>{

    private List<Phrase> phrases;


    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;

    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }


    @Override
    public Iterator<Phrase> iterator() {

        return new SillWordGameIterator();
    }



    private class SillWordGameIterator implements Iterator<Phrase>{

        private Iterator<Phrase> phrasesIterator = phrases.iterator();

        @Override
        public boolean hasNext() {
            return phrasesIterator.hasNext();
        }

        @Override
        public Phrase next() {

            Phrase p = phrasesIterator.next();


            while (!p.needsWord()) { p = phrasesIterator.next(); }


            return p;
        }
    }
}
