
 
package my_package;

import java.awt.HeadlessException;import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Finalpage extends javax.swing.JFrame {
    
    public static int fare;
    static String source="";
    static String destination="";
   
    public Finalpage(String from1,String to1) {
        source  = from1;
        destination = to1;
       
        initComponents();
         findflights();
       
    }
    public ArrayList<Flights> ListFlights(String src){
        ArrayList<Flights> flightslist=new ArrayList<>();
                
        
                try{
            Class.forName("com.mysql.jdbc.Driver");
            
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","")) {
                String query;
                query = "SELECT * FROM `flights` WHERE CONCAT(`Source`, `Destination`)LIKE'%"+this.source+"%"+this.destination+"%'";
                ResultSet rs;
                Statement st=con.createStatement();
                rs = st.executeQuery(query);
            
               while(rs.next()){
                        Flights flights=new Flights(rs.getString("Name"),
                                rs.getString("Source"),
                                rs.getString("Destination"),
                                rs.getInt("Duration"),
                                rs.getInt("Fare"));
                        flightslist.add(flights);
                }
                
                    
               
//                else{
//                    JOptionPane.showMessageDialog( null,"Sorry!There are no flights available for this route!"  );
//                    
//                }
            }
       
        }

        catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog( null,e );
        }

         return flightslist;
    }
    public void findflights(){
        Bookingpage obj=new Bookingpage();
        
        
        ArrayList<Flights> flights=ListFlights(obj.from.getSelectedItem().toString());
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Name","Source","Destination","Duration(in Hrs)","Fare(Per Ticket)"});
        Object[] row=new Object[5];
         
        for(int i=0;i<flights.size();i++){
           
         
            row[0]=flights.get(i).getName();
            row[1]=flights.get(i).getSource();
            row[2]=flights.get(i).getDestination();
            row[3]=flights.get(i).getDuration();
            row[4]=flights.get(i).getFare();
            
            model.addRow(row);
            
        }
        maintable.setModel(model);
        
        
       
    }
    
    
   

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        book = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(420, 190));
        setResizable(false);

        book.setText("BOOK");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        maintable.setAutoCreateRowSorter(true);
        maintable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        maintable.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        maintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Source", "Destination", "Duration(in Hrs)", "Fare(Per Ticket)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        maintable.setRowHeight(30);
        maintable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        maintable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        maintable.setShowGrid(false);
        maintable.setUpdateSelectionOnSort(false);
        maintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintableMouseClicked(evt);
            }
        });
        maintable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                maintablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(maintable);
        maintable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
        
    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed
        // TODO add your handling code here:
        int index=maintable.getSelectedRow();
       TableModel model=maintable.getModel();
       fare = 0;
       if(index!=-1){
        String name=(String) model.getValueAt(index,0);
        String source=(String) model.getValueAt(index,1);
        String destination=(String) model.getValueAt(index,2);
        fare =(Integer)model.getValueAt(index,4);
        JOptionPane.showMessageDialog( null,"Your flight of "+name+" from "+source+" to "+destination+" is successfully booked!"  ); 
        SendEmailSMTP obj123 = new SendEmailSMTP();
        System.out.println(Loginpage.email_id);
       }
       else{
           JOptionPane.showMessageDialog( null,"You can't fly on your own , book atleast one flight!" );
       }
    }//GEN-LAST:event_bookActionPerformed

    private void maintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintableMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_maintableMouseClicked

    private void maintablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_maintablePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_maintablePropertyChange

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new Finalpage(source,destination).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton book;
    public javax.swing.JButton jButton2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JTable maintable = new javax.swing.JTable();
    // End of variables declaration//GEN-END:variables
}
