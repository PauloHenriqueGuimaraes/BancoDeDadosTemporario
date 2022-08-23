
/////////////////////           CODIGO ABERTO   /////////////////////////////////////
package temporaryDatabase;
/**
 @author Paulo Henrique
 */


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import temporaryDatabase.BancoDeDados; 

public class BancoDeDadosLayout extends JFrame  {
   
   public final  String dev =  "pauloHenrique";
    public final String data =  "27/07/2022";
    public final String version = "1.0";
    public final String type = "layout";
    
    
    //COMPONENTE..
    private JButton btnGravar;
    private JButton btnDeletar;
    private JButton btnFechar;
    private JTextField txtDado;
    private JTextField txtId;
    private JLabel lblId;
    private JLabel lblDado;
    private JLabel lblLista;
    private JTextArea txtArea;
    private JProgressBar progressBar;
    private JLabel diaEdata;
    
    
    //LAYOUT..
  

    
    
    public BancoDeDadosLayout(String nome_form){
    
        //definições padrao do layout
        setLayout(null);
        setTitle(nome_form);
        setSize(450,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         //definições dos componentes 
        definirComponente();
        
        //eventos
        eventos();
        
    }
    
    
    public BancoDeDadosLayout(){
    
        //definições padrao do layout
        setLayout(null);
        setTitle("Banco de Dados");
        setSize(450,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         //definições dos componentes 
        definirComponente();
        
        //eventos
        eventos(); 
    }
    
      //definições dos componentes ..
    public void definirComponente(){
     
        
     //Buttons nomes..
     btnGravar = new JButton("Gravar");
     btnDeletar = new JButton("Delete");
     btnFechar = new JButton("Fechar");
     
     //TextField tamanhos..
     txtDado = new JTextField(10);
     txtId = new JTextField(10);
     txtId.setEnabled(false);
     
     
     
     //Label name
      lblId = new JLabel("ID");
      lblDado = new JLabel("Digite o dado a ser gravado");
      lblLista = new JLabel("Lista de dados salvo");
      
      
      //TextArea tamanho
      txtArea = new JTextArea();
      
      //JProgress bar
      progressBar = new JProgressBar();
      
      
     
 
        
     //Buttons position..
     btnGravar.setBounds(20,50,120,25);
     btnDeletar.setBounds(150,50,120,25);
     btnFechar.setBounds(290,50,120,25);
     
    //TextField position..
      txtId.setBounds(40,120,350,30); 
     txtDado.setBounds(40,180,350,30); 
     
   
     //Label position
     lblId.setBounds(40,95,350,30); 
     lblDado.setBounds(40,155,350,30);
     lblLista.setBounds(40,220,350,100);
     
        //TextArea position
     txtArea.setBounds(40,240,350,180); 
     
    
        //JProgress bar position
      progressBar.setBounds(40,420,350,50);
      
        //data

        
     //add ao layout..
     add(btnGravar) ;
     add(btnDeletar);
     add(btnFechar);
     add(txtDado);
     add(txtId);
     add(lblDado);
     add(lblId);
     add(txtArea);
     add(lblLista);
     add(progressBar);
     
    }
    
     
    
     //eventos
    public void eventos(){
      
        //BTNGRAVAR
       btnGravar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evento){
            //variavel de informação
            String dado = "", id_ ; 
            int cont_memoria;
            
            if(txtDado.getText() == ""){
                JOptionPane.showMessageDialog(null,"O campo esta vazil" +  JOptionPane.ERROR_MESSAGE);
            }else{
                String dados_view;
                dado += txtDado.getText();
                BancoDeDados.gravar(dado); 
                txtArea.setText(dado + "\n");
                cont_memoria = BancoDeDados.getId_auto();
                id_ = String.valueOf(cont_memoria);
                txtId.setText(id_);
                txtDado.setText("");
                 progressBar.setValue(cont_memoria);
            }
          
        }
    });
       
       
       //BTN DELETAR
       btnDeletar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
             //active componete
               txtDado.setEnabled(false);
               btnGravar.setEnabled(false);
               btnFechar.setEnabled(false);
               txtId.setEnabled(true);
               
               //variavel boolean
               boolean active = false;
               
               //trocando para true
               active = true;
               
               //definindo os componentes 
               btnDeletar.setText("Deseja apagar");
               lblId.setText("Informe a posição que deseja apagar");
               
               
               //verificação
              
            
                   //se nao 
              
                   //variavel string id para receber 
                  String id;
                  //variavel int id para manda apagar 
                  try{
                        int id_;

                        id = txtId.getText();
                        id_ = Integer.parseInt(id);

                        BancoDeDados.comandoDELETE("DELETE",id_);

                      btnDeletar.setText("Deletar");
                     lblId.setText("Id");
                     txtId.setEnabled(false);
                     txtDado.setEnabled(true);
                     btnGravar.setEnabled(true);
                     btnFechar.setEnabled(true);
                     txtId.setText(""); 
                 }
                  catch(NumberFormatException error)
                  {
                   JOptionPane.showMessageDialog(null,"Digite apenas numeros" + JOptionPane.ERROR_MESSAGE);   
                   txtId.setText("");
                  }
                  
               
                   
               
           }
       });
       
       btnFechar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            System.exit(1);
        }
    });
    }

 

}
