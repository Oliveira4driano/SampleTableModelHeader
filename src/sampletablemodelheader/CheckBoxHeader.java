/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletablemodelheader;

import java.awt.Component;
import java.awt.event.ItemEvent;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dev-2810
 */
public class CheckBoxHeader extends JCheckBox implements TableCellRenderer {
    CheckBoxHeader(JTable table, int checkboxColumn) {
        this.setText("Check All");

        table.getTableHeader().addMouseListener(new MyMouseListener(this, checkboxColumn));

        this.addItemListener((event) -> {
            Object source = event.getSource();
            if (!(source instanceof AbstractButton)) return;

            boolean checked = event.getStateChange() == ItemEvent.SELECTED;

            for (int x = 0, y = table.getRowCount(); x < y; x++)
                table.setValueAt(checked, x, 0);
        });
    }

    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }

   
    
}
