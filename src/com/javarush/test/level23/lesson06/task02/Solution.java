package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants {
        public static final String Server_NotAccessibleException = "Server is not accessible for now.";
        public static final String Unauthorized_UserException = "User is not authorized.";
        public static final String Banned_UserException = "User is banned.";
        public static final String Restriction_Exception = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.Server_NotAccessibleException);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.Server_NotAccessibleException, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.Unauthorized_UserException);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.Unauthorized_UserException, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.Banned_UserException);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.Banned_UserException, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.Restriction_Exception);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.Restriction_Exception, cause);
        }
    }
}
