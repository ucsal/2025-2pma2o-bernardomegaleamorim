package br.com.mariojp.solid.ocp;

import java.util.Map;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        if (policy == null) {
            return amount;
        }
        return policy.apply(amount);
    }
}
