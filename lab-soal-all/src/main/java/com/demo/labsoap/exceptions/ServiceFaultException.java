package com.demo.labsoap.exceptions;


import lombok.Getter;

@Getter
public class ServiceFaultException extends RuntimeException {

    private ServiceFault serviceFault;

    public ServiceFaultException(String message, ServiceFault serviceFault) {
        super(message);
        this.serviceFault = serviceFault;
    }
}