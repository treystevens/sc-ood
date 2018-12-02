package models.Brass;

import models.Instrument;
import models.Orchestra;

import java.util.Objects;

public abstract class BrassInstrument implements Instrument {

    private Orchestra orchestra;

    public BrassInstrument(Orchestra orchestra){
        this.orchestra = orchestra;
    }


    public void setOrchestra(Orchestra orchestra) {
        if (!this.orchestra.equals(orchestra)) {
            this.orchestra = orchestra;
            orchestra.addBrassInstrument(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrassInstrument)) return false;
        BrassInstrument that = (BrassInstrument) o;
        return Objects.equals(orchestra, that.orchestra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orchestra);
    }

}
