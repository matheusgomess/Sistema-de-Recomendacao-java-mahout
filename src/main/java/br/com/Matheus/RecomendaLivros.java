package br.com.Matheus;

//Essa classe faz praticamente a mesma coisa do RecomendaFilmes só que aqui ela vai recomendar livros, vai criar um novo
// recomendador usando DataModel, vai instanciar o novo Recommender com RecomendadorBuilder usando uma lista de produtos,
// vai gerar uma lista com as recomendalções, pro usuário 1 vai gerar 4 recomendações
// e vai imprimir no console essas recomendações

import org.apache.mahout.cf.taste.common.TasteException;

import org.apache.mahout.cf.taste.model.DataModel;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;

import java.util.List;

public class RecomendaLivros {

    public static void main(String[] args) throws TasteException, IOException {

        DataModel livros = new Recomendador().getModeloLivros();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(livros);

        System.out.println("Usuario 1");

        List<RecommendedItem> recommendations = recommender.recommend(1, 10);

        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Usuario 1, estes livros combinam com você");
            System.out.println(recommendation);
        }
    }

}
