package ci553.happyshop;

import ci553.happyshop.catalogue.VIPOrder;
import ci553.happyshop.catalogue.Product;
import ci553.happyshop.orderManagement.OrderState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VIPOrderTest {

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
