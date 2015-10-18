import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaccardSimilarity;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex;

public class MyJaccardSimilarity extends SimilarityImplementation implements SimilarityAlgorithm {
	public AbstractStringMetric metric = new JaccardSimilarity();

	@Override
	public HashMap<Integer, Integer> getSimilar(String source1, String source2, String output,
			HashSet<Integer> filterSet) {
		HashMap<Integer, Integer> map = null;
		try {
			ArrayList<String> sourceRecords1 = readInput(source1);
			ArrayList<String> sourceRecords2 = readInput(source2);

			map = findSimilar(sourceRecords1, sourceRecords2, filterSet);
			HashMap<Integer, Integer> filteredMap = new HashMap<Integer, Integer>();
			for (Integer id : map.keySet()) {
				if (new Soundex().getSimilarity(sourceRecords1.get(id - 1),
						sourceRecords2.get(map.get(id) - 1)) >= 0.83) {

//					 System.out.println(id + ":" + sourceRecords1.get(id - 1)
//					 + "-->" + map.get(id) + ":"
//					 + sourceRecords2.get(map.get(id) - 1) + new Soundex()
//					 .getSimilarity(sourceRecords1.get(id - 1),
//					 sourceRecords2.get(map.get(id) - 1)));

					filteredMap.put(id, map.get(id));
				}
			}

			printOutput(source1, source2, output, sourceRecords1, sourceRecords2, filteredMap);

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
		float threshold = (float) 0.46;
		return threshold;
	}

}
