package bsu.by.web.command;


import bsu.by.web.command.image.SearchCommand;
import bsu.by.web.command.image.UploadCommand;
import bsu.by.web.command.image.UploadPage;
import bsu.by.web.command.user.*;

public class CommandFactory {

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "signUpPage":
                return new SignupPage();
            case "signUp":
                return new SignupCommand();

            case "search":
                return new SearchCommand();
            case "uploadPage":
                return new UploadPage();
            case "upload":
                return new UploadCommand();
            case "logout":
                return new LogoutCommand();

            case "addUser":
                return new AddUserCommand();
            case "addUserPage":
                return new AddUserPage();
            case "queryUser":
                return new QueryUserCommand();
            case "queryUserPage":
                return new QueryUserPage();
            case "updateUserInfo":
                return new UpdateUserInfoCommand();
            case "updateUserInfoPage":
                return new UpdateUserInfoPage();
            case "deleteUser":
                return new DeleteUserCommand();

            default:
                throw new UnsupportedOperationException();
        }
    }
}
