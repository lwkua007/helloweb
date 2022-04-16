package bsu.by.web.command;


public class CommandFactory {

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "sign-up-page":
                return new SignupPage();
            case "sign up":
                return new SignupCommand();
            case "create":
                return new CreateCommand();
            case "update":
                return new UpdateCommand();
            case "delete":
                return new DeleteCommand();
            case "read":
                return new ReadCommand();
            case "add image":
                return new UploadPage();
            case "logout":
                return new LogoutCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
