/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.SerChucVU;
import Service.SerNhanVien;
import Utilities.jframeCheck;
import ViewModel.ChucVuView;
import ViewModel.NhanVienView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yugip
 */
public class QLNhanVien extends javax.swing.JFrame {

    private final SerNhanVien serNV = new SerNhanVien();
    private final SerChucVU serCV = new SerChucVU();
    private final jframeCheck jcheck = new jframeCheck();
    private final List<Object> jText = new ArrayList<>();
    private final List<Object> jTextCV = new ArrayList<>();
    private final DefaultComboBoxModel dccCV = new DefaultComboBoxModel();

    /**
     * Creates new form NhanVien
     */
    public QLNhanVien() {
        initComponents();
        jText.add(txtT);
        jText.add(txtNS);
        jText.add(txtSDT);
        jText.add(txtD);
        jText.add(rdoNam);
        jText.add(rdoNu);
        jTextCV.add(txtTCV);
        jText.add(txtTuoi);
        loadTable();
        loadCV();
    }

    private void loadCV() {
        if (this.serNV.getAllCVV() != null) {
            for (ChucVuView object : this.serNV.getAllCVV()) {
                dccCV.addElement(object);
            }
            cbbCV.setModel(dccCV);
        }
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbnNV.getModel();
        dtm.setRowCount(0);
        if (this.serNV.getALl("") != null) {
            for (NhanVienView object : serNV.getALl(null)) {
                dtm.addRow(new Object[]{
                    object.getId(),
                    object.getMa(),
                    object.getTen(),
                    object.getNgaySinh(),
                    object.getDiachi(),
                    object.getSdt(),
                    object.getGioitinh(),
                    object.getCv().getTen(),
                    object.getTuoi()
                });
            }
        }
    }
    
    private void loadTableCV() {
        DefaultTableModel dtm = (DefaultTableModel) tbnCV.getModel();
        dtm.setRowCount(0);
        for (ChucVuView thi : this.serCV.getALl("")) {
            dtm.addRow(new Object[]{
                thi.getId(),
                thi.getMa(),
                thi.getTen()
            });
        }
    }
    
    private NhanVienView getData(String dk) {
        try {
            if (dk.equalsIgnoreCase("update")) {
                System.out.println("update");
                return new NhanVienView(tbnNV.getValueAt(tbnNV.getSelectedRow(), 0).toString(), tbnNV.getValueAt(tbnNV.getSelectedRow(), 1).toString(), txtT.getText().trim(), rdoNam.isSelected() == true ? "Nam" : "Nữ",
                        txtD.getText().trim(), txtSDT.getText().trim(), new SimpleDateFormat("yyyy-MM-dd").parse(txtNS.getText().trim()),
                        (ChucVuView) dccCV.getSelectedItem(), Integer.parseInt(txtTuoi.getText().trim()));
            }
            ChucVuView cv;
            if (dccCV.getSize() != 0) {
                cv = (ChucVuView) dccCV.getSelectedItem();
            } else {
                cv = new ChucVuView(jcheck.createID().toString(), jcheck.randomMA(), txtTCV.getText().trim());
            }
            return new NhanVienView(jcheck.createID().toString(), jcheck.randomMA(), txtT.getText(), rdoNam.isSelected() == true ? "Nam" : "Nữ",
                    txtD.getText().trim(), txtSDT.getText().trim(), new SimpleDateFormat("yyyy-MM-dd").parse(txtNS.getText().trim()),
                    cv, Integer.parseInt(txtTuoi.getText().trim()));
        } catch (ParseException ex) {
            Logger.getLogger(QLNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        cbbCV = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        tbnThem1 = new javax.swing.JButton();
        tbnS1 = new javax.swing.JButton();
        tbnX1 = new javax.swing.JButton();
        tbnN1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbnNV = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTCV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbnCV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        tbnThem = new javax.swing.JButton();
        tbnS = new javax.swing.JButton();
        tbnX = new javax.swing.JButton();
        tbnN = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel1.setText("Tên nhân viên: ");

        txtT.setName("Tên nhân viên"); // NOI18N
        txtT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày sinh:");

        txtNS.setName("Ngày sinh"); // NOI18N
        txtNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNSActionPerformed(evt);
            }
        });

