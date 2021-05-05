package br.com.Matheus;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;


public class Recomendador {

    //vou lannçar um exception do DataModel pra ele fazer essa leitura do csv que eu vou importar depois
    public DataModel getModeloLivros() throws IOException {
        return getModelo("books.csv");
    }

    //esse método getModelo ele vai pegar o caminho dos seus arquivos e jogar dentro do seu sistema pra ele fazer a avaliação
    private DataModel getModelo(String path) throws IOException {
        File file = new File("src/main/resources/" + path);
        return new FileDataModel(file);
    }


    public DataModel getModeloDeFilmes() throws IOException {
        return getModelo("movies.csv");
    }

//    private DataModel getModelo(String path) throws IOException {
//        File file = new File("src/main/resources" + path);
//        return new FileDataModel(file);
//    }

}
