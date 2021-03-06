/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alekelbar.os_task3;

import files_operation.Get_file;
import files_operation.Post_file;
import http_objects.Request_http;
import http_objects.Response_http;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author INTEL
 */
public class ClientForm extends javax.swing.JFrame {

    /**
     * Creates new form ServerForm
     */
    private Socket client;

    private ObjectInputStream in;

    private ObjectOutputStream out;

    private DefaultListModel<String> model;

    public ClientForm() {
        initComponents();
        this.model = new DefaultListModel<>();
        Conect();
        fillStock();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_upload = new javax.swing.JButton();
        btn_download = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_state = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_files = new javax.swing.JList<>();
        btn_getStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(111, 76, 91));

        btn_upload.setBackground(new java.awt.Color(222, 186, 157));
        btn_upload.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_upload.setText("Upload");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });

        btn_download.setBackground(new java.awt.Color(222, 186, 157));
        btn_download.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_download.setText("Download");
        btn_download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_downloadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(158, 119, 119));

        lbl_state.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_state.setForeground(new java.awt.Color(222, 186, 157));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lbl_state)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_state)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        list_files.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_files);

        btn_getStock.setBackground(new java.awt.Color(222, 186, 157));
        btn_getStock.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_getStock.setText("Update Stock");
        btn_getStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_upload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(btn_download)))
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btn_getStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(159, 159, 159))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_download, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_upload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_getStock)
                .addGap(32, 32, 32))
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

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        // TODO add your handling code here:

        File file;
        JFileChooser contextualMenuFile = new JFileChooser();
        contextualMenuFile.showOpenDialog(this);
        file = contextualMenuFile.getSelectedFile();

        if (file != null) {

            this.btn_download.setEnabled(false);
            this.btn_upload.setEnabled(false);
            this.btn_getStock.setEnabled(false);

            FileInputStream file_read = null;
            try {

                boolean lastSend = false;
                Post_file post = new Post_file();

                client.setSoLinger(true, 3);

                //leer el archivoo....
                file_read = new FileInputStream(file);
                post.file_name = file.getName();

                // leer los bytes...
                int reads = file_read.read(post.content);

//                System.out.println("Se leyeron " + reads + " bytes");
                while (reads > -1) {

                    post.valid_bytes = reads;
//                    System.out.println("Se leyeron " + reads + " bytes");

                    if (reads < post.MAX_SIZE) {
                        post.last_message = true;
                        lastSend = true;
                    } else {
                        post.last_message = false;
                    }

                    out.writeObject(post);
                    out.flush();

                    if (post.last_message) {
                        break;
                    }

                    // Se crea un nuevo mensaje
                    post = new Post_file();
                    post.file_name = file.getName();

                    // y se leen sus bytes.
                    reads = file_read.read(post.content);
                }

                if (lastSend == false) {
                    post.last_message = true;
                    post.valid_bytes = 0;
                    out.writeObject(post);
                    out.flush();
                }

                file_read.close();
                fillStock();
                JOptionPane.showMessageDialog(this, "Archivo subido correctamente...");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No selecciono un archivo valido!");
        }
        this.btn_download.setEnabled(true);
        this.btn_upload.setEnabled(true);
        this.btn_getStock.setEnabled(true);

    }//GEN-LAST:event_btn_uploadActionPerformed

    private void btn_downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_downloadActionPerformed
        // TODO add your handling code here:

        String file = list_files.getSelectedValue();
        if (file != null && !file.isEmpty()) {

            System.out.println("Cliente envia un fichero....");
            this.btn_upload.setEnabled(false);
            this.btn_download.setEnabled(false);
            this.btn_getStock.setEnabled(false);

            try {
                // enviar la peticion al servidor...
                Get_file get_file = new Get_file();
                get_file.file_name = file;
                out.writeObject(get_file);

                // administrar la respuesta...
                Post_file received = new Post_file();
                FileOutputStream file_output = new FileOutputStream("files_get/" + get_file.file_name + "_copia");
                Object aux;

                do {
                    aux = in.readObject();
                    if (aux instanceof Post_file) {
                        received = (Post_file) aux; // casting ...
                        file_output.write(received.content, 0, received.valid_bytes); // Escribiendo en el fichero...
                    }

                } while (!received.last_message);

                file_output.close();
                fillStock();
                JOptionPane.showMessageDialog(this, "Archivo obtenido correctamente!");

            } catch (FileNotFoundException ex) {

                System.out.println("No se pudo el fichero ...");

            } catch (IOException ex) {

                System.out.println("No se pudo obtener el flujo...");

            } catch (ClassNotFoundException ex) {

                System.out.println("Error " + ex.getMessage());

            } finally {

                this.btn_upload.setEnabled(true);
                this.btn_download.setEnabled(true);

            }

        } else {
            JOptionPane.showMessageDialog(this, "No es un nombre valido...");
        }
        this.btn_download.setEnabled(true);
        this.btn_upload.setEnabled(true);
        this.btn_getStock.setEnabled(true);

    }//GEN-LAST:event_btn_downloadActionPerformed

    private void btn_getStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getStockActionPerformed
        // TODO add your handling code here:
        fillStock();
    }//GEN-LAST:event_btn_getStockActionPerformed

    /**
     *
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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClientForm clientForm = new ClientForm();
                clientForm.setResizable(false);
                clientForm.setVisible(true);
            }
        });
    }

    void Conect() {
        try {
            client = new Socket("25.67.64.48", 65000);
            this.lbl_state.setText("CONNECTED");

            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

        } catch (IOException ex) {
            System.out.println("Conexi??n rechazada");
        }
    }

    void fillStock() {
        try {
            Request_http request = new Request_http();
            request.data = "stock";
            out.writeObject(request);
            out.flush();

            Object aux = in.readObject();
            if (aux instanceof Response_http) {
                Response_http response = (Response_http) aux;
                String[] data = response.getData();

                if (!data[0].contains("vacio")) {
                    ArrayList<String> files = new ArrayList<>();
                    // rellenando el modelo...
                    for (String file : data) {
                        files.add(file);
                    }
                    model.clear();
                    list_files.setModel(model);

                    for (String file : files) {
                        model.addElement(file);
                    }

                } else {
                    model.clear();
                    list_files.setModel(model);
                    model.addElement("No existen archivos en el repo...");
                }
            }

        } catch (IOException ex) {
            System.out.println("Error al tratar de llenar el stock");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_download;
    private javax.swing.JButton btn_getStock;
    private javax.swing.JButton btn_upload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_state;
    private javax.swing.JList<String> list_files;
    // End of variables declaration//GEN-END:variables
}
