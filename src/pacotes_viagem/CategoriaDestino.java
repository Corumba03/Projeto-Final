package pacotes_viagem;

import java.util.HashSet;
import java.util.Set;

public class CategoriaDestino {
    private static Set<String> categoriasDestino; // Uma "lista" de categorias (Aventura, Relaxamento, Cultura, etc)
    private CategoriaDestino(){
        categoriasDestino = new HashSet<>();
    }

    public static Set<String> getCategoriasDestino() {
        return categoriasDestino;
    }

    public static void setCategoriasDestino(Set<String> categoriasDestino) {
        CategoriaDestino.categoriasDestino = categoriasDestino;
    }

    public static void addCategoria(String categoria){
        categoriasDestino.add(categoria);
    }
}
