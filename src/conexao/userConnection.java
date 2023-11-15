package conexao;

import java.util.HashMap;
import java.util.Map;

interface UserConnection{

    Map<String, String> dados = new HashMap<>();

    // Consulta dados referentes ao proprio usuario
    public Map<String, String> consultarDados(int id);

    // Consulta destinos que o usuario referente ao id possui
    public Map<String, String> consultarDestinos(int id);
}
