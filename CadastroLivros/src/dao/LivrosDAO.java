package dao;

import factory.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import modelo.Livros;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivrosDAO {
    private Connection connection;
    Long id;
    String descricao;
    String autor;
    
    public LivrosDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
     public void adiciona(Livros livros){ 
        String sql = "INSERT INTO livro(descricao,autor) VALUES(?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, livros.getDescicao());
            stmt.setString(2, livros.getAutor());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
      
    } 
     public List<Livros> Listar() throws SQLException{
          List<Livros> lista = new ArrayList<Livros>();
          String sql = "SELECT * FROM livro";
      PreparedStatement stmt = connection.prepareStatement(sql);
      try {
          ResultSet resultado = stmt.executeQuery();
          
          while (resultado.next()) {              
              Livros obj = new Livros();
              obj.setId(resultado.getLong("id"));
              obj.setDescicao(resultado.getString("descricao"));
              obj.setAutor(resultado.getString("autor"));
              lista.add(obj);
          }
      } catch (Exception e) {
          lista = null;
      }
                return lista;
            
      
}
     }


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  