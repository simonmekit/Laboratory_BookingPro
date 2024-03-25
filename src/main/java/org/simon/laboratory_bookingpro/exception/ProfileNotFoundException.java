package org.simon.laboratory_bookingpro.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProfileNotFoundException extends java.lang.IllegalArgumentException {

    private final String message;

    public ProfileNotFoundException(String message){
        this.message = message;
    }
}
