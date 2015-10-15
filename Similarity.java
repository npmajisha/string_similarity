
public class Similarity {

	public static void main(String[] args) {
		String sourceFile1 = args[0];
		String sourceFile2 = args[1];
		String output = args[2];
		
		//check LevenStein's similarity
		SimilarityFactory similarityFactory = new SimilarityFactory();
		
		SimilarityAlgorithm algorithm ;
		
		algorithm = similarityFactory.getAlgorithm("LEVENSTEIN");
		algorithm.getSimilarity(sourceFile1, sourceFile2, output);
		
		algorithm = similarityFactory.getAlgorithm("NEEDLEMAN-WUNSCH");
		algorithm.getSimilarity(sourceFile1, sourceFile2, output);
		
		algorithm = similarityFactory.getAlgorithm("SMITHWATERMAN");
		algorithm.getSimilarity(sourceFile1, sourceFile2, output);

	}

}
