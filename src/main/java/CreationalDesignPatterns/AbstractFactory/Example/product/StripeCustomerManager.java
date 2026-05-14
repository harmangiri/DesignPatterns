package CreationalDesignPatterns.AbstractFactory.Example.product;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;

/**
 * Concrete Product A1: Implements CustomerManager for the Stripe family.
 * ACTUALLY makes HTTP requests to Stripe's servers to create a customer.
 */
public class StripeCustomerManager implements CustomerManager {
    @Override
    public String createCustomer(String name, String email) {
        System.out.println("[Stripe API] Calling actual Stripe API to create customer: " + name + " (" + email + ")");
        
        CustomerCreateParams params = CustomerCreateParams.builder()
                .setName(name)
                .setEmail(email)
                .build();

        try {
            Customer customer = Customer.create(params);
            System.out.println("[Stripe API] Success! Customer created with ID: " + customer.getId() + "\n");
            return customer.getId();
        } catch (StripeException e) {
            System.err.println("[Stripe API] Failed to create customer!");
            e.printStackTrace();
            return null;
        }
    }
}
