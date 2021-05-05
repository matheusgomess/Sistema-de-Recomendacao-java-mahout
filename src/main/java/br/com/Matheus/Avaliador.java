package br.com.Matheus;

//Essa classe vai avaliar a acurácia do nosso sistema, seria ver a taxa de erro, a taxa de distância entre uma pessoa e
//outra com a base que a gente tem atualmente

import org.apache.mahout.cf.taste.common.TasteException;

import org.apache.mahout.cf.taste.eval.RecommenderBuilder;

//esse import vai avaliar nosso recomendador
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;

//esse vai calcular a diferença entre as pessoas em nossa base de recomendação e daí ele gera a taxa de acurácia
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;

import org.apache.mahout.cf.taste.model.DataModel;

import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

public class Avaliador {

    public static void main(String[] args) throws TasteException, IOException {

        //useTestSeed(); ele permite avaliar valores de testes impedindo resultados aleatórios a cada teste que realizar
        RandomUtils.useTestSeed();

        //esse DataModel ele vai pegar o modelo de filmes para fazer a avaliação
        DataModel modelo = new Recomendador().getModeloDeFilmes();

        //esse RecommenderEvaluator ele vai calcular a média absoluta entre todos os usuários pra ver qual a diferença entre eles
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();

        RecommenderBuilder builder = new RecomendadorBuilder();

        //aí pra treino usamos o nosso modelo, usamos 90% do csv de filmes pra treino e 10% pra teste e disso ele vai gerar
        //a taxa de erro do nosso sistema falando se ele ta com a acurácia que é a taxa de acerto digamos assim muito grande ou não
        double erro = evaluator.evaluate(builder, null, modelo, 0.9, 1.0);

        System.out.println("A taxa de erro desse Sistema de Recomendação atual é de:");
        System.out.println(erro);

    }
}
