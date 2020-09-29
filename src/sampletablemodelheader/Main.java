/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletablemodelheader;

import javax.swing.SwingUtilities;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Dev-2810
 */
public class Main {
    private static final Object[] columns = {"", "ID", "Name", "Age"};
    private static final Object[][] data = {{false, 1, "Paulo", 23}, {false, 2, "Maria", 32}, {false, 3, "Sergio", 45}};
    private static final int checkboxColumn = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::buildGUI);
    }

    private static void buildGUI() {
        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        TableColumn column = table.getColumnModel().getColumn(checkboxColumn);
        column.setCellEditor(table.getDefaultEditor(Boolean.class));
        column.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        column.setHeaderRenderer(new CheckBoxHeader(table, checkboxColumn));

        JFrame frame = new JFrame();
        frame.setSize(400, 200);
        frame.getContentPane().add(scroll);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
