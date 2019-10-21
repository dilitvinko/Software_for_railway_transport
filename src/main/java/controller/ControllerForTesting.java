package controller;

import service.ServiceForTesting;

public class ControllerForTesting {
    private final ServiceForTesting serviceForTesting;


    public ControllerForTesting(ServiceForTesting serviceForTesting) {
        this.serviceForTesting = serviceForTesting;
    }

    public String testControllerServiceDAO() {
        return serviceForTesting.testServicPlusDAO();
    }
}
