package br.com.Matheus;

//classe pra fazer a lógica em si do csv que é o RecomendadorBuilder, essa

//import responsável por fazer o tratamento de exceções do nosso projeto
import org.apache.mahout.cf.taste.common.TasteException;

//import responsável para avaliar nosso RecomenderBuilder pra fazer toda essa lógica e jogar no nosso csv
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;

//import responsável por pegar o algoritmo da vizinhança e pegar quais são os usuários próximos para fazer a recomendação
// (fala que deve existir um tipo de vizinhança entre os usuários para fazer a recomendação)
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;

//import responsável por fazer recomendações baseada em usuários genéricos
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;

//import importa o algoritmo do Pearson Correlation Similarity que é exatamente pra pegar os usuários mais proximos para
// serem recomendados
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

//import esse é responsável por pegar aquele DataModel que configurei na outra classe que vai ser responsável por trazer
// o csv para ser avaliado
import org.apache.mahout.cf.taste.model.DataModel;

//import que pega os usuários que tem a vizinhança e joga para a próxima parte da avaliação do recomendador
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;

//import responsável por trazer a lógica do nosso recomendar para avaliar o csv passar por todas essas coisas importantes
// que não é de jogar recomendação
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

//import se baseia na orientação dos usuários e sempre vai pegar os usuários mais próximos
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadorBuilder implements RecommenderBuilder {

    public Recommender buildRecommender(DataModel model) throws TasteException {

        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        return recommender;
    }

}
