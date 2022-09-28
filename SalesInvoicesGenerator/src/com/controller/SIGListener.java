package com.controller;
import com.model.InvoiceTableModel;
import com.model.InvoiceParameter;
import com.model.InvoiceItems;
import com.model.ItemsTableModel;
import com.view.InvoiceNewDialog;
import com.view.InvoiceItemDialog;
import com.view.SIGFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Yasmine Ali
 */
public class SIGListener implements ActionListener, ListSelectionListener {

    private SIGFrame frame;
    private InvoiceNewDialog invoiceDialog;
    private InvoiceItemDialog itemsDialog;

    public SIGListener(SIGFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        if (selectedRow > -1) {
            InvoiceParameter inv = frame.getInvoices().get(selectedRow);
            
            
            frame.getInvNumLbl().setText("" + inv.getNum());
            
            frame.getInvDateTxt().setText(SIGFrame.sdf.format(inv.getDate()));
            frame.getInvCustomerNameTxt().setText(inv.getName());
            frame.getInvTotalLbl().setText("" + inv.getTotal());
            ArrayList<InvoiceItems> lines = inv.getLines();
            frame.setLineTableModel(new ItemsTableModel(lines));
        } else {
            frame.getInvNumLbl().setText("");
            frame.getInvDateTxt().setText("");
            frame.getInvCustomerNameTxt().setText("");
            frame.getInvTotalLbl().setText("");
            frame.setLineTableModel(new ItemsTableModel());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Load":
                load(null, null);
                break;
            case "Save":
                save();
                break;
            case "Create Invoice":
                createInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Create Item":
                createItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "newInvoiceOK":
                newInvoiceOK();
                break;
            case "newInvoiceCancel":
                newInvoiceCancel();
                break;
            case "newLineOK":
                newLineOK();
                break;
            case "newLineCancel":
                newLineCancel();
                break;
        }
    }

    public void load(String InvoicePath, String itemPath) {
        File invoiceFile = null;
        File ItemFile = null;
        if (InvoicePath == null && itemPath == null) {
            JOptionPane.showMessageDialog(frame, "Select header file first, then select line file.", "Invoice files", JOptionPane.WARNING_MESSAGE);
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                invoiceFile = fc.getSelectedFile();
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    ItemFile = fc.getSelectedFile();
                }
            }
        } else {
            invoiceFile = new File(InvoicePath);
            ItemFile = new File(itemPath);
        }

        if (invoiceFile != null && ItemFile != null) {
            try {
                /*
                1,29-11-2016,Mohamed
                2,4-09-2020,Nour
                3,19-04-2021,Mahmoud
                4,09-09-2022,Alaa */ 
                //collection streams
                List<String> invoiceItems = Files.lines(Paths.get(invoiceFile.getAbsolutePath())).collect(Collectors.toList());
                /*
                1,Tablet,6400,1               
                2,Cover,50,2
                3,Laptop,10000,1
                3,Mouse,200,1
                3,Headphone,150,1
                4,Backbag,400,2

                 */
                List<String> lineItems = Files.lines(Paths.get(ItemFile.getAbsolutePath())).collect(Collectors.toList());
                frame.getInvoices().clear();
                for (String headerLine : invoiceItems) {
                    String[] parts = headerLine.split(",");  // "1,22-11-2020,Ali"  ==>  ["1", "22-11-2020", "Ali"]
                    String numString = parts[0];
                    String dateString = parts[1];
                    String name = parts[2];
                    int num = Integer.parseInt(numString);
                    Date date = frame.sdf.parse(dateString);
                    InvoiceParameter inv = new InvoiceParameter(num, name, date);
                    frame.getInvoices().add(inv);
                }
                System.out.println("Check point");
                for (String lineLine : lineItems) {
                    
                    String[] parts = lineLine.split(",");
                    int num = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int count = Integer.parseInt(parts[3]);
                    InvoiceParameter inv = frame.getInvoiceByNum(num);
                    InvoiceItems line = new InvoiceItems(name, price, count, inv);
                    inv.getLines().add(line);
                }
                System.out.println("Check point");
                frame.setHeaderTableModel(new InvoiceTableModel(frame.getInvoices()));
                //frame.getInvoicesTable().setModel(new InvoiceTableModel());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void save() {
        JFileChooser fc = new JFileChooser();
        File invoiceFile = null;
        File ItemsFile = null;
        int result = fc.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            invoiceFile = fc.getSelectedFile();
            result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                ItemsFile = fc.getSelectedFile();
            }
        }
        
        if (invoiceFile != null && ItemsFile != null) {
            String headerData = "";
            String lineData = "";
            for (InvoiceParameter inv : frame.getInvoices()) {
                headerData += inv.getAsCSV();
                headerData += "\n";
                for (InvoiceItems line : inv.getLines()) {
                    lineData += line.getAsCSV();
                    lineData += "\n";
                }
            }
            try {
                FileWriter invoiceFW = new FileWriter(invoiceFile);
                FileWriter itemFW = new FileWriter(ItemsFile);
                invoiceFW.write(headerData);
                itemFW.write(lineData);
                invoiceFW.flush();
                itemFW.flush();
                invoiceFW.close();
                itemFW.close();
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error while writing file(s)", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

    private void createInvoice() {
        invoiceDialog = new InvoiceNewDialog(frame);
        invoiceDialog.setLocation(300, 300);
        invoiceDialog.setVisible(true);
    }

    private void deleteInvoice() {

        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        if (selectedRow > -1) {
            frame.getInvoices().remove(selectedRow);
            frame.getHeaderTableModel().fireTableDataChanged();
        }
    }

    private void createItem() {
        if (frame.getInvoicesTable().getSelectedRow() > -1) {
            itemsDialog = new InvoiceItemDialog(frame);
            itemsDialog.setLocation(300, 300);
            itemsDialog.setVisible(true);
        }
    }

    private void deleteItem() {
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
        int selectedItem = frame.getLinesTable().getSelectedRow();

        if (selectedInvoice > -1 && selectedItem > -1) {
            frame.getInvoices().get(selectedInvoice).getLines().remove(selectedItem);
            frame.getLineTableModel().fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
        }
    }

    private void newInvoiceOK() {
        String name = invoiceDialog.getCustNameField().getText();
        String dateStr = invoiceDialog.getInvDateField().getText();
        newInvoiceCancel();
        try {
            Date date = frame.sdf.parse(dateStr);
            InvoiceParameter inv = new InvoiceParameter(frame.getNextInvNum(), name, date);
            frame.getInvoices().add(inv);
            frame.getHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Date Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }

    private void newLineOK() {
        String name = itemsDialog.getItemNameField().getText();
        String countStr = itemsDialog.getItemCountField().getText();
        String priceStr = itemsDialog.getItemPriceField().getText();
        newLineCancel();
        try {
            int count = Integer.parseInt(countStr);
            double price = Double.parseDouble(priceStr);
            int currentInv = frame.getInvoicesTable().getSelectedRow();
            InvoiceParameter inv = frame.getInvoices().get(currentInv);
            InvoiceItems line = new InvoiceItems(name, price, count, inv);
            inv.getLines().add(line);
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(currentInv, currentInv);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Number Format", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newLineCancel() {
        itemsDialog.setVisible(false);
        itemsDialog.dispose();
        itemsDialog = null;
    }

}
