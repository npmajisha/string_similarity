import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch;

public class NeedlemanWunchSimilarity extends SimilarityImplementation implements SimilarityAlgorithm {

	public AbstractStringMetric metric = new NeedlemanWunch();

	@Override
	public HashMap<Integer, Integer> getSimilar(String source1, String source2, String output,
			HashSet<Integer> filterSet) {
		HashMap<Integer, Integer> map = null;
		try {
			ArrayList<String> sourceRecords1 = readInput(source1);
			ArrayList<String> sourceRecords2 = readInput(source2);

			map = findSimilar(sourceRecords1, sourceRecords2, filterSet);

			printOutput(source1, source2, output, sourceRecords1, sourceRecords2, map);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public AbstractStringMetric getMetric() {
		return metric;
	}

	@Override
	public float getThreshold() {
		return 0;
	}

}
