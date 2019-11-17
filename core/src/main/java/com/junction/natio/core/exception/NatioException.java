package com.junction.natio.core.exception;

import lombok.Getter;
import lombok.Setter;

/**

 */
@Getter
@Setter
public class NatioException extends RuntimeException {
    private Object data;

    public NatioException(String message) {
        this(message, null);
    }

    public NatioException(String message, Object data) {
        super(message);
        this.data = data;
    }
}
