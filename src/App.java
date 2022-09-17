// Código java para serializar e desserializar um objeto

import java.io.*;
  
class funcionario implements java.io.Serializable
{
    public int idade;
    public String nome;
  
    // Construtor padrão
    public funcionario(int idade, String nome)
    {
        this.idade = idade;
        this.nome = nome;
    }
  
}
  
class Test
{
    public static void main(String[] args){   

        funcionario object = new funcionario(27, "Vinícius");
        String filename = "serializacao.ser";
          
        // Serialização
        try
        {   
            //Salvando o objeto no arquivo
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
              
            // Método para serializar um objeto
            out.writeObject(object);
              
            out.close();
            file.close();
              
            System.out.println("Objeto foi serializado com sucesso!");
  
        }
          
        catch(IOException ex)
        {
            System.out.println(ex);
        }
  
  
        funcionario object1 = null;
  
        // Desserialização
        try
        {   
            // Lendo o objeto do arquivo
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Método de desserialização 
            object1 = (funcionario)in.readObject();
              
            in.close();
            file.close();
              
            System.out.println("O objeto foi desserializado!");
            System.out.println("nome = " + object1.nome);
            System.out.println("idade = " + object1.idade);
        }
          
        catch(IOException ex)
        {
            System.out.println(ex);
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
  
    }
}