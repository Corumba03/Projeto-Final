package model.conexao;
import java.util.Map;

interface UserConnectionModel{

    // Consulta dados referentes ao proprio usuario
    public Map<String, String> consultarDados(int id);
}
