package koksha;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {

    private JFrame frame;
    private Store store;
    private DefaultTableModel tableModel;

    public ViewController() {
        store = new Store();
        initialize();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewController window = new ViewController();
            window.frame.setVisible(true);
        });
    }

    private void initialize() {
        frame = new JFrame("Textbook Inventory Management");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"SKU", "Title", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu inventoryMenu = new JMenu("Inventory");
        menuBar.add(inventoryMenu);

        JMenuItem addTextbookItem = new JMenuItem("Add Textbook");
        addTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTextbook();
            }
        });
        inventoryMenu.add(addTextbookItem);

        JMenuItem removeTextbookItem = new JMenuItem("Remove Textbook");
        removeTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeTextbook();
            }
        });
        inventoryMenu.add(removeTextbookItem);

        JMenuItem displayTextbookItem = new JMenuItem("Display Textbook");
        displayTextbookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTextbook();
            }
        });
        inventoryMenu.add(displayTextbookItem);

        JMenuItem displayAllItem = new JMenuItem("Display All Textbooks");
        displayAllItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllTextbooks();
            }
        });
        inventoryMenu.add(displayAllItem);
    }

    private void addTextbook() {
        try {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU:"));
            String title = JOptionPane.showInputDialog("Enter Title:");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
            int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
            String result = store.addTextbook(sku, title, price, quantity);
            JOptionPane.showMessageDialog(frame, result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }

    private void removeTextbook() {
        try {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU to remove:"));
            String result = store.removeTextbook(sku);
            JOptionPane.showMessageDialog(frame, result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }

    private void displayTextbook() {
        try {
            int sku = Integer.parseInt(JOptionPane.showInputDialog("Enter SKU to display:"));
            String result = store.displayTextbook(sku);
            JOptionPane.showMessageDialog(frame, result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input.");
        }
    }

    private void displayAllTextbooks() {
        tableModel.setRowCount(0);
        for (Textbook textbook : store.displayAllTextbooks().values()) {
            tableModel.addRow(new Object[]{textbook.getSku(), textbook.getTitle(), textbook.getPrice(), textbook.getQuantity()});
        }
    }
}
