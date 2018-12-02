package models;

import models.Brass.BrassInstrument;
import models.Strings.StringInstrument;

import java.util.ArrayList;

public class Orchestra {


    private ArrayList<BrassInstrument> brassInstruments;
    private ArrayList<StringInstrument> stringInstruments;


    public Orchestra(){
        brassInstruments = new ArrayList<>();
        stringInstruments = new ArrayList<>();
    }


    public void addBrassInstrument(BrassInstrument instrument){
        if(!brassInstruments.contains(instrument)){
            brassInstruments.add(instrument);
            instrument.setOrchestra(this);
        }

    }

    public void addStringInstrument(StringInstrument instrument){
        if(!stringInstruments.contains(instrument)){
            stringInstruments.add(instrument);
            instrument.setOrchestra(this);
        }

    }



}
