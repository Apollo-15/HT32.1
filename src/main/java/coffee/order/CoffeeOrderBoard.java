package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    public static final Logger logger = LogManager.getLogger(CoffeeOrderBoard.class);

    List<Order> orders = new ArrayList<>();
    int nextOrderId = 1;

    public void add(String customerName){
        orders.add(new Order(nextOrderId, customerName));
        nextOrderId++;
        logger.info("Added order for customer: " + customerName);
    }

    public void deliver() {
        if (orders.isEmpty()) {
            logger.warn("No orders found");
            return;
        }
        Order order = orders.remove(0);
        logger.info("Delivered order: " + order);
    }

    public void deliver(int orderId){
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orders.remove(order);
                logger.info("Delivered order for customer: " + order.getCustomerName());
                return;
            }
        }
        logger.warn("No orders to deliver with ID.");
    }

    public void draw() {
        logger.info("Current orders:");
        for (Order order : orders) {
            logger.info(order);
        }
    }
}
