package lv.javaguru.ideakeeper.ws.api;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;


public class RestException extends RuntimeException {

    private Response.StatusType httpStatus;

    public RestException(Throwable e) {
        if(e instanceof ClientErrorException) {
            this.httpStatus = ((ClientErrorException) e).getResponse().getStatusInfo();
        }
    }

    public int getHttpStatus() {
        return httpStatus.getStatusCode();
    }
}
