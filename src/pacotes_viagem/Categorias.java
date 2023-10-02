package pacotes_viagem;

import java.util.HashSet;
import java.util.Set;

public class Categorias {
    private static Set<String> categorias; // Uma "lista" de categorias (Aventura, Relaxamento, Cultura, etc)
    private Categorias (){
        categorias = new HashSet<>();
    }

    public static Set<String> getCategorias() {
        return categorias;
    }

    public static void setCategorias(Set<String> categorias) {
        Categorias.categorias = categorias;
    }

    public static void addCategoria(String categoria){
        categorias.add(categoria);
    }
}
