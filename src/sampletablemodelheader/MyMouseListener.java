/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletablemodelheader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dev-2810
 */
public class MyMouseListener extends MouseAdapter {
    private final CheckBoxHeader checkbox;
    private final int checkboxColumn;

    MyMouseListener(CheckBoxHeader checkbox, int checkboxColumn) {
        this.checkbox = checkbox;
        this.checkboxColumn = checkboxColumn;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JTableHeader header = (JTableHeader) e.getSource();
        JTable tableView = header.getTable();
        TableColumnModel columnModel = tableView.getColumnModel();
        int viewColumn = columnModel.getColumnIndexAtX(e.getX());
        int column = tableView.convertColumnIndexToModel(viewColumn);

        if (viewColumn == checkboxColumn && e.getClickCount() == 1 && column != -1)
            checkbox.doClick();
    }
}
