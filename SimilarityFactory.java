
public class SimilarityFactory {

	public SimilarityAlgorithm getAlgorithm(String algorithm) {
		if (algorithm.equals("LEVENSTEIN")) {
			return new LevensteinSimilarity();
		}
		else if(algorithm.equals("NEEDLEMAN-WUNSCH")){
			return new NeedlemanWunchSimilarity();
		}
		else if(algorithm.equals("SMITHWATERMAN")){
			return new SmithWatermanSimilarity();
		}

		return null;
	}

}
