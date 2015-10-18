public class Similarity {

	public static void main(String[] args) {
		String sourceFile1 = args[0];
		String sourceFile2 = args[1];
		String output = args[2];

		// check LevenStein's similarity
		SimilarityFactory similarityFactory = new SimilarityFactory();

		SimilarityAlgorithm algorithm;

		// algorithm = similarityFactory.getAlgorithm("LEVENSTEIN");
		// algorithm.getSimilar(sourceFile1, sourceFile2, output);

		// algorithm = similarityFactory.getAlgorithm("NEEDLEMAN-WUNSCH");
		// algorithm.getSimilar(sourceFile1, sourceFile2, output);

		// algorithm = similarityFactory.getAlgorithm("SMITHWATERMAN");
		// algorithm.getSimilar(sourceFile1, sourceFile2, output,null);

		// algorithm = similarityFactory.getAlgorithm("JAROWINKLER");
		// similarityMap = algorithm.getSimilar(sourceFile1, sourceFile2,
		// output, null);

		 algorithm = similarityFactory.getAlgorithm("JACCARD");
		 algorithm.getSimilar(sourceFile1, sourceFile2, output, null);

		// algorithm = similarityFactory.getAlgorithm("MONGE-ELKAN");
		// algorithm.getSimilar(sourceFile1, sourceFile2, output, null);

	}

}
