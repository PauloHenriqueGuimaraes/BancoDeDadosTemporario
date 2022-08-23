


//false = memoria padrao
 // true = memoria nova
package temporaryDatabase;

import java.text.*;
import java.util.*;

/*
Esta classe ela vai capturar os dados do usuário, guarda numa posição do ARRAY, e
depois vai manter guardado por tempo que o programa estiver executando.....
*/


import javax.swing.JOptionPane;


public class BancoDeDados {
   public final  String dev =  "pauloHenrique";
    public final String data =  "23/07/2022";
    public final String version = "2.0";
    
    
    
    
  //variáveis ids
    private static int  tamanhoM, id_auto, id_memoria_modificada;

    
    //memorias
    private static String[] memoriaPadrao = new String[100];
    private static String[] memoria_2 = new String[tamanhoM]; 
   
    
 //operadores de ativação  
private static boolean activeMemoria = false;


//variavel do HELP
private static int simNao, tenteNovaMente = 0;

    


//Construtor da class.
public  BancoDeDados(){

}




//Ativação de memória 2, para o uso precisa usar este método para ativação uma vez ativada, poderá utilizar todos os métodos que
//que automaticamente ele vai utilizar a memória 2;
public static void centralDeMemoriaActive(boolean ac)
{
    
    if(ac == false && activeMemoria==false ){
       System.out.println("Esta memoria já está desabilitada" + " Error XX"); 
    }
    
    
    else if(ac == true && activeMemoria==false){
       activeMemoria = true; 
    }
    else if(ac == true && activeMemoria==true){
     System.out.println( "Esta memoria já está ativada" + " Error XX"); 

    }
      else if(ac == false && activeMemoria==true){
        activeMemoria = false;
    }
}
    
//gravar date
public static String setDate(){
    Date time = new Date();
    time.getTime();
    DateFormat formatacao = DateFormat.getDateInstance(DateFormat.LONG);
    String  tempo = formatacao.format(time);
    return tempo;
}


//Este método só vai funcionar após a sua ativação, 
// O método exige que passa um número inteiro ele vai definir o tamanho da memória.
 public static void AumentoDeMemoria ( int tamanho){
     
     if(activeMemoria == true){
       BancoDeDados.tamanhoM = tamanho;
       
       System.out.println("Aumento de memória ativada" + "Informação");
     }
     else{
         System.out.println("Esta memoria não está ativada para o aumento" + " Error"); 
     }
     
 }
  
 
 
 //Aqui ele traz número aleatório.
 public static  int idAleatorio(){
    
     
     int aleatorio;
    Random al = new  Random();
     aleatorio = al.nextInt() * 6;
     return aleatorio; 
 }
 
 
 
