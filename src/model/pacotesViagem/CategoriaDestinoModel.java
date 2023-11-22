package model.pacotesViagem;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDestinoModel {
    private static Set<String> categoriasDestino; // Uma "lista" de categorias (Aventura, Relaxamento, Cultura, etc)
    private CategoriaDestinoModel(){
        categoriasDestino = new HashSet<>();
    }

    public static Set<String> getCategoriasDestino() {
        return categoriasDestino;
    }

    public static void setCategoriasDestino(Set<String> categoriasDestino) {
        CategoriaDestinoModel.categoriasDestino = categoriasDestino;
    }

    public static void addCategoria(String categoria){
        categoriasDestino.add(categoria);
    }
}
