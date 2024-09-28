package com.kong.core.common;

/**
 * Enum representing standard response codes and their descriptions.
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/28
 */
public enum ResponseCode {

    // Success
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),

    // Client errors
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    // Server errors
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    /**
     * The response code.
     */
    private final int code;

    /**
     * The description of the response code.
     */
    private final String description;

    /**
     * Constructs a ResponseCode enum with the given code and description.
     *
     * @param code        The response code.
     * @param description The description of the response code.
     */
    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Returns the ResponseCode enum corresponding to the given code.
     *
     * @param code The response code to look up.
     * @return The corresponding ResponseCode, or null if the code is not recognized.
     */
    public static ResponseCode fromCode(int code) {
        for (ResponseCode responseCode : ResponseCode.values()) {
            if (responseCode.getCode() == code) {
                return responseCode;
            }
        }
        return null; // or throw an exception if appropriate
    }

    /**
     * Gets the response code.
     *
     * @return The response code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the description of the response code.
     *
     * @return The description of the response code.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + " " + description;
    }
}
