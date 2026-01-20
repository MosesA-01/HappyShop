package ci553.happyshop.client.customer;

/**
 * VIPCustomerModel extends CustomerModel to represent
 * customers with VIP membership levels.
 *
 * This class demonstrates inheritance by reusing the
 * existing customer model while adding VIP-specific behaviour.
 */
public class VIPCustomerModel extends CustomerModel {

    private final int vipLevel; // e.g. 1–3

    public VIPCustomerModel(int vipLevel) {
        super();
        this.vipLevel = vipLevel;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    /**
     * Business rule:
     * VIP customers with level 2 or above are treated as priority customers.
     */
    public boolean hasPriority() {
        return vipLevel >= 2;
    }
}
