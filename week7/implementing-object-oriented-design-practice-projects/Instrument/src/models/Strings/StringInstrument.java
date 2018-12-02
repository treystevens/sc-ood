package models.Strings;

import models.Instrument;
import models.Orchestra;

import java.util.Objects;

public abstract class StringInstrument implements Instrument {

    private Orchestra orchestra;

    public StringInstrument(Orchestra orchestra){
        this.orchestra = orchestra;
    }

    public void setOrchestra(Orchestra orchestra) {
        if (!this.orchestra.equals(orchestra)) {
            this.orchestra = orchestra;
            orchestra.addStringInstrument(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringInstrument)) return false;
        StringInstrument that = (StringInstrument) o;
        return Objects.equals(orchestra, that.orchestra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orchestra);
    }
}
