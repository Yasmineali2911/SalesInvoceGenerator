
package com.model;
import com.view.SIGFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yasmine Ali
 */
public class InvoiceTableModel extends AbstractTableModel {

    private String[] invoiceParameters = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    private ArrayList<InvoiceParameter> invoices;
    
    public InvoiceTableModel(ArrayList<InvoiceParameter> invoices) {
        this.invoices = invoices;
    }
    
    @Override
    public int getColumnCount() {
        return invoiceParameters.length;
    }

    @Override
    public String getColumnName(int parameter) {
        return invoiceParameters[parameter];
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceParameter inv = invoices.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return inv.getNum();
            case 1:
                return SIGFrame.sdf.format(inv.getDate());
            case 2:
                return inv.getName();
            case 3:
                return inv.getTotal();
            default:
                return "";
        }
    }
}
