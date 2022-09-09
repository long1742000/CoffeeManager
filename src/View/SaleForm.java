/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BillDetailDAO;
import Controller.CustomerDAO;
import Controller.DishDAO;
import Controller.EmployeeDAO;
import Controller.ImportDAO;
import Controller.ProductDAO;
import Model.Dish;
import Model.Import;
import Model.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class SaleForm extends javax.swing.JFrame {

    private SaleForm() {
        
    }

    /**
     * Creates new form SaleForm
     */
    private static java.sql.Date convertDate(java.util.Date date){              // hàm parse kiểu ngày tháng UTIL ra ngày tháng của SQL
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public void loadData(int id){                                               // Tải dữ liệu từ bảng Dish lên (tải theo CategoryID)
        DefaultTableModel model = (DefaultTableModel)tbl_dish.getModel();
        DishDAO dishDAO = new DishDAO();
        ArrayList<Dish> list = dishDAO.getByCategoryID(id);
        int count = model.getRowCount();
        while(count>0){
            model.removeRow(count-1);
            count--;
        }
        for(Dish item:list){
            Object[] row = {item.getID(), item.getName()};
            model.addRow(row);
        }
    }
    
    public void loadProduct(int id, int s, int quan){                               // Tải dữ liệu từ bảng Product lên (tải theo DishID + SizeID)
        DefaultTableModel model = (DefaultTableModel)tbl_product.getModel();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getBySize(id, s);
        
        Object row[] = new Object[5];
        row[0] = product.getID();
        row[1] = product.getDish().getName();
        row[2] = product.getSize().getName();
        row[3] = quan;
        row[4] = product.getPrice()*quan;
        
        model.addRow(row);       
        
    }
    
    public void loadExchange(int id){                                                   // Tải cái Sản phẩm đã được Exchange lên (lấy theo idEx)
        DefaultTableModel model = (DefaultTableModel)tbl_product.getModel();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getbyID(id);
        
        Object row[] = new Object[5];
        row[0] = product.getID();
        row[1] = product.getDish().getName();
        row[2] = product.getSize().getName();
        row[3] = 1;
        row[4] = 0;                         // sản phẩm đổi thì set Price = 0 (vì tốn Points để đổi r)
        
        model.addRow(row);       
        
    }
    
    public static boolean checkTime(){                                      // Hàm kiểm tra giờ để set cái shift (ca làm)
        LocalTime now = LocalTime.now();                    // tạo biến lấy giờ hiện tại
        String time = now.toString();                       // ép nó thành String xài cho dễ
        int hour = Integer.parseInt(time.substring(0, 2));      // tạo 2 cái biến rồi gán mỗi cái 1 giá trị (giờ + phút)
        int min = Integer.parseInt(time.substring(3, 5));
        if(hour == 14){                                         // nếu đang là 14h thì có 2 trường hợp
            if(min==0) return true;             // 1 là phút = 0 => 14:00 (vẫn là ca 1)
            else return false;                  // 2 là phút nó != 0 => ca 2
        }
        else if(hour < 6 || hour > 14){         // còn nếu giờ < 6 hoặc > 14 thì nó là ca 2
            return false;
        }
        return true;
    }
    
    public SaleForm(int idEmployee, int idCustomer, int totalAllDay, int cash, int momo, int vnPay, int discount, int idEx) {
        EmployeeDAO emDAO = new EmployeeDAO();
        CustomerDAO cusDAO = new CustomerDAO();
        ProductDAO proDAO = new ProductDAO();
        initComponents();
        this.setLocationRelativeTo(null);
        if(checkTime()) lbl_shift.setText("1");             // xài hàm check giờ coi đang là ca nào
        else lbl_shift.setText("2");
        loadData(1);                                        // cứ mở lên là auto tải Product có CategoryID = 1 (Coffee)
        lbl_idEx.setText(String.valueOf(idEx));
        if(idEx!=0){                                        // nếu như idEx != 0 => thằng khách đã exchagne 1 sản phẩm nào đó
            Product pro = proDAO.getbyID(idEx);             
            loadExchange(idEx);                             // thì tải nó lên đầu
        }
        lbl_cash.setText(String.valueOf(cash));
        lbl_momo.setText(String.valueOf(momo));
        lbl_vnpay.setText(String.valueOf(vnPay));
        lbl_discount.setText(String.valueOf(discount));
        lbl_totalAllDay.setText(String.valueOf(totalAllDay));
        lbl_employee.setText(String.valueOf(emDAO.getByID(idEmployee).getUsername()));
        if(idCustomer==0 || idCustomer==36){                // nếu chưa có chọn member
            but_member.setText("Member");                   // thì nút Member sẽ hiện chữ "Member"
        }
        else{
            but_member.setText(String.valueOf(cusDAO.getById(idCustomer).getID()));         // còn nếu đã chọn member rồi thì nút member hiện lên ID của thằng member đó
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        but_cate1 = new javax.swing.JButton();
        but_cate2 = new javax.swing.JButton();
        but_cate3 = new javax.swing.JButton();
        but_cate4 = new javax.swing.JButton();
        but_cate5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        but_member = new javax.swing.JButton();
        but_addQuantity = new javax.swing.JButton();
        but_delete = new javax.swing.JButton();
        but_addBill = new javax.swing.JButton();
        but_allDay = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_totalAllDay = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        but_warehouse = new javax.swing.JButton();
        chk_warehouse = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_shift = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dish = new javax.swing.JTable();
        lbl_employee = new javax.swing.JLabel();
        lbl_shift1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_cash = new javax.swing.JLabel();
        lbl_momo = new javax.swing.JLabel();
        lbl_vnpay = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        lbl_idEx = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        but_cate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_cate1.setText("Coffee");
        but_cate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cate1ActionPerformed(evt);
            }
        });

        but_cate2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_cate2.setText("Tea");
        but_cate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cate2ActionPerformed(evt);
            }
        });

        but_cate3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_cate3.setText("Milk tea");
        but_cate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cate3ActionPerformed(evt);
            }
        });

        but_cate4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_cate4.setText("Yogurt");
        but_cate4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cate4ActionPerformed(evt);
            }
        });

        but_cate5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_cate5.setText("Cake");
        but_cate5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_cate5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(but_cate5, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(but_cate4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_cate3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(but_cate2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(but_cate1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but_cate1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cate2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cate3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cate4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_cate5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        but_member.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_member.setText("Member");
        but_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_memberActionPerformed(evt);
            }
        });

        but_addQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_addQuantity.setText("Add quantity");
        but_addQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_addQuantityActionPerformed(evt);
            }
        });

        but_delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_delete.setText("Detele");
        but_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_deleteActionPerformed(evt);
            }
        });

        but_addBill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        but_addBill.setText("Add Bill");
        but_addBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_addBillActionPerformed(evt);
            }
        });

        but_allDay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_allDay.setText("Lock shift ");
        but_allDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_allDayActionPerformed(evt);
            }
        });

        jLabel4.setText("All day:");

        lbl_totalAllDay.setBackground(new java.awt.Color(255, 255, 255));
        lbl_totalAllDay.setText("0");

        jLabel6.setText("VND");

        but_warehouse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        but_warehouse.setText("Import");
        but_warehouse.setEnabled(false);
        but_warehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_warehouseActionPerformed(evt);
            }
        });

        chk_warehouse.setBackground(new java.awt.Color(255, 255, 255));
        chk_warehouse.setText("Warehouse access");
        chk_warehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_warehouseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_addBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(but_allDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(but_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(but_addQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(but_member, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_totalAllDay, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(but_warehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chk_warehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(but_member, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_addQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(but_addBill, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbl_totalAllDay)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(but_allDay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_warehouse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(but_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Shift:");

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_total.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("VND");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total:");

        lbl_shift.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_shift.setText("1");

        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Size", "Quantity", "Price"
            }
        ));
        jScrollPane3.setViewportView(tbl_product);
        if (tbl_product.getColumnModel().getColumnCount() > 0) {
            tbl_product.getColumnModel().getColumn(0).setMinWidth(70);
            tbl_product.getColumnModel().getColumn(0).setMaxWidth(70);
            tbl_product.getColumnModel().getColumn(2).setMinWidth(70);
            tbl_product.getColumnModel().getColumn(2).setMaxWidth(70);
            tbl_product.getColumnModel().getColumn(3).setMinWidth(70);
            tbl_product.getColumnModel().getColumn(3).setMaxWidth(70);
            tbl_product.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_product.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        tbl_dish.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_dish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        tbl_dish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dishMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_dish);
        if (tbl_dish.getColumnModel().getColumnCount() > 0) {
            tbl_dish.getColumnModel().getColumn(0).setMinWidth(70);
            tbl_dish.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        lbl_employee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_employee.setText("Username");

        lbl_shift1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_shift1.setText("-");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_cash.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cash.setText("cash");

        lbl_momo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_momo.setText("momo");

        lbl_vnpay.setForeground(new java.awt.Color(255, 255, 255));
        lbl_vnpay.setText("vnpay");

        lbl_discount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_discount.setText("discount");

        lbl_idEx.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idEx.setText("idEx");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lbl_cash)
                .addGap(113, 113, 113)
                .addComponent(lbl_momo)
                .addGap(97, 97, 97)
                .addComponent(lbl_vnpay)
                .addGap(113, 113, 113)
                .addComponent(lbl_discount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_idEx)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cash)
                    .addComponent(lbl_momo)
                    .addComponent(lbl_vnpay)
                    .addComponent(lbl_discount)
                    .addComponent(lbl_idEx))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_shift)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_shift1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_employee))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_total)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(lbl_shift)
                                .addComponent(lbl_shift1)
                                .addComponent(lbl_employee)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_addQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_addQuantityActionPerformed
        // Nút + quantity
        int total = Integer.parseInt(lbl_total.getText());
        DefaultTableModel model = (DefaultTableModel)tbl_product.getModel();
        int row = tbl_product.getSelectedRow();
        if(row == -1){                                                              // chưa chọn sản phẩm để add mà đòi add ?????
            JOptionPane.showMessageDialog(this, "What do you want to add?");
        }
        else{                                                   // chọn rồi thì add thôi :V 
            int id = (int) model.getValueAt(row, 0);
            ProductDAO productDAO = new ProductDAO();
            int price = productDAO.getbyID(id).getPrice();
            int quan = (int) model.getValueAt(row, 3) +1;           // quantity +1 lên sau mỗi lần nhấn
            int price2 = price*quan;                        // tiền cũng tăng lên sau mỗi lần nhấn
            model.setValueAt(quan, row, 3);
            model.setValueAt(price2, row, 4);
            
            total += price;                                 // total cũng tăng lên sau mỗi lần nhấn 
            lbl_total.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_but_addQuantityActionPerformed

    private void but_cate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cate1ActionPerformed
        // nút Coffee
        int id = 1;                     // đưa CategoryID = 1
        loadData(id);
    }//GEN-LAST:event_but_cate1ActionPerformed

    private void but_cate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cate2ActionPerformed
        // nút Tea
        int id = 2;                     // đưa CategoryID = 2
        loadData(id);
    }//GEN-LAST:event_but_cate2ActionPerformed

    private void but_cate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cate3ActionPerformed
        // nút Milk tea
        int id = 3;                     // đưa CategoryID = 3
        loadData(id);
    }//GEN-LAST:event_but_cate3ActionPerformed

    private void but_cate4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cate4ActionPerformed
        // nút Yogurt
        int id = 4;                    // đưa CategoryID = 4
        loadData(id);
    }//GEN-LAST:event_but_cate4ActionPerformed

    private void but_cate5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_cate5ActionPerformed
        // nút Cake
        int id = 5;                     // đưa CategoryID = 5
        loadData(id);
    }//GEN-LAST:event_but_cate5ActionPerformed

    private void tbl_dishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dishMouseClicked
        // nhấn zô 1 Dish nào đó
        int total=0;
        int row = tbl_dish.getSelectedRow();
        int choose;
        TableModel table = tbl_dish.getModel();
        TableModel tableProduct = tbl_product.getModel();
        int id = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
        String [] size={"S", "M", "L"};                                             // tạo 1 mảng chứa các loại Size
        int s = JOptionPane.showOptionDialog(null, "Choose size", "Size...", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, size, null);    // show cái bảng chọn Size lên
        if(s==0){                       // chọn S
            choose = 1;                 // thì xuất Product có DishID = id, SizeID = choose, Quantity = 1 lên
            loadProduct(id, choose, 1);
        }
        else if(s==1){                  // Tương tự chọn M
            choose = 2;
            loadProduct(id, choose, 1);
        }
        else if(s==2){                  // Tương tự chọn L
            choose = 3;
            loadProduct(id, choose, 1);
        }

        for(int i=0;i<tableProduct.getRowCount(); i++){                                         // Dùng vòng lặp For để tính tổng Price các Product đã chọn
            int price = Integer.parseInt(String.valueOf(tableProduct.getValueAt(i, 4)));
            total += price;
        }
        lbl_total.setText(String.valueOf(total));
    }//GEN-LAST:event_tbl_dishMouseClicked

    private void but_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_deleteActionPerformed
        // nút Delete quantity
        ProductDAO productDAO = new ProductDAO();
        int total = Integer.parseInt(lbl_total.getText());
        DefaultTableModel model = (DefaultTableModel)tbl_product.getModel();
    
        if(tbl_product.getSelectedRowCount()==1){
            int row = tbl_product.getSelectedRow();
            int quan = (int) model.getValueAt(row, 3);
            int id = (int) model.getValueAt(row, 0); 
            if(row==-1){                                                                    // chưa chọn mà đòi xoá ?????
                JOptionPane.showMessageDialog(this, "Please choose 1 row to delete");
            }
            else{                                                   // chọn rồi thì oke thôi :V 
                int price = productDAO.getbyID(id).getPrice();
                if(quan==0){                                        // nếu mà quantity = 0 thì xoá luôn dòng đó 
                    model.removeRow(row);
                    row = tbl_product.getSelectedRow();
                }
                else{
                    quan = quan-1;                                  // còn bình thường thì cứ -1 đi                  
                }   
                int price2 = (int) model.getValueAt(row, 4);        // biến này = cái Price lúc chưa Delete
                int price3 = price2-price;                          // cứ nhấn 1 cái là trừ Price đi
                model.setValueAt(quan, row, 3);
                model.setValueAt(price3, row, 4);
            
                total -= price;                                     // Tổng tiền các sản phẩm cũng tự động trừ theo
                lbl_total.setText(String.valueOf(total));
            } 
        }
        else{
            if(tbl_product.getRowCount()==0){                                               // chưa có cái gì mà đòi xoá ?? xoá bằng niềm tin à 
                JOptionPane.showMessageDialog(this, "Don't have any product to delete");
            }
            else{                                                                           // có dữ liệu rồi mà ko chọn ??? xoá cái j ???
                JOptionPane.showMessageDialog(this, "Please choose 1 row to delete");
            }
        }
    }//GEN-LAST:event_but_deleteActionPerformed

    private void but_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_memberActionPerformed
        // nút Members
        int totalAllDay = Integer.parseInt(lbl_totalAllDay.getText());              // tạo mấy cái biến để giữ dữ liệu (xí đem qua SaleAllDay xài)
        int cash, momo, vnPay, discount, idEx;
        cash = Integer.parseInt(lbl_cash.getText());
        momo = Integer.parseInt(lbl_momo.getText());
        vnPay = Integer.parseInt(lbl_vnpay.getText());
        discount = Integer.parseInt(lbl_discount.getText());
        idEx = Integer.parseInt(lbl_idEx.getText());
        EmployeeDAO emDAO = new EmployeeDAO();
        MemberForm m = new MemberForm(Integer.parseInt(String.valueOf(emDAO.getByUsername(lbl_employee.getText()).getID())), 0, totalAllDay, cash, momo, vnPay, discount, idEx);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_but_memberActionPerformed

    private void but_addBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_addBillActionPerformed
        // Nút add bill
        BillDetailDAO bDAO = new BillDetailDAO();
        TableModel model1 = tbl_product.getModel();
        DefaultTableModel model = (DefaultTableModel)tbl_product.getModel();
        
        if(tbl_product.getRowCount()==0){                   // chưa chọn sản phẩm nào mà đòi add bill ??? thế không mua mà add bill à ??
            JOptionPane.showMessageDialog(this, "Don't have any product to add bill");        
        }
        else{
            EmployeeDAO emDAO = new EmployeeDAO();
            int total = Integer.parseInt(lbl_total.getText());
            int idEmployee = emDAO.getByUsername(lbl_employee.getText()).getID();
            int idCustomer;
            if(but_member.getText().equals("Member")){                          // nếu mà cái nút Member vẫn = Member thì oke cho Bill mặc định là khách mua
                idCustomer = 0;
            }
            else{
                idCustomer = Integer.parseInt(but_member.getText());            // còn có ID thì oke lấy ID này xài thôi :V
            }
            
            // add dữ liệu từ tbl_product vào BillDetail    
                 
            int productID, billID, quantity;                    // tạo các biến để chuẩn bị add dữ liệu zô Bill detail
            boolean status;

            for(int i=0; i<tbl_product.getRowCount(); i++){
                productID = Integer.parseInt(String.valueOf(tbl_product.getValueAt(i, 0)));
                quantity = Integer.parseInt(String.valueOf(tbl_product.getValueAt(i, 3)));
                billID = 43;                                        // Hiện tại chưa có Bill nào để gán vào, oke vất hết vô value rác trong bảng Bill (có ID = 43 trong database)
                status = true;
                bDAO.add(billID, productID, quantity, status);          // cứ thế mà add thôi :V
            }         
            
            
            // gói mấy biến này lại để xí đem qua SaleAllDay xài cho dễ
            int totalAllDay = Integer.parseInt(lbl_totalAllDay.getText());
            
            int cash, momo, vnPay, discount;
            cash = Integer.parseInt(lbl_cash.getText());
            momo = Integer.parseInt(lbl_momo.getText());
            vnPay = Integer.parseInt(lbl_vnpay.getText());
            discount = Integer.parseInt(lbl_discount.getText());
            int idEx =Integer.parseInt(lbl_idEx.getText());
            
            AddBillForm a = new AddBillForm(total, idEmployee, idCustomer, totalAllDay, cash, momo, vnPay, discount, idEx);
            a.setVisible(true);
            a.setLocationRelativeTo(null);
            this.dispose();
        }     
    }//GEN-LAST:event_but_addBillActionPerformed

    private void but_allDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_allDayActionPerformed
        // Nút check coi hôm nay bán được bao nhiêu 
        
        String user = lbl_employee.getText();
        int shift = Integer.parseInt(lbl_shift.getText());
        int cash = Integer.parseInt(lbl_cash.getText());
        int momo = Integer.parseInt(lbl_momo.getText());
        int vnpay = Integer.parseInt(lbl_vnpay.getText());
        int discount = Integer.parseInt(lbl_discount.getText());
        int total = Integer.parseInt(lbl_totalAllDay.getText());
        int idEx = Integer.parseInt(lbl_idEx.getText());
        LockShiftForm l = new LockShiftForm(user, shift, cash, momo, vnpay, discount, total, idEx);           // giờ đem mấy biến từ nãy giờ gán vào gửi qua Form LockShift xài thôi :V
        l.setLocationRelativeTo(null);
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_but_allDayActionPerformed

    private void but_warehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_warehouseActionPerformed
        try {
            // Nút nhập hàng
            Calendar cal = new GregorianCalendar();
            EmployeeDAO emDAO = new EmployeeDAO();
            ImportDAO impDAO = new ImportDAO();
            String user = lbl_employee.getText();
            
            // Lấy ID Employee
            int idEmployee = emDAO.getByUsername(user).getID();
            
            // Lấy date hiện tại
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            String month = String.valueOf(cal.get(Calendar.MONTH)+1);
            String year = String.valueOf(cal.get(Calendar.YEAR));
            Date strDate = sdf.parse(year+"-"+month+"-"+day);
            
            // Thêm dữ liệu zô Import
            Import imp = new Import();
            imp.setEmployeeID(idEmployee);
            imp.setDateCreate(convertDate(strDate));
            impDAO.add(imp);
            
            ImportForm i = new ImportForm();
            i.setVisible(true);
            i.setLocationRelativeTo(null);
        } catch (ParseException ex) {
            Logger.getLogger(SaleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_but_warehouseActionPerformed

    private void chk_warehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_warehouseActionPerformed
        // TODO add your handling code here:
        if(chk_warehouse.isSelected()){
            but_warehouse.setEnabled(true);
        }
        else{
            but_warehouse.setEnabled(false);
        }
    }//GEN-LAST:event_chk_warehouseActionPerformed

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
            java.util.logging.Logger.getLogger(SaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but_addBill;
    private javax.swing.JButton but_addQuantity;
    private javax.swing.JButton but_allDay;
    private javax.swing.JButton but_cate1;
    private javax.swing.JButton but_cate2;
    private javax.swing.JButton but_cate3;
    private javax.swing.JButton but_cate4;
    private javax.swing.JButton but_cate5;
    private javax.swing.JButton but_delete;
    private javax.swing.JButton but_member;
    private javax.swing.JButton but_warehouse;
    private javax.swing.JCheckBox chk_warehouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_cash;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_employee;
    private javax.swing.JLabel lbl_idEx;
    private javax.swing.JLabel lbl_momo;
    private javax.swing.JLabel lbl_shift;
    private javax.swing.JLabel lbl_shift1;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalAllDay;
    private javax.swing.JLabel lbl_vnpay;
    private javax.swing.JTable tbl_dish;
    private javax.swing.JTable tbl_product;
    // End of variables declaration//GEN-END:variables
}
