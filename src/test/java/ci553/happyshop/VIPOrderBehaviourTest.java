package ci553.happyshop;

import ci553.happyshop.catalogue.VIPOrder;
import ci553.happyshop.catalogue.Product;
import ci553.happyshop.orderManagement.OrderState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VIPOrderBehaviourTest {

    @Test
    public void vipOrderShouldNotBePriorityWhenVipLevelIsLow() {
        ArrayList<Product> products = new ArrayList<>();

        VIPOrder vipOrder = new VIPOrder(
                2,
                OrderState.Ordered,
                "2026-01-19 12:05",
                products,
                1,      // low VIP level
                0.10
        );

        assertFalse(vipOrder.isPriority());
    }

    @Test
    public void orderDetailsShouldContainVipInformation() {
        ArrayList<Product> products = new ArrayList<>();

        VIPOrder vipOrder = new VIPOrder(
                3,
                OrderState.Ordered,
                "2026-01-19 12:10",
                products,
                2,
                0.10
        );

        String details = vipOrder.orderDetails();

        assertTrue(details.contains("VIP Level: 2"));
        assertTrue(details.contains("DiscountRate"));
    }
}
