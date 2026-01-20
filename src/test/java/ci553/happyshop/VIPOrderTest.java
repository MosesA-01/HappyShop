package ci553.happyshop;

import ci553.happyshop.catalogue.VIPOrder;
import ci553.happyshop.catalogue.Product;
import ci553.happyshop.orderManagement.OrderState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class is used to check the behaviour of the VIPOrder class.
 *
 * The aim of these tests is to make sure that VIP-specific rules,
 * such as priority handling, work correctly after extending
 * the original Order class.
 *
 * By testing VIPOrder separately, it helps confirm that new
 * functionality has been added safely without breaking
 * existing order behaviour.
 */

public class VIPOrderTest {

    /**
     * This test checks that a VIP order is treated as a priority order
     * when the VIP level is high enough.
     *
     * In this case, a VIP level of 2 should result in the order
     * being marked as priority, which reflects how higher-tier
     * customers would be handled in a real retail system.
     */

    @Test
    public void vipOrderShouldBePriorityWhenVipLevelIsHigh() {
        ArrayList<Product> products = new ArrayList<>();

        VIPOrder vipOrder = new VIPOrder(
                1,
                OrderState.Ordered,
                "2026-01-19 12:00",
                products,
                2,      // VIP level
                0.10    // 10% discount
        );

        assertTrue(vipOrder.isPriority());}}
