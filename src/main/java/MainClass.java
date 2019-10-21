import controller.ControllerForTesting;
import dao.DAOForTesting;
import service.ServiceForTesting;

public class MainClass {

    public static void main(String[] args) {
        ControllerForTesting controllerForTesting = new ControllerForTesting(new ServiceForTesting(new DAOForTesting()));
        System.out.println(controllerForTesting.testControllerServiceDAO());
    }
}