        jLabel3.setText("Giới tính:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        rdoNam.setName(""); // NOI18N

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel4.setText("Số điện thoại: ");

        txtSDT.setName("số điện thoại  "); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel5.setText("Địa chỉ");

        txtD.setColumns(20);
        txtD.setRows(5);
        txtD.setName("Địa chỉ"); // NOI18N
        jScrollPane1.setViewportView(txtD);

        cbbCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbnThem1.setText("Thêm");
        tbnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThem1ActionPerformed(evt);
            }
        });

        tbnS1.setText("Sửa");
        tbnS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnS1ActionPerformed(evt);
            }
        });

        tbnX1.setText("Xóa");
        tbnX1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnX1ActionPerformed(evt);
            }
        });

        tbnN1.setText("Mới");
        tbnN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbnThem1)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbnN1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tbnS1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(tbnX1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tbnN1, tbnS1, tbnThem1, tbnX1});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnS1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnX1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(tbnN1)
                .addGap(33, 33, 33))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tbnN1, tbnS1, tbnThem1, tbnX1});

        jLabel7.setText("Chức vụ:");

        tbnNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "số điện thoại  ", "giới tính", "Chức vụ", "Tuổi "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbnNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnNVMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbnNV);

        jLabel8.setText("Tuoi: ");

        txtTuoi.setName("Tuổi "); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(76, 76, 76)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbCV, 0, 146, Short.MAX_VALUE)
                                            .addComponent(txtTuoi)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(70, 70, 70)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoNam)
                                .addComponent(rdoNu)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân viên", jPanel1);

        jLabel6.setText("Tên chức vụ: ");

        txtTCV.setName("Tên chức vụ"); // NOI18N

        tbnCV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbnCV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnCVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbnCV);

        tbnThem.setText("Thêm");
        tbnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemActionPerformed(evt);
            }
        });

        tbnS.setText("Sửa");
        tbnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSActionPerformed(evt);
            }
        });

        tbnX.setText("Xóa");
        tbnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnXActionPerformed(evt);
            }
        });

        tbnN.setText("Mới");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbnThem)
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbnN)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tbnS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbnX)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tbnN, tbnS, tbnThem, tbnX});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnX))
                .addGap(33, 33, 33)
                .addComponent(tbnN)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tbnN, tbnS, tbnThem, tbnX});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTCV, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chức vụ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTActionPerformed

    private void txtNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNSActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void tbnN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbnN1ActionPerformed

    private void tbnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThem1ActionPerformed
        if (jcheck.checkData(jText, this) == false) {
            return;
        }
        if (jcheck.checkDinhDang(jText, new String[]{"0[0-9]{9}"}, new int[]{20, 40}, this) == 0) {
            return;
        }
        if (this.serNV.add(getData("")) == 1) {
            return;
        }
        loadTable();
        this.jcheck.clearView(jText, tbnNV);
    }//GEN-LAST:event_tbnThem1ActionPerformed

    private void tbnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemActionPerformed
        this.serCV.add(new ChucVuView(this.jcheck.createID().toString(), jcheck.randomMA(), txtTCV.getText().trim()));
        loadTableCV();
        jcheck.clearView(jTextCV, tbnCV);
    }//GEN-LAST:event_tbnThemActionPerformed

    private void tbnNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnNVMouseClicked
        if (this.jcheck.checkClcick(tbnNV, this) == false) {
            return;
        }
        jcheck.clickTable(jText, tbnNV);
    }//GEN-LAST:event_tbnNVMouseClicked

    private void tbnS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnS1ActionPerformed
        if (jcheck.checkData(jText, this) == false) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return;
        }
        if (this.jcheck.checkClcick(tbnNV, this) == false) {
            return;
        }
        if (jcheck.checkDinhDang(jText, new String[]{"0[0-9]{9}"}, new int[]{20, 40}, this) == 0) {
            return;
        }
        if (this.serNV.update(getData("update")) == 1) {
            return;
        }
        loadTable();
        this.jcheck.clearView(jText, tbnNV);
    }//GEN-LAST:event_tbnS1ActionPerformed

    private void tbnX1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnX1ActionPerformed
        if (this.jcheck.checkClcick(tbnNV, this) == false) {
            return;
        }
        this.serNV.delete(tbnNV.getValueAt(tbnNV.getSelectedRow(), 0).toString());
        loadTable();
        this.jcheck.clearView(jText, tbnNV);
    }//GEN-LAST:event_tbnX1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        loadTableCV();
        dccCV.removeAllElements();
        loadCV();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void tbnCVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnCVMouseClicked
        this.jcheck.clickTable(jTextCV, tbnCV);
    }//GEN-LAST:event_tbnCVMouseClicked

    private void tbnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSActionPerformed
        this.serCV.update(new ChucVuView(tbnCV.getValueAt(tbnCV.getSelectedRow(), 0).toString(), tbnCV.getValueAt(tbnCV.getSelectedRow(), 1).toString(), txtTCV.getText().trim()));
        loadTableCV();
        this.jcheck.clearView(jTextCV, tbnCV);
    }//GEN-LAST:event_tbnSActionPerformed

    private void tbnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnXActionPerformed
        this.serCV.delete(tbnCV.getValueAt(tbnCV.getSelectedRow(), 0).toString());
        loadTableCV();
        this.jcheck.clearView(jTextCV, tbnCV);
    }//GEN-LAST:event_tbnXActionPerformed

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
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tbnCV;
    private javax.swing.JButton tbnN;
    private javax.swing.JButton tbnN1;
    private javax.swing.JTable tbnNV;
    private javax.swing.JButton tbnS;
    private javax.swing.JButton tbnS1;
    private javax.swing.JButton tbnThem;
    private javax.swing.JButton tbnThem1;
    private javax.swing.JButton tbnX;
    private javax.swing.JButton tbnX1;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextField txtNS;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtT;
    private javax.swing.JTextField txtTCV;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
