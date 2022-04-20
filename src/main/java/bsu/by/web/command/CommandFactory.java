package bsu.by.web.command;


import bsu.by.web.command.executeCommand.*;
import bsu.by.web.command.jumpPageCommand.*;

public class CommandFactory {

    public Command create(String command){
        switch (command){
            case "login":
                return new LoginCommand();
            case "sign-up-page":
                return new SignupPage();
            case "sign up":
                return new SignupCommand();

            case "search":
                return new SearchCommand();
            case "upload-page":
                return new UploadPage();
            case "upload":
                return new UploadCommand();
            case "logout":
                return new LogoutCommand();

            case "user manage":
                return new UserManagePage();
            case "AddUser":
                return new AddUserCommand();
            case "AddUserPage":
                return new AddUserPage();
            case "QueryUser":
                return new QueryUserCommand();
            case "QueryUserPage":
                return new QueryUserPage();
//            case "UpdateUserInfo":
//                return new UpdateUserInfoCommand();
//            case "DeleteUser":
//                return new DeleteUserCommand();

            default:
                throw new UnsupportedOperationException();
        }
    }
}
