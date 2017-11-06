
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suporte
 */
public class teste {
    public static void main(String args[]) throws SQLException{
        ConectDB cc = new ConectDB("localhost", "c:/qimob1/QIMOB.FDB", "SYSDBA", "masterkey");
        
        if(cc.connect()){
            System.out.println("conectado");
        } else {
            System.out.println("Não conectado");
        }
        
      ResultSet  rs =  cc.executar("SELECT *FROM setup ");
      
      while (rs.next())
     {
        String linha = rs.getString("EMPRESA");
        
        String linha1 = rs.getString("SET_CNPJ");
        if(!(linha1 == null)){
            linha1 = linha1.replace(".", "");
        linha1 = linha1.replace("/", "");
        linha1 = linha1.replace("-", "");
        }
        }
        
       // System.out.println("Cliente:" +linha + " CNPJ: " + linha1);
     }
      
 
    
    
    
  
}
