/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

/**
 *
 * @author artbast
 */
public class frmTabla extends javax.swing.JFrame {

    /**
     * Creates new form frmTabla
     */
    public frmTabla() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabla de tokens");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "id", "L(L|D)*", "$1", "q1"},
                {"2", "entero", "D+", "$2", "q2"},
                {"3", "real", "D+.D+", "$3", "q25"},
                {"4", "cadena", "\"L2\"", "$4", "q24"},
                {"5", "dos_pt", "':'", "$5", "q4"},
                {"6", "pt_coma", "';'", "$6", "q5"},
                {"7", "igual", "'='", "$7", "q6"},
                {"8", "suma", "'+'", "$8", "q7"},
                {"9", "resta", "'-'", "$9", "q8"},
                {"10", "mult", "'*'", "$10", "q9"},
                {"11", "div", "'/'", "$11", "q10"},
                {"12", "coma", "','", "$12", "q11"},
                {"13", "par_ab", "'('", "$13", "q12"},
                {"14", "par_cer", "')'", "$14", "q13"},
                {"15", "ll_ab", "'{'", "$15", "q14"},
                {"16", "ll_cer", "'}'", "$16", "q15"},
                {"17", "may", "'>'", "$17", "q16"},
                {"18", "men", "'<'", "$18", "q17"},
                {"19", "ma_igl", "'>''='", "$19", "q20"},
                {"20", "me_igl", "'<''='", "$20", "q21"},
                {"21", "dif", "'<''>'", "$21", "q22"},
                {"22", "pr_void", "\"void'", "$22", null},
                {"23", "pr_entero", "\"entero\"", "$23", null},
                {"24", "pr_real", "\"real\"", "$24", null},
                {"25", "pr_cad", "\"cadena\"", "$25", null},
                {"26", "pr_sal", "\"Salida\"", "$26", null},
                {"27", "pr_ent", "\"Entrada\"", "$27", null},
                {"28", "pr_si", "\"Si\"", "$28", null},
                {"29", "pr_ento", "\"Entonces\"", "$29", null},
                {"30", "pr_sn", "\"Sino\"", "$30", null},
                {"31", "pr_fs", "\"FinSi\"", "$31", null},
                {"32", "pr_prin", "\"Principal\"", "$32", null},
                {"33", "pr_ll", "\"Llamar\"", "$33", null}
            },
            new String [] {
                "No", "Nombre", "Patrón", "FC", "EA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}