 //Este método grava dados, e ele defini a posição automaticamente.
public static  void gravar(String dado){
    
    if(activeMemoria == true){
      
        id_memoria_modificada ++;
        memoria_2[id_memoria_modificada] = dado ; 
    }
    else{
      
        id_auto++;
       memoriaPadrao[id_auto] = dado;
    }
}
 



//Este método vai fazer o retorno de uma String
public  String conexao_class(){
    return "Conexao aberta";
}



//Este método retorna um registro, na posição que for passada pelo usuário.
public static  String consultar(int id ){
    
    if(activeMemoria == true){

       return memoria_2[id]  ;
    }
    else{
       
      return memoriaPadrao[id];
    }
 
}




//Este método e para definir um tamanho de repetição para guardar os dados. Ele precisa um número inteiro mas os dados do tipo String.
//ele vai repetir quantas vezes foi definido.
public static void autoGravar( int quantas_vezes_cadastrar, String message ){
   
    int vezes = 1;
   
    
    if(activeMemoria == true){
     String dado;
        while( vezes <= quantas_vezes_cadastrar){
         vezes++; 
        
        dado =  JOptionPane.showInputDialog(message);
         
        id_memoria_modificada ++;
        memoria_2[id_memoria_modificada] = dado ; 
        }
    
    }
    else{
        
        String dado;
        while( vezes <= quantas_vezes_cadastrar){
         vezes++; 
        
        dado =  JOptionPane.showInputDialog(message);
         
        
       id_auto++;
       memoriaPadrao[id_auto] = dado;
        }
    }
}

//GET DO ID
//id_memoria_modificada 
// id_auto

public static int getId_auto(){
    return id_auto;
}

public static int getId_Memoria_Modificada(){
    return id_memoria_modificada;
}
//Aqui ele vai listar todos os ARRAY
public static  void listarAll(){
    
    
    if(activeMemoria == true){
       int i = 0;
       while( i <= id_memoria_modificada){
           i ++;
         // System.out.println(memoria_2[i]) ;
          
           System.out.println("Dados :" + memoria_2[i]);
       }    
      
    }
    
    else{   
         int i = 0;
       while( i <= id_auto){
           i ++;
          // System.out.println( memoriaPadrao[i]) ;
          System.out.println("Dados :" + memoriaPadrao[i]);
       }      
    }
}


/////////////////////////////           CRUD        /////////////////////////////////

//SELECT * FROM
public static String comandoSELECT(String comando_pricipal, int comando ){

    if(comando_pricipal == "SELECT * FROM" ){
       
        
        if(activeMemoria == true){
            
            
            if(memoria_2[comando] == null){
                 return ("Não tem dado nesta posição" + " Erro XXXXXXX" );
            }
            else{
              return memoria_2[comando];  
            }           
            
        }
        else{
             
            if(memoriaPadrao[comando] == null){
              return ("Não tem dado nesta posição" + " Erro XXXXXXX" ); 
            }
            else{
               return memoriaPadrao[comando];  
            }
            
        } 
        
        
    }else{
        return "Codigo esta errado";
    }

}


//INSERT INTO 
public static String comandoINSERT(String comando, String dados){
  
    if(comando == "INSERT INTO"){
   
        if(activeMemoria == true){

           id_memoria_modificada ++;
           memoria_2[id_memoria_modificada] = dados ; 
           return "Gravado";
       }
       else{

           id_auto++;
          memoriaPadrao[id_auto] = dados;
          return "Gravado";
       }
        
    }
    else{
        return "Comando invalido";
    }
    
    
   
    
    
}


//UPDATE DADOS WHERE ID
public static String comandoUPDATE( String comando_up, String dado ,String command_where,int position){
 
    if(comando_up == "UPDATE" && command_where == "WHERE")
    {
       if(activeMemoria == true){
           memoria_2[position] = dado ; 
           return "Atualizado";
       }
       else{
          memoriaPadrao[position] = dado;
          return "Atualizado";
       }  
    }else{
        return "Codigo esta errado";
    }
   
}


public static String comandoDELETE(String comando, int position){
   if(comando == "DELETE")
    {
       if(activeMemoria == true){
           memoria_2[position] = null ; 
           return "Apagado";
       }
       else{
          memoriaPadrao[position] = null;
          return "Apagado";
       }  
    }else{
        return "Codigo esta errado";
    } 
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////// DATA E HORA /////////////////////////////////////////////////////////

public static long DataHoraAgora(){
    Date dataHora = new Date();
    return dataHora.getTime();
}


public static String formatarDataHoraPadrao(String tipoFormatacao, long dataHora){
    switch(tipoFormatacao){
        case "LONG":
            DateFormat formaPadraoLONG = DateFormat.getDateInstance(DateFormat.LONG);
            return formaPadraoLONG.format(dataHora);
           
        
        case "FULL":
             DateFormat formaPadraoFULL = DateFormat.getDateInstance(DateFormat.FULL);
            return formaPadraoFULL.format(dataHora);
            
            
             case "MEDIUM":
             DateFormat formaPadraoMEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return formaPadraoMEDIUM.format(dataHora);
         
            
            
             case "SHORT":
             DateFormat formaPadraoSHORT = DateFormat.getDateInstance(DateFormat.SHORT);
            return formaPadraoSHORT.format(dataHora);
           
            
            
             case "DEFAULT":
             DateFormat formaPadraoDEFAULT = DateFormat.getDateInstance(DateFormat.DEFAULT);
            return formaPadraoDEFAULT.format(dataHora);
          
 }
    return "Não identificado!!!";
}


public static String formatarDataHora(String formatacao, long dataHora){
    
    DateFormat formatarDataHora = new SimpleDateFormat(formatacao);
   return formatarDataHora.format(dataHora); 
   
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////                     HELP            ///////////////////////////////////////////////////////////


//Verificação se a memoria esta ativada..........
public static void status(){
   
    if(activeMemoria == false){
         System.out.println("Memoria " + activeMemoria + " Memoria não ativada" );     
    }
    else{
        
        System.out.println("Memoria " + activeMemoria + " Memoria ativada" );     
    }
}



//Como ativar a memoria para poder fazer sua alteração..........
public static void comoAtivar(){

    try{
   
            JOptionPane.showMessageDialog(null,"1 - Usar o método 'centralDeMemoriaActive' e passar o valor 'true' \n"
                    + "2 - depois usar o método 'AumentoDeMemoria' e passar o numero inteiro que ira fala o tamanho da memoria."
             +JOptionPane.INFORMATION_MESSAGE);  



            if(activeMemoria == false){


               

               simNao =  Integer.parseInt(JOptionPane.showInputDialog("Deseja ativar a memoria? Responda 1- Sim ou 0 - Não"));  



                while(simNao != 1 || simNao != 0)
                 {
                       tenteNovaMente++;
                    simNao =  Integer.parseInt(JOptionPane.showInputDialog("Deseja ativar a memoria? Responda 1- Sim ou 0 - Não") + "Tentativas: " + tenteNovaMente); 


                    if(tenteNovaMente == 3){
                        JOptionPane.showMessageDialog(null,"Digito errado");
                        break;

                    }

                 }



                 if(simNao == 1){
                   activeMemoria = true;  
                    JOptionPane.showMessageDialog(null,"Memoria     " + activeMemoria + "   Ja Esta pronta para o uso " );  

                 }

                 else if(simNao == 0){

                    activeMemoria = false;  

                      JOptionPane.showMessageDialog(null,"Memoria   " + activeMemoria + "   Esta desativada " );  
                 }

            }
            else{

                JOptionPane.showMessageDialog(null,"Memoria " + activeMemoria + " Memoria ativada" );     
            }


    
    } catch(NumberFormatException e){
        
        JOptionPane.showMessageDialog(null,"Erro no formato" );
        tenteNovaMente = 3;
    }

    
}


public  String toString(){
    return "centralDeMemoriaActive \n"
            + "AumentoDeMemoria\n"
            + "idAleatorio \n"
            + "gravar\n"
            + "conexao_class\n"
            + "consultar\n"
            + "autoGravar\n"
            + "status\n"
            + "comoAtivar\n"
            + "listarAll\n"
            + "comandoSELECT\n"
            + "comandoINSERT\n"
            + "comandoUPDATE\n"
            + "comandoDELETE\n";
}
//gerar dada :: 



// Proximo versão conexao com o banco de dados.............................
}