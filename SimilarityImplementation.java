import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public abstract class SimilarityImplementation {

	public abstract AbstractStringMetric getMetric();

	protected HashMap<Integer, Integer> findSimilar(ArrayList<String> sourceRecords1, ArrayList<String> sourceRecords2)
			throws IOException {
		HashMap<Integer, Integer> similarMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < sourceRecords1.size(); i++) {
			float maxSimilarityScore = 0;
			int similarEntry = 0;
			for (int j = 0; j < sourceRecords2.size(); j++) {
				float similarityScore = getMetric().getSimilarity(sourceRecords1.get(i), sourceRecords2.get(j));
				if (maxSimilarityScore < similarityScore) {
					similarEntry = j;
					maxSimilarityScore = similarityScore;
				}
			}

			System.out.println((i + 1) + "--->" + (similarEntry + 1) + "--->" + maxSimilarityScore);
			similarMap.put(i + 1, similarEntry + 1);
		}

		return similarMap;
	}

	protected ArrayList<String> readInput(String source) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(source));
		ArrayList<String> inputRecords = new ArrayList<String>();

		String str = "";
		while ((str = br.readLine()) != null) {
			inputRecords.add(getStringAfterDelimiter(str));
		}
		br.close();
		return inputRecords;
	}

	private String getStringAfterDelimiter(String text) {
		return text.substring(text.indexOf("---") + 3);
	}

}
