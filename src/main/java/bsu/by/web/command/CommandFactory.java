package bsu.by.web.command;


import bsu.by.web.command.image.*;
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
            case "logout":
                return new LogoutCommand();


            case "searchMyImage":
                return new SearchMyImageCommand();
            case "imageFuzzySearch":
                return new imageFuzzySearchCommand();
            case "buyImagePage":
                return new BuyImagePage();
            case "deleteMyImage":
                return new DeleteMyImageCommand();
            case "searchImage":
                return new SearchImageCommand();
            case "deleteImage":
                return new DeleteImageCommand();
            case "ratingImage":
                return new RatingImageCommand();
            case "uploadImagePage":
                return new UploadImagePage();
            case "uploadImage":
                return new UploadImageCommand();


            case "addUser":
                return new AddUserCommand();
            case "addUserPage":
                return new AddUserPage();
            case "queryUser":
                return new QueryUserCommand();
            case "updateUserInfo":
                return new UpdateUserInfoCommand();
            case "updateUserInfoPage":
                return new UpdateUserInfoPage();
            case "deleteUser":
                return new DeleteUserCommand();
            case "userFuzzyQuery":
                return new userFuzzyQueryCommand();

            default:
                throw new UnsupportedOperationException();
        }
    }
}
