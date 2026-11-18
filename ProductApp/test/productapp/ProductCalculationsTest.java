package productapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithPrice3500_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    @Test
    public void GetCommission_WithPrice3500_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(175.0, calc.GetCommission(), 0.01);
    }

    @Test
    public void GetTotal_WithPrice3500_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        // 3500 + 525 VAT + 175 Commission = 4200
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}