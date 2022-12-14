/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.EmployeeDAO;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AccountDetailForm extends javax.swing.JFrame {

    /**
     * Creates new form AccountDetailForm
     */
    public AccountDetailForm(int id) {
        EmployeeDAO empDAO = new EmployeeDAO();
        initComponents();
        String name = empDAO.getByID(id).getFullName();                         // lấy thông tin của Account vừa dc click vào
        String username = empDAO.getByID(id).getUsername();
        String card = empDAO.getByID(id).getIndentityCard();
        String phone = empDAO.getByID(id).getPhoneNumber();
        String email = empDAO.getByID(id).getEmail();
        String address = empDAO.getByID(id).getAddress();
        txt_name.setText(name);
        txt_username.setText(username);
        txt_card.setText(card);
        txt_phone.setText(phone);
        txt_email.setText(email);
        txt_address.setText(address);
        if(empDAO.getByID(id).isStatus()){
            but_negative.setEnabled(true);                                      // nếu nhân viên này đã nghỉ rồi thì enabled nút "huỷ" đi
        }
    }

    private AccountDetailForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_card = new javax.swing.JTextField();
        but_x = new javax.swing.JButton();
        but_email = new javax.swing.JButton();
        but_address = new javax.swing.JButton();
        but_phone = new javax.swing.JButton();
        but_update = new javax.swing.JButton();
        but_negative = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Full name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Phone number:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Address:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Indentity card:");

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_name.setEnabled(false);

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_username.setEnabled(false);

        txt_phone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_phone.setEnabled(false);
        txt_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_phoneKeyTyped(evt);
            }
        });

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_address.setEnabled(false);

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_email.setEnabled(false);

        txt_card.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_card.setEnabled(false);

        but_x.setText("x");
        but_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_xActionPerformed(evt);
            }
        });

        but_email.setText("Edit");
        but_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_emailActionPerformed(evt);
            }
        });

        but_address.setText("Edit");
        but_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_addressActionPerformed(evt);
            }
        });

        but_phone.setText("Edit");
        but_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_phoneActionPerformed(evt);
            }
        });

        but_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        but_update.setText("Update");
        but_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_updateActionPerformed(evt);
            }
        });

        but_negative.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        but_negative.setText("Negative");
        but_negative.setEnabled(false);
        but_negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_negativeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_email))
                    .addComponent(txt_card, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_phone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_address)))
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(but_x, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(but_update, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(but_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but_x)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_phoneActionPerformed
        // nút edit phone
        txt_phone.setEnabled(true);
    }//GEN-LAST:event_but_phoneActionPerformed

    private void but_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_emailActionPerformed
        // nút edit email
        txt_email.setEnabled(true);
    }//GEN-LAST:event_but_emailActionPerformed

    private void but_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_addressActionPerformed
        // nút edit address
        txt_address.setEnabled(true);
    }//GEN-LAST:event_but_addressActionPerformed

    private void but_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_updateActionPerformed
        // nút update
        EmployeeDAO empDAO = new EmployeeDAO();
        String user = txt_username.getText();                                   // lấy thông tin ra trc r tính 
        String phone = txt_phone.getText();
        String email = txt_email.getText();
        String address = txt_address.getText();
        int id = empDAO.getByUsername(user).getID();
        if(phone.length()==0 || email.length()==0 || address.length()==0){                  // edit thông tin nhân viên r xoá luôn thông tin nhân viên ????
            JOptionPane.showMessageDialog(this, "You cannot delete personal information");
        }
        else{
            String regexEmail="[\\w]*[0-9]*[@][\\w]*[.][\\w]*";             // tạo 1 cái biến check email
            String regexPhone="^(03|05|07|08|09)+[0-9]{8}$";                // tạo 1 cái biến check phone
            boolean check=false;                                            // biến check email coi true hay fasle 
            boolean check1=false;                                           // biến check phone coi true hay fasle
            Pattern pattern = Pattern.compile(regexEmail);
            Pattern pattern1 = Pattern.compile(regexPhone);
            Matcher matcher = pattern.matcher(email);
            Matcher matcher1 = pattern1.matcher(phone);
            check=matcher.find();
            check1=matcher1.find();
            if(check==false){                                          // nếu mà điền ko đúng loại email thì bắt nhập lại 
                JOptionPane.showMessageDialog(this, "Please input another email (Email by format asd123@def.com)");
            }
            else if(check1==false){                                         //  nếu mà sđt tào lao thì bắt nhập lại 
                JOptionPane.showMessageDialog(this, "Invalid phone number");
            }
            else{                                                          // oke hết rồi thì triển thôi :V
                JOptionPane.showMessageDialog(this, "Success");
                empDAO.edit(phone, address, email, id);
                txt_phone.setEnabled(false);
                txt_email.setEnabled(false);
                txt_address.setEnabled(false);
            }
        }
    }//GEN-LAST:event_but_updateActionPerformed

    private void but_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_xActionPerformed
        // nút tắt
        this.dispose();
    }//GEN-LAST:event_but_xActionPerformed

    private void but_negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_negativeActionPerformed
        // nút huỷ
        String user = txt_username.getText();
        EmployeeDAO empDAO = new EmployeeDAO();
        int id = empDAO.getByUsername(user).getID();
        int status = 0;
        empDAO.negative(status, id);
        but_negative.setEnabled(false);
    }//GEN-LAST:event_but_negativeActionPerformed

    private void txt_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phoneKeyTyped
        // ràng buộc text, chỉ được nhập số
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
    }//GEN-LAST:event_txt_phoneKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountDetailForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountDetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_address;
    private javax.swing.JButton but_email;
    private javax.swing.JButton but_negative;
    private javax.swing.JButton but_phone;
    private javax.swing.JButton but_update;
    private javax.swing.JButton but_x;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_card;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
