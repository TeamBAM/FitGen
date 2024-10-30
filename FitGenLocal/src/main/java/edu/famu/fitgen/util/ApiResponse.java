package edu.famu.fitgen.util;

public record ApiResponse<T extends Object>(boolean success, String message, T data, Object error) {
}
