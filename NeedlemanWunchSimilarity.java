import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;
import uk.ac.shef.wit.simmetrics.similaritymetrics.NeedlemanWunch;

public class NeedlemanWunchSimilarity extends SimilarityImplementation implements SimilarityAlgorithm {
	
	public AbstractStringMetric metric = new NeedlemanWunch();

	@Override
	public void getSimilarity(String source1, String source2, String output) {
		// TODO Auto-generated method stub
		try {
			ArrayList<String> sourceRecords1 = readInput(source1);
			ArrayList<String> sourceRecords2 = readInput(source2);

			HashMap<Integer, Integer> map = findSimilar(sourceRecords1, sourceRecords2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public AbstractStringMetric getMetric() {
		// TODO Auto-generated method stub
		return metric;
	}

}
