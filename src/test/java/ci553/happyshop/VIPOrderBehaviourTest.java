package ci553.happyshop;

import ci553.happyshop.catalogue.VIPOrder;
import ci553.happyshop.catalogue.Product;
import ci553.happyshop.orderManagement.OrderState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Behaviour-based tests for the VIPOrder class.
 *
 * This class focuses on testing how a VIPOrder behaves in different
 * situations rather than simply checking individual methods.
 *
 * The tests here verify both priority rules and how VIP-specific
 * information is included in the order details output.
 */

public class VIPOrderBehaviourTest {

    /**
     * Checks that a VIP order is NOT treated as a priority order
     * when the VIP level is low.
     *
     * This ensures that priority handling is only applied to
     * higher-tier customers and that lower VIP levels behave
     * the same as standard orders.
     */

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

    /**
     * Checks that VIP-related information is included in the
     * order details output.
     *
     * This test ensures that when orderDetails() is called,
     * the VIP level and discount information are correctly
     * appended to the existing order summary.
     */

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
