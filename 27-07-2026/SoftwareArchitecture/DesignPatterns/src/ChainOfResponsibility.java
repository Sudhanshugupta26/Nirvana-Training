abstract class Handler{

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler){

        this.nextHandler = nextHandler;
    }

    public abstract void handle(String request);
}
class ValidationHandler extends Handler{

    @Override
    public void handle(String request){

        System.out.println("Validating Request");

        if(nextHandler != null){

            nextHandler.handle(request);
        }
    }
}
class AuthenticationHandler extends Handler{

    @Override
    public void handle(String request){

        System.out.println("Authenticating User");

        if(nextHandler != null){

            nextHandler.handle(request);
        }
    }
}
class LoggingHandler extends Handler{

    @Override
    public void handle(String request){

        System.out.println("Logging Request");

        if(nextHandler != null){

            nextHandler.handle(request);
        }
    }
}
public class ChainOfResponsibility{

    public static void main(String[] args){

        Handler validation = new ValidationHandler();

        Handler authentication =
                new AuthenticationHandler();

        Handler logging =
                new LoggingHandler();

        validation.setNextHandler(authentication);

        authentication.setNextHandler(logging);

        validation.handle("Login Request");
    }
}