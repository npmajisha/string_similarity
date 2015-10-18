
public class SimilarityFactory {

	public SimilarityAlgorithm getAlgorithm(String algorithm) {
		if (algorithm.equals("LEVENSTEIN")) {
			return new LevensteinSimilarity();
		} else if (algorithm.equals("NEEDLEMAN-WUNSCH")) {
			return new NeedlemanWunchSimilarity();
		} else if (algorithm.equals("SMITHWATERMAN")) {
			return new SmithWatermanSimilarity();
		} else if (algorithm.equals("JAROWINKLER")) {
			return new JaroWinklerSimilarity();
		} else if (algorithm.equals("JACCARD")) {
			return new MyJaccardSimilarity();
		} else if (algorithm.equals("MONGE-ELKAN")) {
			return new MongeElkanSimilarity();
		}

		return null;
	}

}
