package exception;

public class InvalidParameterException extends Exception{

    public InvalidParameterException(){

    }

    public InvalidParameterException(String message){
        super(message);
    }
}
