package model.exceptions;

import model.exceptions.BeansAmountException;

public class NotEnoughBeansException extends BeansAmountException {


    public NotEnoughBeansException(double beans){
        super(beans, " is not enough beans");
    }


}
