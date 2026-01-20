package ci553.happyshop;

import ci553.happyshop.client.customer.VIPCustomerModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VIPCustomerModelTest {

    @Test
    public void vipCustomerShouldBePriorityWhenVipLevelIsHigh() {
        VIPCustomerModel vipCustomer = new VIPCustomerModel(2);
        assertTrue(vipCustomer.hasPriority());
    }

    @Test
    public void vipCustomerShouldNotBePriorityWhenVipLevelIsLow() {
        VIPCustomerModel vipCustomer = new VIPCustomerModel(1);
        assertFalse(vipCustomer.hasPriority());
    }
}
