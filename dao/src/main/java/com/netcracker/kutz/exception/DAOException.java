package com.netcracker.kutz.exception;

/**
 * Created by Егор on 08.04.17.
 */
public class DAOException extends Exception {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
