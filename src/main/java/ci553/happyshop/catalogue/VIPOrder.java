package ci553.happyshop.catalogue;

import ci553.happyshop.orderManagement.OrderState;
import java.util.ArrayList;

public class VIPOrder extends Order {

    private final int vipLevel; // e.g., 1–3
    private final double discountRate; // e.g., 0.10 = 10%

    public VIPOrder(int orderId, OrderState state, String orderedDateTime,
                    ArrayList<Product> productList, int vipLevel, double discountRate) {
        super(orderId, state, orderedDateTime, productList);
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public boolean isPriority() {
        return vipLevel >= 2;
    }

    @Override
    public String orderDetails() {
        return super.orderDetails() + String.format("\nVIP Level: %d\nDiscountRate: %.2f",
                vipLevel, discountRate);
    }
}
