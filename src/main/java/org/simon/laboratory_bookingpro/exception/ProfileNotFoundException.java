package org.simon.laboratory_bookingpro.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProfileNotFoundException extends java.lang.IllegalArgumentException {

     public ProfileNotFoundException(String message){
        super(message);
    }
}
