package Model.Ships;

import java.util.InputMismatchException;

public enum ShipDirection{
    HORIZONTAL, VERTICAL;

    public static ShipDirection fromString(String dirString) throws InputMismatchException {
        if(dirString.substring(0,1).toLowerCase().equals("v")){
            return VERTICAL;
        }else if(dirString.substring(0,1).toLowerCase().equals("h")){
            return HORIZONTAL;
        }
        return null;
    }
}