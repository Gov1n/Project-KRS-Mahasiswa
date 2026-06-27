/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.StudentController;
import java.awt.event.ActionEvent;
import model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.SQLException;
/**
 *
 * @author ngura
 */
public class StudentForm extends javax.swing.JFrame{
    private String selectedNIM = null; 
    StudentController controller = new StudentController();
    
    
    final String[] studyProgram = {"Ilmu Komputer", "Sistem Informasi", "Teknik Elektro", "Teknik Mesin", "Teknik Sipil"};
    
   
    private int currentPage = 1;
    private final int limitPerPage = 5; 
    private String currentKeyword = "";
    private static final Logger logger = Logger.getLogger(StudentForm.class.getName());

    public StudentForm() {
        initComponents();
        
        
        loadComboProdi();
        
       
        try {
            loadStudentData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal Meload Data: " + ex.getMessage(), "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable2.getSelectedRow();
                if (selectedRow != -1) {
                    txtNik.setText(jTable2.getValueAt(selectedRow, 0).toString());
                    txtName.setText(jTable2.getValueAt(selectedRow, 1).toString());
                    txtNim.setText(jTable2.getValueAt(selectedRow, 2).toString());
                    cmbProdi.setSelectedItem(jTable2.getValueAt(selectedRow, 3).toString());
                    
                    selectedNIM = txtNim.getText().trim();
                    txtNim.setEditable(false); 
                }
            }
        });
        btlDelete.addActionListener(e -> {
            if (selectedNIM == null) {
                JOptionPane.showMessageDialog(this, "Pilih data dari tabel yang ingin dihapus terlebih dahulu!");
                return;
            }
            
            int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus data dengan NIM " + selectedNIM + "?", 
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            
            if (konfirmasi == JOptionPane.YES_OPTION) {
                controller.delete(selectedNIM); 
                try {
                    loadStudentData();
                } catch (Exception ex) {
                    logger.log(Level.SEVERE, null, ex);
                }
                clearForm();
            }
        });
    }
    
    private void clearForm() {
        txtName.setText("");
        txtNim.setText("");
        txtNik.setText("");
        if (cmbProdi.getItemCount() > 0) {
            cmbProdi.setSelectedIndex(0);
        }
        txtNim.setEditable(true);
        selectedNIM = null;
    }

    
    private void loadComboProdi() {
        cmbProdi.removeAllItems();
        
       for (String prodi : studyProgram) {
            cmbProdi.addItem(prodi);
        }
    }

    private void loadStudentData() throws java.sql.SQLException {
        
        List<Student> allStudents = controller.getStudent();
        List<Student> filteredStudents = new java.util.ArrayList<>();
        
       
        for (Student s : allStudents) {
            if (currentKeyword.isEmpty() || 
                s.getName().toLowerCase().contains(currentKeyword.toLowerCase()) ||
                s.getNim().toLowerCase().contains(currentKeyword.toLowerCase())) {
                filteredStudents.add(s);
            }
        }
        
       
        int totalData = filteredStudents.size();
        int totalPages = (int) Math.ceil((double) totalData / limitPerPage);
        if (totalPages == 0) totalPages = 1;
        
        if (currentPage > totalPages) currentPage = totalPages;
        if (currentPage < 1) currentPage = 1;
        
       
        btnPrev.setEnabled(currentPage > 1);
        btnNext.setEnabled(currentPage < totalPages);
        
        int startIndex = (currentPage - 1) * limitPerPage;
        int endIndex = Math.min(startIndex + limitPerPage, totalData);
        
        int rowCount = endIndex - startIndex;
        String[][] data = new String[rowCount][4];
        
        int dataIndex = 0;
        for (int i = startIndex; i < endIndex; i++) {
            Student s = filteredStudents.get(i);
            data[dataIndex][0] = s.getCardID();
            data[dataIndex][1] = s.getName();
            data[dataIndex][2] = s.getNim();
            data[dataIndex][3] = s.getStudyProgram();
            dataIndex++;
        }
        
        String[] columnName = {"ID", "Name", "NIM", "Studi Program"};
        jTable2.setModel(new javax.swing.table.DefaultTableModel(data, columnName));  
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbProdi = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtNim = new javax.swing.JTextField();
        btlDelete = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtNik = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        txtPencarian = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MASTER STUDENT");

        jLabel2.setText("INPUT DATA");

        jLabel3.setText("Nama");

        jLabel4.setText("NIM");

        jLabel5.setText("NIK");

        jLabel6.setText("Prodi");

        cmbProdi.addActionListener(this::cmbProdiActionPerformed);

        txtName.addActionListener(this::txtNameActionPerformed);

        btlDelete.setText("Delete");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnBatal.setText("Batal");
        btnBatal.addActionListener(this::btnBatalActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(txtNim)
                    .addComponent(txtNik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBatal)
                        .addGap(18, 18, 18)
                        .addComponent(btlDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(cmbProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btlDelete)
                            .addComponent(btnBatal))
                        .addGap(26, 26, 26))))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "NIM", "StudiProgram"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnNext.setText("Next>>");
        btnNext.addActionListener(this::btnNextActionPerformed);

        btnPrev.setText("<<Prev");
        btnPrev.addActionListener(this::btnPrevActionPerformed);

        txtPencarian.setText("Pencarian");
        txtPencarian.addActionListener(this::txtPencarianActionPerformed);

        btnCari.setText("Cari");
        btnCari.addActionListener(this::btnCariActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59)
                                    .addComponent(btnCari))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 286, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addGap(71, 71, 71)
                        .addComponent(btnNext)
                        .addGap(280, 280, 280))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(339, 339, 339))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnPrev))
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPencarianActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        currentKeyword = txtPencarian.getText().trim();
if (currentKeyword.equals("Pencarian")) {
    currentKeyword = "";
}
currentPage = 1; 
try {
    loadStudentData();
} catch (SQLException ex) {
    logger.log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText().trim();
String nim = txtNim.getText().trim();
String cardID = txtNik.getText().trim();
String studiProgram = (cmbProdi.getSelectedItem() != null) ? cmbProdi.getSelectedItem().toString() : "";

if (name.isEmpty() || nim.isEmpty() || cardID.isEmpty() || studiProgram.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Semua kolom inputan wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    return;
}

Student student = new Student(cardID, name, nim, studiProgram);

int res;
if (selectedNIM == null) {
    res = controller.create(student); 
} else {
    res = controller.update(student, selectedNIM); 
}

if (res == 1) {
    JOptionPane.showMessageDialog(this, "Data Mahasiswa berhasil disimpan ke MySQL!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    clearForm();
    try {
        loadStudentData(); 
    } catch (SQLException ex) {
        logger.log(Level.SEVERE, null, ex);
    }
} else {
    JOptionPane.showMessageDialog(this, "Gagal memproses data ke database!", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        currentPage++;
try {
    loadStudentData();
} catch (SQLException ex) {
    logger.log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (currentPage > 1) {
    currentPage--;
    try {
        loadStudentData();
    } catch (SQLException ex) {
        logger.log(Level.SEVERE, null, ex);
    }
}
    }//GEN-LAST:event_btnPrevActionPerformed

    private void cmbProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProdiActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new StudentForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlDelete;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbProdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtPencarian;
    // End of variables declaration//GEN-END:variables

    
}
