package coffee.order;

import lombok.Getter;

@Getter
public class Order {
    private int orderId;
    private String customerName;

    public Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName;
    }

}
