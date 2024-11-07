package edu.famu.fitgen.util;

/*public record ApiResponse<T extends Object>(boolean success, String message, T data, Object error) {
}*/

/*public record ApiResponse<T>(boolean success, String message, Object data, Object error) {
}*/

public record ApiResponse<T extends Object>(boolean success, String message, T data, Object error) {

    public ApiResponse(boolean success, String message) {
        this(success, message, null, null);
    }

    public ApiResponse(boolean success, String message, T data) {
        this(success, message, data, null);
    }

    public ApiResponse(boolean success, String message, String errorMessage) {
        this(success, message, null, errorMessage);
    }

}