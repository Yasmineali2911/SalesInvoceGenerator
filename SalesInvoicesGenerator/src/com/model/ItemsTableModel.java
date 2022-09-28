package com.model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yasmine Ali
 */
public class ItemsTableModel extends AbstractTableModel {

    private String[] itemParameters = {"Item", "Unit Price", "Count", "Total"};
    private ArrayList<InvoiceItems> Items;

    public ItemsTableModel() {
        this(new ArrayList<InvoiceItems>());
    }

    
    public ItemsTableModel(ArrayList<InvoiceItems> lines) {
        this.Items = lines;
    }

    @Override
    public int getColumnCount() {
        return itemParameters.length;
    }

    @Override
    public String getColumnName(int column) {
        return itemParameters[column];
    }

    @Override
    public int getRowCount() {
        return Items.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItems Item = Items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Item.getName();
            case 1:
                return Item.getPrice();
            case 2:
                return Item.getCount();
            case 3:
                return Item.getTotal();
            default:
                return "";
        }
    }
}
