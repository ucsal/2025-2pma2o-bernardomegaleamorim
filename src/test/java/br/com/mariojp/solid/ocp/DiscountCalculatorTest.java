package br.com.mariojp.solid.ocp;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @Test
    public void testDiscounts() {
        DiscountCalculator calculator = new DiscountCalculator(
            Map.of(
                CustomerType.REGULAR, new RegularPolicy(),
                CustomerType.PREMIUM, new PremiumPolicy(),
                CustomerType.PARTNER, new PartnerPolicy()
            )
        );

        assertEquals(95.0, calculator.apply(100.0, CustomerType.REGULAR));
        assertEquals(90.0, calculator.apply(100.0, CustomerType.PREMIUM));
        assertEquals(88.0, calculator.apply(100.0, CustomerType.PARTNER));
    }

    @Test
    public void testNoDiscountPolicy() {
        DiscountCalculator calculator = new DiscountCalculator(
            Map.of() 
        );

        assertEquals(100.0, calculator.apply(100.0, CustomerType.REGULAR));
    }
}
