  package productapp;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Q.2.4: Menu Bar
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");
        mnuFile.add(mnuExit);
        menuBar.add(mnuFile);

        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);
        menuBar.add(mnuTools);

        setJMenuBar(menuBar);

        // Q.2.2: Form
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        add(new JLabel(""));
        add(btnProcess);

        btnProcess.addActionListener(e -> processSale());
        mnuProcess.addActionListener(e -> processSale());
        mnuExit.addActionListener(e -> System.exit(0));
        mnuClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vatAmount = calc.GetVat();
            double commissionAmount = calc.GetCommission();
            double totalSaleAmount = calc.GetTotal();

            String message = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vatAmount + "\n"
                    + "COMMISSION: R " + commissionAmount + "\n"
                    + "TOTAL: R " + totalSaleAmount;
            JOptionPane.showMessageDialog(this, message);

            saveToFile(customerName, productName, vatAmount, commissionAmount, totalSaleAmount);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price");
        }
    }

    private void saveToFile(String customerName, String productName,
                            double vat, double commission, double total) {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write("DATA LOG\n");
            writer.write("***************************\n");
            writer.write("Customer Name: " + customerName + "\n");
            writer.write("Product: " + productName + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("***************************\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}

