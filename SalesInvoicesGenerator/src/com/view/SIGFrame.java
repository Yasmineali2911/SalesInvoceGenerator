package com.view;

import com.controller.SIGListener;
import com.model.InvoiceTableModel;
import com.model.InvoiceParameter;
import com.model.ItemsTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Yasmine Ali
 */
public class SIGFrame extends javax.swing.JFrame {

    public SIGFrame() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(listener);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(listener);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(listener);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        createItemBtn = new javax.swing.JButton();
        createItemBtn.addActionListener(listener);
        deleteItemBtn = new javax.swing.JButton();
        deleteItemBtn.addActionListener(listener);
        invTotalLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invDateTxt = new javax.swing.JTextField();
        invCustomerNameTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Invoices Generator");

        invoicesTable.setBackground(new java.awt.Color(204, 204, 255));
        invoicesTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        invoicesTable.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoicesTable);

        createInvBtn.setText("Create Invoice");

        deleteInvBtn.setText("Delete Invoice");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel1.setText("Invoice Num");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Invoice Date");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("Invoice Total");

        linesTable.setBackground(new java.awt.Color(204, 204, 255));
        linesTable.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        linesTable.setForeground(new java.awt.Color(0, 51, 102));
        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(linesTable);

        createItemBtn.setText("Create Item");

        deleteItemBtn.setText("Delete Item");

        invTotalLbl.setText(".");

        invNumLbl.setText(".");

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Invoices");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        jLabel7.setBackground(new java.awt.Color(0, 0, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Invoices Details");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        jMenu1.setText("File");

        loadMenuItem.setText("Load");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(createInvBtn)
                        .addGap(45, 45, 45)
                        .addComponent(deleteInvBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(invTotalLbl)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invNumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(invDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                                    .addComponent(invCustomerNameTxt)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(createItemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteItemBtn)
                        .addGap(96, 96, 96))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(invNumLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invCustomerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createInvBtn)
                        .addComponent(createItemBtn)
                        .addComponent(deleteItemBtn))
                    .addComponent(deleteInvBtn))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SIGFrame frame = new SIGFrame();
                frame.setLocation(300, 100);
                frame.setVisible(true);
                frame.listener.load("DefaultInvoice.csv", "DefaultItem.csv");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createItemBtn;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JTextField invCustomerNameTxt;
    private javax.swing.JTextField invDateTxt;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private SIGListener listener = new SIGListener(this);
    private ArrayList<InvoiceParameter> invoices;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private InvoiceTableModel headerTableModel;
    private ItemsTableModel lineTableModel;

    public InvoiceTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public ItemsTableModel getLineTableModel() {
        return lineTableModel;
    }

    public void setLineTableModel(ItemsTableModel lineTableModel) {
        this.lineTableModel = lineTableModel;
        getLinesTable().setModel(lineTableModel);
    }

    public void setHeaderTableModel(InvoiceTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
        getInvoicesTable().setModel(headerTableModel);
    }
    
    public JLabel getInvNumLbl() {
        return invNumLbl;
    }
    public JTextField getInvDateTxt() {
        return invDateTxt;
    }
    public JTextField getInvCustomerNameTxt() {
           return invCustomerNameTxt;
       }

    public JLabel getInvTotalLbl() {
           return invTotalLbl;
       }
   

   

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JTable getLinesTable() {
        return linesTable;
    }

    public SIGListener getListener() {
        return listener;
    }
 
    
    public ArrayList<InvoiceParameter> getInvoices() {
        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }

    public InvoiceParameter getInvoiceByNum(int num) {
        InvoiceParameter inv = null;
        
        for (InvoiceParameter header : getInvoices()) {
            if (header.getNum() == num) {
                inv = header;
                break;
            }
        }
        return inv;
    }
    
    public int getNextInvNum() {
        int num = -1;
        for (InvoiceParameter inv : getInvoices()) {
            num = Math.max(num, inv.getNum());
        }
        return ++num;
    }

   
    
}
