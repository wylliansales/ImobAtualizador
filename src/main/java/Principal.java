/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Suporte
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
       
        initComponents();

        URL url = this.getClass().getResource("/icon.png");  
	Image faviIcon = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(faviIcon);
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
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        getInfo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(48, 49, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 226));

        jProgressBar1.setStringPainted(true);

        jButton1.setBackground(new java.awt.Color(48, 49, 51));
        jButton1.setForeground(new java.awt.Color(247, 147, 30));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh-button.png"))); // NOI18N
        jButton1.setText("Buscar nova Atualização");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getInfo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getInfo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo qative.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);

        new Thread() {
            public void run() {

                String host = "";
                FileReader ff;
                String email = "suporte@qative.com.br";
                
                try {
                    ff = new FileReader(new File("host-update.txt"));
                    BufferedReader ler = new BufferedReader(ff);
                    String linha = null;

                    while ((linha = ler.readLine()) != null) {
                        System.out.println("host_update lido");
                        if (!(linha == null)) {
                            host = linha.substring(5);
                            if(host.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Host vazio, atualização não realizada");
                                
                                System.exit(0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "host não encontrado, atualização não realizada");
                           
                            System.exit(0);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                //TRECHO DE CÓDIGO FECHA TODAS AS INSTANCIAS DO SISTEMA
                try {
                    jProgressBar1.setValue(2);
                    for (int cont = 2; cont < 30; cont++) {
                        Runtime.getRuntime().exec("taskkill /f /im imob.exe");
                        sleep(17);
                        jProgressBar1.setValue(cont);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Reinicia o computador e tente novamente!");
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "É necessário fechar o qimob");
                }
                
                 ConectDB conect = new ConectDB(host, System.getProperty("user.dir")+"/QIMOB.FDB", "SYSDBA", "masterkey");
                 //Retorna dados[0]= cnpj; dados[1]= empresa;
                        //String dados[] = null;
                        String[] dados = null;
                        try{
                            dados = ConectDB.getEmpresaCnpj(conect);
                        } catch(java.lang.NullPointerException e){
                            JOptionPane.showMessageDialog(null, "Algum error aconteceu com o host, entre em contato com suporte");
                            
                            System.exit(0);
                        }

                //COMEÇA O PROCEDIMENTO DE ATUALIZAÇÃO
                int cont = 0; // ESSE CONTATO É UTILIZADO PARA A BARRA DE PROGRESSO
                try {
                    getInfo.setText("Preparando atuliazação............");
                    jProgressBar1.setValue(16);

                    //ESSE ARQUIVO ESTÁ SENDO CRIADO COM TODAS AS PASTAS LOCALIZADA NO C:
                    //ESSE FILE SERÁ ITERADO LOGO ADIANTE, PESQUISARÁ TODAS AS INSTALAÇÕES
                    File file = new File("C:\\");
                        File files[] = file.listFiles();

                        jProgressBar1.setValue(50);

                        //DOWNALOD DO ARQUIVO TXT QUE TEM OS CLIENTES CRIPTOGRAFADO COM CHAVE "MhlZukWsyijZwhW5oo"
                        Dropbox d = new Dropbox();
                        getInfo.setText("Validando......");
                        try{
                            d.dowloand(System.getProperty("user.dir") + "/0000000000.txt", "/0000000000.txt");
                        } catch(com.dropbox.core.NetworkIOException ex){
                            JOptionPane.showMessageDialog(null, "Falha! Conexão com a internet");
                            
                            System.exit(0);
                        }

                        jProgressBar1.setValue(52);

                       
                        jProgressBar1.setValue(53);
                       
                        // Método que verifica se o cliente tem autorização
                        jProgressBar1.setValue(54);

                        String autorizacao = Arquivo.lerTxtVerif(System.getProperty("user.dir") + "/0000000000.txt", dados[0]);
                        conect.disconnect();
                        //Se a atualização estiver liberada para o cliente entra nessa condição
                        if (autorizacao.equalsIgnoreCase("1")) {

                            getInfo.setText("Aguarde esse procedimento pode demorar, baixando atualização.......");
                            //Começa o downlaod do arquivo imob.zip
                            try{
                                d.dowloand(System.getProperty("user.dir") + "/update.zip", "/update.zip");
                            } catch(com.dropbox.core.v2.files.DownloadErrorException e){
                                JOptionPane.showMessageDialog(null, "Uma nova atualização ainda não foi disponibilizada, tente mais tarde!");
                                Arquivo.deleteFile("0000000000.txt");
                                
                                System.exit(0);
                            }

                            //Descompacta na pasta local
                           
                            File zipFile = new File(System.getProperty("user.dir") + "/update.zip");
                            File outDir = new File(System.getProperty("user.dir"));
                            Arquivo.uncompact(zipFile, outDir);
                            Email.enviarEmail(email, "O Cliente: " + dados[1] + " CNPJ: " + dados[0]+  " atualizou o qImob!", "Atualização qImob (SUCESSO)");
                            jProgressBar1.setValue(55);
                            //For para localizar todas as pastas do qimob
                            cont = jProgressBar1.getValue();
                            for (File f : files) {

                                cont += 1;
                                if (f.getName().toLowerCase().startsWith("qimob")) {
                                    File qimobDir = new File(f.getAbsolutePath());
                                    //A atualização só vai ser realizada para bancos configurados caso contrario não será atualizado

                                    if (!("qimob".equalsIgnoreCase(f.getName()))) {
                                        conect = new ConectDB(host, f.getAbsolutePath() + "/QIMOB.FDB", "SYSDBA", "masterkey");
                                        if (conect.connect()) {
                                            String dados1[] = ConectDB.getEmpresaCnpj(conect);
                                            String autorizacao1 = Arquivo.lerTxtVerif(System.getProperty("user.dir") + "/0000000000.txt", dados1[0]);

                                            if (autorizacao1.equalsIgnoreCase("1")) {
                                                //FileInputStream inputstream = new FileInputStream("iMob.exe");
                                              //  File file2 = new File(f.getAbsolutePath() + "\\iMob.exe");
                                                //Transferêcia da atualização
                                              //  FileUtils.copyInputStreamToFile(inputstream, file2);
                                              Arquivo.uncompact(zipFile, qimobDir);
                                              getInfo.setText(f.getAbsolutePath() + " (ATUALIZADO)");
                                            } else{
                                                if (autorizacao.equalsIgnoreCase("0")) {
                                                    Email.enviarEmail(email, "O Cliente: " + dados1[1] + " CNPJ: " + dados1[0] + " atualização bloqueada!", "Atualização qImob (BLOQUEADA)");
                                                    System.out.println(f.getAbsolutePath() + "( Não atualizado)");
                                                }
                                            }
                                        } else {
                                            sleep(100);
                                            getInfo.setText(f.getAbsolutePath() + " (NAO ATUALIZADO)");
                                            System.out.println(f.getAbsolutePath() + " nAo foi possível conectar com banco (NAO ATUALIZADO)");
                                        }

                                    }

                                    getInfo.setText("Atualizando..............");
                                }
                            }
                        } else {
                            if (autorizacao.equalsIgnoreCase("0")) {
                                Email.enviarEmail(email, "O Cliente: " + dados[1] + " CNPJ: " + dados[0]+  " atualização bloqueada!", "Atualização qImob (BLOQUEADA)");
                                Arquivo.deleteFile("0000000000.txt");
                                Arquivo.deleteFile("update.zip");
                                JOptionPane.showMessageDialog(null, "Sua atualização está bloqueada entre em contato com o suporte");
                                
                                System.exit(0);
                            } else {
                                Email.enviarEmail(email, "O Cliente: " + dados[1] + " CNPJ: " + dados[0]+  " cadastro não encontrado!", "Atualização qImob (NÃO ENCONTRADO)");
                                Arquivo.deleteFile("0000000000.txt");
                                Arquivo.deleteFile("update.zip");
                                JOptionPane.showMessageDialog(null, "Seu cadastro não foi localizado, entre em contato com o suporte!");
                                
                                System.exit(0);
                            }
                        }
                        Arquivo.deleteFile("0000000000.txt");
                        Arquivo.deleteFile("update.zip");
                        
                        for (int i = cont; i <= 100; i++) {
                            sleep(50);
                            jProgressBar1.setValue(i);
                            if (jProgressBar1.getValue() == 100) {
                                getInfo.setText("Finalizando..............");

                                // URL url = this.getClass().getResource("/imagens/icon.png");
                                /*  ImageIcon imagem = new ImageIcon(getClass().getResource("/imagens/iconn.png"));
                                JOptionPane.showMessageDialog(
                                    null,
                                    "qImob_1.0 Atualizado!",
                                    "qImob_1.0", JOptionPane.INFORMATION_MESSAGE,
                                    imagem); */
                                JOptionPane.showMessageDialog(null, "Sistema atualizado com a última atualização diponível no momento!");                                
                                
                                System.exit(0);
                            }
                        }
                    } catch (InterruptedException ex) {
                        System.out.println("Erro barra de progresso");
                    } catch (Exception ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel getInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
