package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
    public static final class Constants {
        public static final String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public static final String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public static final String USER_IS_BANNED = "User is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }
    public class ServerNotAccessibleException extends Exception {
//        public ServerNotAccessibleException() {
//            super();
//        }

        public ServerNotAccessibleException(Throwable cause) {
            super("Server is not accessible for now.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super();
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
//        public BannedUserException() {
//            super();
//        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
//        public RestrictionException() {
//            super();
//        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}
