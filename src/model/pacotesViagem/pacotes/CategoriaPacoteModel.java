package model.pacotesViagem.pacotes;

import java.util.HashSet;
import java.util.Set;

public class CategoriaPacoteModel {
    private static Set<String> categoriasPacote; // Uma "lista" de categorias (Aventura, Relaxamento, Cultura, etc)
    private CategoriaPacoteModel(){
        categoriasPacote = new HashSet<>();
    }

    public static Set<String> getCategoriasPacote() {
        return categoriasPacote;
    }

    public static void setCategoriasPacote(Set<String> categoriasPacote) {
        CategoriaPacoteModel.categoriasPacote = categoriasPacote;
    }

    public static void addCategoria(String categoria){
        categoriasPacote.add(categoria);
    }
}
