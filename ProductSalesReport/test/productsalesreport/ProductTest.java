package productsalesreport;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    private Product getTestProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        return new Product(names, sales);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = getTestProduct();
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = getTestProduct();
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }

    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        Product product = getTestProduct();
        assertEquals("Cozy Nights Monarch (63)", product.GetMostPopularProduct());
    }
}