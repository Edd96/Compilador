/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import clases.AnalizaLex;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author eddpe
 */
public class editor extends javax.swing.JFrame {
    frmALexico objFormulaioLex;
    /**
     * Creates new form editor
     */
    public editor() {
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

        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEditor = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        mnBar = new javax.swing.JMenuBar();
        menuAbrir = new javax.swing.JMenu();
        mnArchivoNuevo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnArchivoGuardar = new javax.swing.JMenuItem();
        mnArchivoSalir = new javax.swing.JMenuItem();
        menuAnalisis = new javax.swing.JMenu();
        mnAnalisisArchivo = new javax.swing.JMenu();
        mnAnalisisSalidaProg = new javax.swing.JMenuItem();
        mnAnalisisTablaTokens = new javax.swing.JMenuItem();
        mnAnalisisErroresXML = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        mnAyudaAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador D++");
        setName("frmAnalizador"); // NOI18N

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtEditor.setColumns(20);
        txtEditor.setRows(5);
        jScrollPane2.setViewportView(txtEditor);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        menuAbrir.setText("Archivo");

        mnArchivoNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnArchivoNuevo.setText("Nuevo");
        mnArchivoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivoNuevoActionPerformed(evt);
            }
        });
        menuAbrir.add(mnArchivoNuevo);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAbrir.add(jMenuItem1);

        mnArchivoGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnArchivoGuardar.setText("Guardar");
        mnArchivoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivoGuardarActionPerformed(evt);
            }
        });
        menuAbrir.add(mnArchivoGuardar);

        mnArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        mnArchivoSalir.setText("Salir");
        mnArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivoSalirActionPerformed(evt);
            }
        });
        menuAbrir.add(mnArchivoSalir);

        mnBar.add(menuAbrir);

        menuAnalisis.setText("Analisis");

        mnAnalisisArchivo.setText("Analizar Archivo");

        mnAnalisisSalidaProg.setText("Salida del Programa");
        mnAnalisisArchivo.add(mnAnalisisSalidaProg);

        mnAnalisisTablaTokens.setText("Tabla de Simbolos");
        mnAnalisisArchivo.add(mnAnalisisTablaTokens);

        mnAnalisisErroresXML.setText("Errores (Archivo XML)");
        mnAnalisisArchivo.add(mnAnalisisErroresXML);

        menuAnalisis.add(mnAnalisisArchivo);

        mnBar.add(menuAnalisis);

        menuAyuda.setText("Ayuda");

        mnAyudaAcercade.setText("Acerca de");
        menuAyuda.add(mnAyudaAcercade);

        mnBar.add(menuAyuda);

        setJMenuBar(mnBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(btnLimpiar)
                        .addGap(56, 56, 56)
                        .addComponent(btnAnalizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnalizar)
                    .addComponent(btnLimpiar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void abrirArchivo(){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos TXT", "txt");
        fileChooser.setFileFilter(filtro);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(this)) {
        File archivo = fileChooser.getSelectedFile();
        FileReader lector = null;
        try {
            lector = new FileReader(archivo);
            BufferedReader bfReader = new BufferedReader(lector);

            String lineaFichero;
            StringBuilder contenidoFichero = new StringBuilder();

            // Recupera el contenido del fichero
            while ((lineaFichero = bfReader.readLine()) != null) {
                contenidoFichero.append(lineaFichero);
                contenidoFichero.append("\n");
            }

            // Pone el contenido del fichero en el area de texto
            txtEditor.setText(contenidoFichero.toString());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
    public void guardarArchivo() {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos TXT", "txt");
    fileChooser.setFileFilter(filtro);
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(this)) {
        File archivo = fileChooser.getSelectedFile();
        String PATH = archivo.getAbsolutePath();
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(archivo);
            escritor.write(txtEditor.getText());
            if(!(PATH.endsWith(".txt"))){
                File temp = new File(PATH+".txt");
                archivo.renameTo(temp);//renombramos el archivo
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                escritor.close();
            } catch (IOException ex) {
                Logger.getLogger(editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        objFormulaioLex= new frmALexico();
        objFormulaioLex.setVisible(true);
        objFormulaioLex.analizar(txtEditor.getText());
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void mnArchivoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivoNuevoActionPerformed
        txtEditor.setText("");
    }//GEN-LAST:event_mnArchivoNuevoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        abrirArchivo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnArchivoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivoGuardarActionPerformed
        guardarArchivo();
    }//GEN-LAST:event_mnArchivoGuardarActionPerformed

    private void mnArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivoSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnArchivoSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtEditor.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    
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
            java.util.logging.Logger.getLogger(editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAbrir;
    private javax.swing.JMenu menuAnalisis;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu mnAnalisisArchivo;
    private javax.swing.JMenuItem mnAnalisisErroresXML;
    private javax.swing.JMenuItem mnAnalisisSalidaProg;
    private javax.swing.JMenuItem mnAnalisisTablaTokens;
    private javax.swing.JMenuItem mnArchivoGuardar;
    private javax.swing.JMenuItem mnArchivoNuevo;
    private javax.swing.JMenuItem mnArchivoSalir;
    private javax.swing.JMenuItem mnAyudaAcercade;
    private javax.swing.JMenuBar mnBar;
    private javax.swing.JTextArea txtEditor;
    // End of variables declaration//GEN-END:variables
}
