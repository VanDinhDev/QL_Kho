/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.ConvertDate;
import dao.MayTinhDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import dao.ThongKeDAO;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.PhieuNhap;
import java.util.Iterator;
import model.Phieu;
import model.PhieuXuat;
import model.ThongKeProduct;

/**
 *
 * @author VanDinh
 */
public class ThongKeForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public ThongKeForm() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        jDateChooserFrom.setDateFormatString("dd/MM/yyyy");
        jDateChooserTo.setDateFormatString("dd/MM/yyyy");
        jDateChooserFromPr.setDateFormatString("dd/MM/yyyy");
        jDateChooserToPr.setDateFormatString("dd/MM/yyyy");
        txtQuantityProduct.setText(Integer.toString(MayTinhDAO.getInstance().getSl()));
     
        initTable();
        loadDataToTable();
        changeTextFind();
        //
        tblThongKeProduct.setDefaultEditor(Object.class, null);
        tblPhieuNhap.setDefaultEditor(Object.class, null);
        //
        loadDataToTableThongKeProduct(ThongKeDAO.getInstance().getThongKe());
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phiếu nhập", "Người tạo", "Thời gian tạo", "Tổng tiền"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblPhieuNhap.setModel(tblModel);
        tblPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(5);
    }

    private void loadDataToTable() {
        try {
            ArrayList<PhieuNhap> allPhieu = PhieuNhapDAO.getInstance().selectAll();
            tblModel.setRowCount(0);
            for (int i = 0; i < allPhieu.size(); i++) {
                tblModel.addRow(new Object[]{
                    allPhieu.get(i).getMaPhieu(), allPhieu.get(i).getNguoiTao(), formatDate.format(allPhieu.get(i).getThoiGianTao()), formatter.format(allPhieu.get(i).getTongTien()) + "đ"
                });
            }
        } catch (Exception e) {
        }
    }

    private void loadDataToTableSearch(ArrayList<Phieu> result) {
        try {
            tblModel.setRowCount(0);
            for (int i = 0; i < result.size(); i++) {
                tblModel.addRow(new Object[]{
                    result.get(i).getMaPhieu(), result.get(i).getNguoiTao(), formatDate.format(result.get(i).getThoiGianTao()), formatter.format(result.get(i).getTongTien()) + "đ"
                });
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<Phieu> searchTatCa(String text) {
        ArrayList<Phieu> result = new ArrayList<>();
        ArrayList<Phieu> armt = PhieuNhapDAO.getInstance().selectAllP();
        for (var phieu : armt) {
            if (phieu.getMaPhieu().toLowerCase().contains(text.toLowerCase())
                    || phieu.getNguoiTao().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }
        }
        return result;
    }

    public ArrayList<Phieu> searchPhieuNhap(String text) {
        ArrayList<Phieu> result = new ArrayList<>();
        ArrayList<PhieuNhap> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getMaPhieu().toLowerCase().contains(text.toLowerCase())
                    || phieu.getNguoiTao().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }
        }
        return result;
    }

    public ArrayList<Phieu> searchPhieuXuat(String text) {
        ArrayList<Phieu> result = new ArrayList<>();
        ArrayList<PhieuXuat> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (phieu.getMaPhieu().toLowerCase().contains(text.toLowerCase())
                    || phieu.getNguoiTao().toLowerCase().contains(text.toLowerCase())) {
                result.add(phieu);
            }
        }
        return result;
    }

    public void changeTextFind() {
        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (jTextFieldSearch.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtNamePr = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThongKeProduct = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jDateChooserFromPr = new com.toedter.calendar.JDateChooser();
        jDateChooserToPr = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnResetThongKePr = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnDetail = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jDateChooserFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        giaTu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        giaDen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tongTien = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtQuantityProduct = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        soLuong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1180, 770));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1180, 770));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNamePr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamePrKeyReleased(evt);
            }
        });
        jPanel16.add(txtNamePr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 40));

        tblThongKeProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã máy", "Tên máy", "Số lượng nhập", "Số lượng xuất"
            }
        ));
        tblThongKeProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongKeProductMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThongKeProduct);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFromPr.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFromPr.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromPrPropertyChange(evt);
            }
        });
        jDateChooserFromPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromPrKeyReleased(evt);
            }
        });
        jPanel13.add(jDateChooserFromPr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 150, -1));

        jDateChooserToPr.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserToPr.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToPrPropertyChange(evt);
            }
        });
        jDateChooserToPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToPrKeyReleased(evt);
            }
        });
        jPanel13.add(jDateChooserToPr, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 150, -1));

        jLabel6.setText("Đến");
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 40, 20));

        jLabel8.setText("Từ");
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 20, 20));

        btnResetThongKePr.setBackground(new java.awt.Color(204, 204, 204));
        btnResetThongKePr.setText("Làm mới");
        btnResetThongKePr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetThongKePrActionPerformed(evt);
            }
        });
        jPanel13.add(btnResetThongKePr, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 90, 40));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 212, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(510, 510, 510))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel12);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-magnifying-glass-48.png"))); // NOI18N
        btnDetail.setText("Xem chi tiết");
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setFocusable(false);
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDetail);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phiếu Nhập", "Phiếu Xuất" }));
        jComboBoxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLuaChonActionPerformed(evt);
            }
        });
        jComboBoxLuaChon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxLuaChonPropertyChange(evt);
            }
        });
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 40));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 280, 40));

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 110, 40));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPhieuNhap);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooserFrom.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserFromPropertyChange(evt);
            }
        });
        jDateChooserFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserFromKeyReleased(evt);
            }
        });
        jPanel4.add(jDateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, -1));

        jDateChooserTo.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserToPropertyChange(evt);
            }
        });
        jDateChooserTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooserToKeyReleased(evt);
            }
        });
        jPanel4.add(jDateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 170, -1));

        jLabel1.setText("Đến");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 40, 20));

        jLabel5.setText("Từ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 20, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo giá"));

        jLabel3.setText("Từ");

        giaTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaTuActionPerformed(evt);
            }
        });
        giaTu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                giaTuKeyReleased(evt);
            }
        });

        jLabel4.setText("Đến");

        giaDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaDenActionPerformed(evt);
            }
        });
        giaDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                giaDenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(giaTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(giaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel2.setText("TỔNG TIỀN");

        tongTien.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        tongTien.setForeground(new java.awt.Color(255, 0, 51));
        tongTien.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(203, 203, 203))
        );

        jTabbedPane1.addTab("Phiếu", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1130, 620));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 204, 0));

        txtQuantityProduct.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        txtQuantityProduct.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantityProduct.setText("100");

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sản phẩm trong kho");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-monitor-80.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuantityProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtQuantityProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(10, 10, 10))
        );

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-invoice-100.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phiếu");

        soLuong.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        soLuong.setForeground(new java.awt.Color(255, 255, 255));
        soLuong.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        loadDataToTable();
        jComboBoxLuaChon.setSelectedIndex(0);
        jTextFieldSearch.setText("");
        jDateChooserFrom.setCalendar(null);
        jDateChooserTo.setCalendar(null);
        giaDen.setText("");
        giaTu.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void giaDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giaDenActionPerformed

    private void jComboBoxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonActionPerformed
        try {
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBoxLuaChonActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void giaTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaTuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_giaTuActionPerformed

    private void giaTuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_giaTuKeyReleased
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_giaTuKeyReleased

    private void jDateChooserFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromKeyReleased
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromKeyReleased

    private void jDateChooserToKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToKeyReleased
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToKeyReleased

    private void giaDenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_giaDenKeyReleased
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_giaDenKeyReleased

    private void jDateChooserFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromPropertyChange
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromPropertyChange

    private void jDateChooserToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToPropertyChange
        try {
            // TODO add your handling code here:
            searchAllRepect();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToPropertyChange

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        if (tblPhieuNhap.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu !");
        } else {
            CTThongKe a = new CTThongKe(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void jComboBoxLuaChonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonPropertyChange


    }//GEN-LAST:event_jComboBoxLuaChonPropertyChange

    private void txtNamePrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamePrKeyReleased
        try {
            // TODO add your handling code here:
            filterThongKeSanPham();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtNamePrKeyReleased

    private void tblThongKeProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblThongKeProductMouseClicked

    private void jDateChooserFromPrPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserFromPrPropertyChange
        try {
            // TODO add your handling code here:
            filterThongKeSanPham();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserFromPrPropertyChange

    private void jDateChooserFromPrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserFromPrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserFromPrKeyReleased

    private void jDateChooserToPrPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserToPrPropertyChange
        try {
            // TODO add your handling code here:
            filterThongKeSanPham();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDateChooserToPrPropertyChange

    private void jDateChooserToPrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserToPrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserToPrKeyReleased

    private void btnResetThongKePrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetThongKePrActionPerformed
        // TODO add your handling code here:
        txtNamePr.setText("");
        jDateChooserFromPr.setCalendar(null);
        jDateChooserToPr.setCalendar(null);
        loadDataToTableThongKeProduct(ThongKeDAO.getInstance().getThongKe());
    }//GEN-LAST:event_btnResetThongKePrActionPerformed

    public Phieu getPhieuNhapSelect() {
        int i_row = tblPhieuNhap.getSelectedRow();
        Phieu pn = PhieuNhapDAO.getInstance().selectById(tblModel.getValueAt(i_row, 1).toString());
        return pn;
    }

    public Phieu findPhieu() {
        int i_row = tblPhieuNhap.getSelectedRow();
        String text = tblModel.getValueAt(i_row, 0).toString();
        ArrayList<Phieu> phieuAll = PhieuNhapDAO.getInstance().selectAllP();
        Phieu phieuk = null;
        for (Phieu phieu : phieuAll) {
            if (phieu.getMaPhieu().equals(text)) {
                return phieu;
            }
        }
        return phieuk;
    }

    public boolean checkDate(Date dateTest, Date star, Date end) {
        return dateTest.getTime() >= star.getTime() && dateTest.getTime() <= end.getTime();
    }

    public ArrayList<PhieuNhap> searchDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ArrayList<PhieuNhap> result = new ArrayList<PhieuNhap>();
        Date from = jDateChooserFrom.getDate();
        Date to = jDateChooserTo.getDate();
        ArrayList<PhieuNhap> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var phieu : armt) {
            if (checkDate(phieu.getThoiGianTao(), from, to)) {
                result.add(phieu);
            }

        }
        return result;
    }

 
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnResetThongKePr;
    private javax.swing.JTextField giaDen;
    private javax.swing.JTextField giaTu;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private com.toedter.calendar.JDateChooser jDateChooserFrom;
    private com.toedter.calendar.JDateChooser jDateChooserFromPr;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
    private com.toedter.calendar.JDateChooser jDateChooserToPr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel soLuong;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblThongKeProduct;
    private javax.swing.JLabel tongTien;
    private javax.swing.JTextField txtNamePr;
    private javax.swing.JLabel txtQuantityProduct;
    // End of variables declaration//GEN-END:variables

    public void searchAllRepect() throws ParseException {
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<Phieu> result = null;

        switch (luaChon) {
            case "Tất cả":
                result = searchTatCa(content);
                break;
            case "Phiếu Nhập":
                result = searchPhieuNhap(content);
                break;
            case "Phiếu Xuất":
                result = searchPhieuXuat(content);
                break;
        }

        Iterator<Phieu> itr = result.iterator();
        if (jDateChooserFrom.getDate() != null || jDateChooserTo.getDate() != null) {
            Date from;
            Date to;
            if (jDateChooserFrom.getDate() != null && jDateChooserTo.getDate() == null) {
                from = ConvertDate.getInstance().ChangeFrom(jDateChooserFrom.getDate());
                to = ConvertDate.getInstance().ChangeTo(new Date());
                while (itr.hasNext()) {
                    Phieu phieu = itr.next();
                    if (!checkDate(phieu.getThoiGianTao(), from, to)) {
                        itr.remove();
                    }
                }
            } else if (jDateChooserTo.getDate() != null && jDateChooserFrom.getDate() == null) {
                String sDate1 = "01/01/2022";
                from = ConvertDate.getInstance().ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse(sDate1));
                to = ConvertDate.getInstance().ChangeTo(jDateChooserTo.getDate());
                while (itr.hasNext()) {
                    Phieu phieu = itr.next();
                    if (!checkDate(phieu.getThoiGianTao(), from, to)) {
                        itr.remove();
                    }
                }
            } else {
                from = ConvertDate.getInstance().ChangeFrom(jDateChooserFrom.getDate());
                to = ConvertDate.getInstance().ChangeTo(jDateChooserTo.getDate());
                while (itr.hasNext()) {
                    Phieu phieu = itr.next();
                    if (!checkDate(phieu.getThoiGianTao(), from, to)) {
                        itr.remove();
                    }
                }
            }
        }

        ArrayList<Phieu> result1 = new ArrayList<>();
        if (giaTu.getText().length() > 0 || giaDen.getText().length() > 0) {
            double a;
            double b;

            if (giaTu.getText().length() > 0 && giaDen.getText().length() == 0) {
                a = Double.parseDouble(giaTu.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTien() >= a) {
                        result1.add(result.get(i));
                    }
                }
            } else if (giaTu.getText().length() == 0 && giaDen.getText().length() > 0) {;
                b = Double.parseDouble(giaDen.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTien() <= b) {
                        result1.add(result.get(i));
                    }
                }
            } else if (giaTu.getText().length() > 0 && giaDen.getText().length() > 0) {
                a = Double.parseDouble(giaTu.getText());
                b = Double.parseDouble(giaDen.getText());
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getTongTien() >= a && result.get(i).getTongTien() <= b) {
                        result1.add(result.get(i));
                    }
                }
            }
        }
        if (giaTu.getText().length() > 0 || giaDen.getText().length() > 0) {
            loadDataToTableSearch(result1);
            double sum = 0;
            for (Phieu phieu : result1) {
                sum += phieu.getTongTien();
            }
            soLuong.setText(result1.size() + "");
            tongTien.setText(formatter.format(sum) + "đ");
        } else {
            loadDataToTableSearch(result);
            double sum = 0;
            for (Phieu phieu : result) {
                sum += phieu.getTongTien();
            }
            soLuong.setText(result.size() + "");
            tongTien.setText(formatter.format(sum) + "đ");
        }
    }

    public void filterThongKeSanPham() throws ParseException {
        ArrayList<ThongKeProduct> thongKe = new ArrayList<>();
        if (jDateChooserFromPr.getDate() != null || jDateChooserToPr.getDate() != null) {
            Date from = new Date();
            Date to = new Date();
            if (jDateChooserFromPr.getDate() != null && jDateChooserToPr.getDate() == null) {
                from = jDateChooserFromPr.getDate();
                to = new Date();
            } else if (jDateChooserToPr.getDate() != null && jDateChooserFromPr.getDate() == null) {
                String sDate1 = "01/01/2022";
                from = ConvertDate.getInstance().ChangeFrom(new SimpleDateFormat("dd/MM/yyyy").parse(sDate1));
                to = jDateChooserToPr.getDate();
            } else {
                from = jDateChooserFromPr.getDate();
                to = jDateChooserToPr.getDate();
                if (from.getTime() > to.getTime()) {
                    JOptionPane.showMessageDialog(this, "Thời gian không hợp lệ !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    jDateChooserFrom.setCalendar(null);
                    jDateChooserTo.setCalendar(null);
                }
            }
            thongKe = ThongKeDAO.getInstance().getThongKe(from, to);

        } else {
            thongKe = ThongKeDAO.getInstance().getThongKe();
        }
        if (!txtNamePr.getText().equals("")) {
            thongKe = searchTenSanPhamThongKe(thongKe, txtNamePr.getText());
        }
        loadDataToTableThongKeProduct(thongKe);
    }

    private void loadDataToTableThongKeProduct(ArrayList<ThongKeProduct> thongKe) {
        try {
            DefaultTableModel tblModelAcc = (DefaultTableModel) tblThongKeProduct.getModel();
            tblModelAcc.setRowCount(0);
            for (int i = 0; i < thongKe.size(); i++) {
                tblModelAcc.addRow(new Object[]{
                    (i + 1), thongKe.get(i).getMaMay(), thongKe.get(i).getTenMay(), thongKe.get(i).getSlNhap(), thongKe.get(i).getSlXuat()
                });
            }
            tblThongKeProduct.getColumnModel().getColumn(2).setPreferredWidth(400);
        } catch (Exception e) {
        }
    }

    private ArrayList<ThongKeProduct> searchTenSanPhamThongKe(ArrayList<ThongKeProduct> arr, String name) {
        ArrayList<ThongKeProduct> result = new ArrayList<>();
        for (ThongKeProduct i : arr) {
            if (i.getMaMay().toLowerCase().contains(name.toLowerCase()) || i.getTenMay().toLowerCase().contains(name.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }
}
