 package productsalesreport;

public class Product implements IProduct {
    private String[] productNames;
    private int[][] productSales;

    public Product(String[] productNames, int[][] productSales) {
        this.productNames = productNames;
        this.productSales = productSales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = productSales.length * productSales[0].length;
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestTotal = -1;
        String mostPopular = "";
        for (int i = 0; i < productSales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < productSales[i].length; j++) {
                productTotal += productSales[i][j];
            }
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                mostPopular = productNames[i] + " (" + productTotal + ")";
            }
        }
        return mostPopular;
    }
}
    

