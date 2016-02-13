
package com.easilydo.sift.model.gen;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Generated("org.jsonschema2pojo")
public enum ReservationStatus {

    CANCELLED("http://schema.org/ReservationCancelled"),
    CONFIRMED("http://schema.org/ReservationConfirmed"),
    HOLD("http://schema.org/ReservationHold"),
    PENDING("http://schema.org/ReservationPending");
    private final String value;
    private static Map<String, ReservationStatus> constants = new HashMap<String, ReservationStatus>();

    static {
        for (ReservationStatus c: values()) {
            constants.put(c.value, c);
        }
    }

    private ReservationStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }

    @JsonCreator
    public static ReservationStatus fromValue(String value) {
        ReservationStatus constant = constants.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
