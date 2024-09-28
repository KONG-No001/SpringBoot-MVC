package com.kong.core.common;

/**
 * 表示操作结果的类，包含成功状态、代码和结果数据。
 *
 * @param <T> 结果数据类型。
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class Result<T> {

    /**
     * Indicates whether the operation was successful.
     */
    protected boolean success;

    /**
     * The status code associated with the result.
     */
    protected ResponseCode code;

    /**
     * The actual result data of the operation.
     */
    protected T result;

    /**
     * Static factory method to create a success result.
     *
     * @param <T>    The type of the result data.
     * @param result The result data.
     * @return A new Result object indicating success.
     */
    public static <T> Result<T> success(T result) {
        Result<T> res = new Result<>();
        res.setSuccess(true);
        res.setCode(ResponseCode.OK);
        res.setResult(result);
        return res;
    }

    /**
     * Static factory method to create a failure result.
     *
     * @param <T>  The type of the result data.
     * @param code The error code.
     * @return A new Result object indicating failure.
     */
    public static <T> Result<T> failure(ResponseCode code) {
        Result<T> res = new Result<>();
        res.setSuccess(false);
        res.setCode(code);
        return res;
    }

    /**
     * Gets the success status of the operation.
     *
     * @return true if the operation was successful, false otherwise.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the success status of the operation.
     *
     * @param success true if the operation was successful, false otherwise.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets the status code associated with the result.
     *
     * @return The status code.
     */
    public ResponseCode getCode() {
        return code;
    }

    /**
     * Sets the status code associated with the result.
     *
     * @param code The status code to set.
     */
    public void setCode(ResponseCode code) {
        this.code = code;
    }

    /**
     * Gets the actual result data of the operation.
     *
     * @return The result data.
     */
    public T getResult() {
        return result;
    }

    /**
     * Sets the actual result data of the operation.
     *
     * @param result The result data to set.
     */
    public void setResult(T result) {
        this.result = result;
    }

}
