package ci553.happyshop;

import ci553.happyshop.client.customer.VIPCustomerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class checks how VIP customers are handled in the system.
 *
 * The goal here is to make sure that customer priority is calculated
 * correctly based on the VIP level assigned to a customer.
 *
 * By testing this logic in isolation, it becomes easier to confirm
 * that the rules work as expected without depending on the user
 * interface or other parts of the system.
 */

public class VIPCustomerModelTest {

    /**
     * This test checks that a customer with a higher VIP level
     * is correctly recognised as a priority customer.
     *
     * In this case, a VIP level of 2 should be enough to
     * give the customer priority status.
     */

    @Test
    public void vipCustomerShouldBePriorityWhenVipLevelIsHigh() {
        VIPCustomerModel vipCustomer = new VIPCustomerModel(2);
        assertTrue(vipCustomer.hasPriority());
    }

    /**
     * This test checks that a customer with a lower VIP level
     * is not incorrectly given priority status.
     *
     * This helps ensure that priority rules are applied
     * consistently and only when the correct conditions
     * are met.
     */

    @Test
    public void vipCustomerShouldNotBePriorityWhenVipLevelIsLow() {
        VIPCustomerModel vipCustomer = new VIPCustomerModel(1);
        assertFalse(vipCustomer.hasPriority());
    }
}
