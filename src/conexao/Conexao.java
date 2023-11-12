package conexao;

import java.sql.Connection;

interface Conexao {

    Connection connection = null;
    void encerrarConexao();
}


