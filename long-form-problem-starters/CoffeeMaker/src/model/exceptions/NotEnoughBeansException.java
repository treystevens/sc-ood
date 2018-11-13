package model.exceptions;

import model.exceptions.BeansAmountException;

public class NotEnoughBeansException extends BeansAmountException {


    protected NotEnoughBeansException(double beans){
        super(beans, " is not enough beans");
    }


}
