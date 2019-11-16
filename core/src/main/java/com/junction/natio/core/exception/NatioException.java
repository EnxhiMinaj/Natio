package com.junction.natio.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Anil Kumal on 02/02/2019.
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
