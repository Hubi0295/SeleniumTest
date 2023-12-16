public class WrongBrowserException extends Exception{
    WrongBrowserException(String message){
        System.err.println(message);
    }
}
