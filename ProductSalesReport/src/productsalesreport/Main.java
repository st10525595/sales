
package productsalesreport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] productSales = new int[3][3];

        for (int i = 0; i < productNames.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                    + " for " + productNames[i] + " mattress: ");
                productSales[i][month] = input.nextInt();
            }
        }

        Product product = new Product(productNames, productSales);
        PrintProduct print = new PrintProduct();

        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("******************************************");
        print.PrintTotalProductSales(product.GetTotalProductsSold());
        print.PrintAverageProductSales(product.GetAverageProductSold());
        print.PrintMostPopularProduct(product.GetMostPopularProduct());

        input.close();
    }
}

