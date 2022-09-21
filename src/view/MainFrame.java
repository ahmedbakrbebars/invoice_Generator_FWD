package view;

import cotroler.FileOperations;
import model.InoviceHeader;
import model.InoviceLine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainFrame  extends JFrame implements ActionListener , ListSelectionListener {
    private CreateInoviceDialog CreateInvDialog;
    private CreateItemDialog CreateLineDialog;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateNewInoviceButton;
    private javax.swing.JTextPane DateTextPane;
    private javax.swing.JButton DeleteInoviceButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JTable HeaderTable;
    private javax.swing.JLabel InoviceNumber;
    private javax.swing.JLabel InoviceTotal;
    private javax.swing.JTable LineTable;
    private javax.swing.JMenuItem LoadMenuItem;
    private javax.swing.JTextPane NameTextPane;
    private javax.swing.JButton SaveButton;
    private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    FileOperations controller;
    ArrayList<InoviceHeader> FileData;
    InoviceHeader SelectedInv;
    InoviceLine SelectedLine;
    DefaultTableModel HeaderModel;

    public MainFrame() {
        HeaderModel = new DefaultTableModel(new String [] {"Inovice Number", "Invoice Date", "Customer Name", "Total"},0);
        FileData = new ArrayList<>();
        SelectedInv = null;
        SelectedLine = null;
        controller = new FileOperations();
        initComponents();
        loadFile(System.getProperty("user.dir") + "\\data\\InvoiceHeader.csv", System.getProperty("user.dir") + "\\data\\InvoiceLine.csv");
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        InoviceNumber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        InoviceTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DateTextPane = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        NameTextPane = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        LineTable = new javax.swing.JTable();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        HeaderTable = new javax.swing.JTable();
        DeleteInoviceButton = new javax.swing.JButton();
        CreateNewInoviceButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        LoadMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        SaveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Inovice Generator");
        setFocusTraversalPolicyProvider(true);

        jLabel1.setText("Inovice Number");

        InoviceNumber.setText("N/A");

        jLabel3.setText("Inovice Date");

        jLabel4.setText("Customer name");

        jLabel5.setText("Inovice total");

        InoviceTotal.setText("N/A");

        jScrollPane2.setViewportView(DateTextPane);

        jScrollPane3.setViewportView(NameTextPane);

        LineTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "No.", "Item name", "Item price", "Count", "Item total"
                }
        ));
        LineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(LineTable);
        LineTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (LineTable.getSelectedRow() > -1 && SelectedInv != null) {
                    SelectedLine = SelectedInv.getLines().get(LineTable.getSelectedRow());
                }
            }
        });

        SaveButton.setText("Create new line");

        CancelButton.setText("Delete line");

        jLabel8.setText("Inovice items:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(25, 25, 25)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(InoviceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(25, 25, 25)
                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(25, 25, 25)
                                                .addComponent(InoviceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SaveButton)
                                .addGap(72, 72, 72)
                                .addComponent(CancelButton)
                                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(InoviceNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(InoviceTotal)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(SaveButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SaveButton.addActionListener(this);
        CancelButton.addActionListener(this);

        jLabel7.setText("Inovice table:");

        HeaderTable.setModel(HeaderModel);
        HeaderTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        HeaderTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(HeaderTable);
        HeaderTable.getSelectionModel().addListSelectionListener(this);

        DeleteInoviceButton.setText("Delete inovice");
        DeleteInoviceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteInoviceButtonActionPerformed(evt);
            }
        });

        CreateNewInoviceButton.setText("Create new inovice");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel7)))
                                .addContainerGap(16, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(CreateNewInoviceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DeleteInoviceButton)
                                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CreateNewInoviceButton)
                                        .addComponent(DeleteInoviceButton))
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        DeleteInoviceButton.addActionListener(this);
        CreateNewInoviceButton.addActionListener(this);

        FileMenu.setText("File");

        LoadMenuItem.setText("Load File");
        FileMenu.add(LoadMenuItem);
        LoadMenuItem.addActionListener(this);
        FileMenu.add(jSeparator1);

        SaveMenuItem.setText("Save File");
        FileMenu.add(SaveMenuItem);
        SaveMenuItem.addActionListener(this);

        jMenuBar1.add(FileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }
    private void DeleteInoviceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteInoviceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteInoviceButtonActionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getActionCommand().equals("Load File") )
        {
            String HeaderPath = null;
            String LinePath = null;


            JFileChooser window = new JFileChooser();
            JOptionPane.showMessageDialog(this, "Please choose header file", "Header File", JOptionPane.INFORMATION_MESSAGE);
            int Result = window.showOpenDialog(this);
            if(Result == JFileChooser.APPROVE_OPTION)
                HeaderPath = window.getSelectedFile().getPath();

            window = new JFileChooser();
            JOptionPane.showMessageDialog(this, "Please choose line file", "Line File", JOptionPane.INFORMATION_MESSAGE);
            Result = window.showOpenDialog(this);
            if(Result == JFileChooser.APPROVE_OPTION)
                LinePath = window.getSelectedFile().getPath();

            loadFile(HeaderPath, LinePath);
        }
        else if( e.getActionCommand().equals("Save File") ){
            String FolderPath = null;

            JFileChooser window = new JFileChooser();
            JOptionPane.showMessageDialog(this, "Please choose FOLDER to save data into", "Save data", JOptionPane.INFORMATION_MESSAGE);
            window.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int Result = window.showOpenDialog(this);
            if(Result == JFileChooser.APPROVE_OPTION)
                FolderPath = window.getSelectedFile().getPath();

            try{
                saveFile(FolderPath);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Save exception", "Test", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if( e.getActionCommand().equals("Create new inovice") ){
            createInvoiceDialog();
        }
        else if( e.getActionCommand().equals("Delete inovice") ){
            deleteInovice(FileData, HeaderModel);
        }
        else if( e.getActionCommand().equals("Create Inovice") ){
            String CustomerName = CreateInvDialog.getName();
            String Date = CreateInvDialog.getDate();

            java.util.Date InoviceDate = new Date();
            try{
                InoviceDate = new SimpleDateFormat("dd-MM-yyyy").parse( Date );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Invalid date: Setting date to current date", "Invalid date notice", JOptionPane.INFORMATION_MESSAGE);
            }

            InoviceHeader NewInovice = new InoviceHeader(FileData.size(), InoviceDate, CustomerName);
            FileData.add(NewInovice);
            updateHeaderTable(FileData, HeaderModel);
        }
        else if( e.getActionCommand().equals("Cancel Inovice") ){
            CreateInvDialog.setVisible(false);
            CreateInvDialog.dispose();
        }
        else if( e.getActionCommand().equals("Create new line")) {
            createItemDialog();
        }
        else if( e.getActionCommand().equals("Delete line")) {
            deleteLine( (DefaultTableModel)LineTable.getModel() );
        }
        else if( e.getActionCommand().equals("Create Line") ){
            String ItemPriceString = CreateLineDialog.getPrice();
            String ItemCountString = CreateLineDialog.getCount();

            String ItemName = CreateLineDialog.getName();
            float ItemPrice = Float.parseFloat(ItemPriceString);
            int ItemCount = Integer.parseInt(ItemCountString);

            InoviceLine NewLine = new InoviceLine( SelectedInv.getInoviceNumber(), ItemName, ItemPrice, ItemCount);
            SelectedInv.getLines().add(NewLine);

            updateHeaderTable(FileData, HeaderModel);
            updateHeaderLabels(SelectedInv);
            updateLineTable(SelectedInv);
        }
        else if( e.getActionCommand().equals("Cancel Line") ){
            CreateLineDialog.setVisible(false);
            CreateLineDialog.dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Test", "Test", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        if(FileData != null && FileData.size() != 0 && HeaderTable.getSelectedRow() != -1)
            SelectedInv = FileData.get(HeaderTable.getSelectedRow());

        updateHeaderLabels(SelectedInv);
        updateLineTable(SelectedInv);
        //JOptionPane.showMessageDialog(this, InvNum, "Header File", JOptionPane.INFORMATION_MESSAGE);

    }


    private void loadFile(String HeaderPath, String LinePath){
        try {
            FileData = controller.readFile(HeaderPath, LinePath);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Load file exception", "Invalid date notice", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        clearHeaderData(HeaderModel);
        updateHeaderTable(FileData, HeaderModel);
    }

    private void saveFile(String FolderPath) throws Exception{
        controller.writeFile(FileData, FolderPath);
    }

    private void deleteInovice(ArrayList<InoviceHeader> Headers, DefaultTableModel Model){
        if(SelectedInv != null && HeaderTable.getSelectedRow() != -1){
            Headers.remove(HeaderTable.getSelectedRow());
            Model.removeRow(HeaderTable.getSelectedRow());

            SelectedInv = null;
            updateHeaderLabels(SelectedInv);
            updateLineTable(SelectedInv);
        }
    }

    private void updateHeaderTable(ArrayList<InoviceHeader> Headers, DefaultTableModel Model){
        String [][] Data = new String[Headers.size()][4];

        for(int count = 0; count < Data.length ;count++){
            Data[count] = new String[]{
                    String.valueOf(Headers.get(count).getInoviceNumber()),
                    String.valueOf(new SimpleDateFormat("dd-M-yyyy").format(Headers.get(count).getInoviceDate() )),
                    Headers.get(count).getCustomerName(),
                    String.valueOf(Headers.get(count).getTotal()),
            };
        }

        Model = new DefaultTableModel(Data, new String [] {"Inovice Number", "Invoice Date", "Customer Name", "Total"});
        HeaderModel = Model;
        HeaderTable.setModel(Model);

    }

    private void updateLineTable(InoviceHeader Header){
        String[] col = {"No.", "Item name", "Item price", "Count", "Item total"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        if(Header != null){
            ArrayList<InoviceLine> Lines = Header.getLines();
            if(Lines != null && Lines.size() != 0)
                for(InoviceLine Line: Lines){
                    Object[] obj = {Line.getInoviceNumber(), Line.getItemName(), Line.getItemPrice(), Line.getItemCount(), Line.getItemTotal()};
                    tableModel.addRow(obj);
                }
        }
        LineTable.setModel(tableModel);

    }

    private void updateHeaderLabels(InoviceHeader SelectedHeader) {
        if(SelectedHeader != null){
            InoviceNumber.setText(Integer.toString(SelectedHeader.getInoviceNumber()));
            DateTextPane.setText(new SimpleDateFormat("dd-M-yyyy").format(SelectedHeader.getInoviceDate() ));
            NameTextPane.setText(SelectedHeader.getCustomerName());
            InoviceTotal.setText(Float.toString(SelectedHeader.getTotal()));
        }else{
            InoviceNumber.setText("");
            DateTextPane.setText("");
            NameTextPane.setText("");
            InoviceTotal.setText("");
        }
    }

    private void clearHeaderData(DefaultTableModel Model){
        HeaderTable.clearSelection();
        SelectedInv = null;
        while(Model.getRowCount() != 0)
            Model.removeRow(0);
    }

    private void save() {
        Date InoviceDate = null;
        try{
            InoviceDate = new SimpleDateFormat("dd-MM-yyyy").parse( DateTextPane.getText() );
        }catch(Exception ex){}
        String CustomerName = NameTextPane.getText();

        if(SelectedInv != null){
            SelectedInv.setCustomerName(CustomerName);
            SelectedInv.setDate(InoviceDate);
        }

        updateHeaderTable(FileData, HeaderModel);
        updateHeaderLabels(SelectedInv);
    }

    private void createInvoiceDialog() {
        CreateInvDialog = new CreateInoviceDialog(this, true);
        CreateInvDialog.setVisible(true);
    }

    private void createItemDialog() {
        if(SelectedInv != null){
            CreateLineDialog = new  CreateItemDialog(this, true);
            CreateLineDialog.setVisible(true);
        }
    }

    private void deleteLine(DefaultTableModel Model){
        if(SelectedInv != null && SelectedLine != null && HeaderTable.getSelectedRow() > -1 && LineTable.getSelectedRow() > -1){
            SelectedInv.getLines().remove(LineTable.getSelectedRow());
            Model.removeRow(LineTable.getSelectedRow());

            SelectedLine = null;
            updateHeaderTable(FileData, HeaderModel);
            updateHeaderLabels(SelectedInv);
            updateLineTable(SelectedInv);
        }
    }

}