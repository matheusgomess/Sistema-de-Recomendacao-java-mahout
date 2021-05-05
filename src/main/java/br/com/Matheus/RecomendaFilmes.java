package br.com.Matheus;

//Essa classe RecomendaFilmes vai fazer basicamente pegar toda a lógica que o RecomendadorBuilder já fez e implementar
// isso pra gerar uma recomendação de filmes no console mesmo

import org.apache.mahout.cf.taste.common.TasteException;

import org.apache.mahout.cf.taste.model.DataModel;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;

import java.util.List;

public class RecomendaFilmes {

    public static void main(String[] args) throws IOException, TasteException {

        DataModel filmes = new Recomendador().getModeloDeFilmes();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(filmes);

        List<RecommendedItem> recommendations = recommender.recommend(4, 10); //o que eu fiz nessa linha? Pedi pro usuário 4, 3 recomendações

        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Você pode gostar deste filme =D");
            System.out.println(recommendation);
        }
    }
}
