package ci553.happyshop.client.customer;

import ci553.happyshop.storageAccess.DatabaseRW;
import ci553.happyshop.storageAccess.DatabaseRWFactory;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class represents a standalone customer client for the HappyShop system.
 *
 * It allows the customer interface to be launched on its own without starting
 * the entire system, which is useful during development and testing.
 *
 * Although the client can run independently, some features may rely on
 * other parts of the system being active in order to function fully.
 */

public class CustomerClient extends Application {

    /**
     * Entry point for launching the customer client.
     *
     * This method simply starts the JavaFX application and
     * delegates initialisation to the start() method.
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initialises and connects the Model, View, and Controller components
     * for the customer client.
     *
     * The method follows the MVC pattern by creating each component
     * separately and then linking them together so they can communicate.
     *
     * A DatabaseRW instance is created using the DatabaseRWFactory and
     * injected into the CustomerModel, allowing the model to access
     * persistent storage without being tightly coupled to a specific
     * database implementation.
     *
     * Once all components are connected, the customer user interface
     * is launched by starting the view.
     */

    @Override
    public void start(Stage window) {
        CustomerView cusView = new CustomerView();
        CustomerController cusController = new CustomerController();
        CustomerModel cusModel = new CustomerModel();
        DatabaseRW databaseRW = DatabaseRWFactory.createDatabaseRW();

        cusView.cusController = cusController;
        cusController.cusModel = cusModel;
        cusModel.cusView = cusView;
        cusModel.databaseRW = databaseRW;
        cusView.start(window);

        //RemoveProductNotifier removeProductNotifier = new RemoveProductNotifier();
        //removeProductNotifier.cusView = cusView;
        //cusModel.removeProductNotifier = removeProductNotifier;
    }
}
