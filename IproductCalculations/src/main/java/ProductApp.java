import javax.swing.*;

public class ProductApp extends JFrame {
    private JTextField txtName, txtPrice;
    private JComboBox<String> cmbProduct;

    public ProductApp() {
        setTitle("Product App");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Q2.4 Menu system
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> System.exit(0));
        mFile.add(miExit);

        JMenu mEdit = new JMenu("Edit");
        JMenuItem miProcess = new JMenuItem("Process");
        JMenuItem miClear = new JMenuItem("Clear");
        mEdit.add(miProcess);
        mEdit.add(miClear);
        mb.add(mFile);
        mb.add(mEdit);
        setJMenuBar(mb);

        // Q2.1 - Textbox for customer name, combo for product
        JLabel l1 = new JLabel("Customer Name:");
        l1.setBounds(20, 20, 100, 25); add(l1);
        txtName = new JTextField();
        txtName.setBounds(140, 20, 170, 25); add(txtName);

        JLabel l2 = new JLabel("Select Product:");
        l2.setBounds(20, 60, 100, 25); add(l2);
        cmbProduct = new JComboBox<>(new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
        cmbProduct.setBounds(140, 60, 170, 25); add(cmbProduct);

        JLabel l3 = new JLabel("Enter Price:");
        l3.setBounds(20, 100, 100, 25); add(l3);
        txtPrice = new JTextField();
        txtPrice.setBounds(140, 100, 170, 25); add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(140, 140, 170, 25); add(btnProcess);

        // Process logic - same for button and menu
        Runnable processLogic = () -> {
            try {
                String cust = txtName.getText();
                String prod = (String) cmbProduct.getSelectedItem();
                double price = Double.parseDouble(txtPrice.getText());

                ProductCalculations calc = new ProductCalculations(price);
                double vat = calc.GetVat();
                double comm = calc.GetCommission();
                double total = calc.GetTotal();

                // Show exactly like screenshot
                JOptionPane.showMessageDialog(this,
                    "Customer Name: " + cust + "\n" +
                    "Product: " + prod + "\n" +
                    "VAT: R " + vat + "\n" +
                    "COMMISSION: R " + comm + "\n" +
                    "TOTAL: R " + total,
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid price");
            }
        };

        btnProcess.addActionListener(e -> processLogic.run());
        miProcess.addActionListener(e -> processLogic.run());

        // Clear
        miClear.addActionListener(e -> {
            txtName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });
    }

    public static void main(String[] args) {
        new ProductApp().setVisible(true);
    }
}