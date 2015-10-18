import java.util.HashMap;
import java.util.HashSet;

public interface SimilarityAlgorithm {

	HashMap<Integer, Integer> getSimilar(String source1, String source2, String output, HashSet<Integer> filterSet);
	
	float getSimilarityScore(String first, String second);

}
