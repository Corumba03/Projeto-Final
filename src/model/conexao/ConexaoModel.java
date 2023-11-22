package model.conexao;

import java.sql.Connection;

interface ConexaoModel {

    Connection connection = null;
    void encerrarConexao();
}


