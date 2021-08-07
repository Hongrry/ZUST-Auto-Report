package cn.hongrry.autoreport.expection;

/**
 * @author Hongrry
 * @create 2021-08-03 22:55
 */
public class AutoReportException extends Exception{
    public AutoReportException() {
    }

    public AutoReportException(String message) {
        super(message);
    }

    public AutoReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutoReportException(Throwable cause) {
        super(cause);
    }

    public AutoReportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
