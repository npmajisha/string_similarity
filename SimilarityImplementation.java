import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

public abstract class SimilarityImplementation {

	public abstract AbstractStringMetric getMetric();

	public abstract float getThreshold();

	protected HashMap<Integer, Integer> findSimilar(ArrayList<String> sourceRecords1, ArrayList<String> sourceRecords2,
			HashSet<Integer> filterSet) throws IOException {
		HashMap<Integer, Integer> similarMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < sourceRecords1.size(); i++) {
			float maxSimilarityScore = 0;
			int similarEntry = 0;
			for (int j = 0; j < sourceRecords2.size(); j++) {
				float similarityScore = getSimilarityScore(sourceRecords1.get(i), sourceRecords2.get(j));
				if (maxSimilarityScore < similarityScore) {
					similarEntry = j;
					maxSimilarityScore = similarityScore;
				}
			}
			if (maxSimilarityScore >= getThreshold() && filterId(filterSet, i + 1)) {
//
//				 System.out.println((i + 1) + ":" + sourceRecords1.get(i) +
//				 "--->" + (similarEntry + 1) + ":"
//				 + sourceRecords2.get(similarEntry) + "--->" +
//				 maxSimilarityScore);

				similarMap.put(i + 1, similarEntry + 1);
			}
		}

		return similarMap;
	}

	public float getSimilarityScore(String first, String second) {
		return getMetric().getSimilarity(first, second);
	}

	protected ArrayList<String> readInput(String source) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(source));
		ArrayList<String> inputRecords = new ArrayList<String>();

		String str = "";
		while ((str = br.readLine()) != null) {
			inputRecords.add(getStringAfterDelimiter(str.toLowerCase()));
		}
		br.close();
		return inputRecords;
	}

	protected void printOutput(String source1, String source2, String output, ArrayList<String> sourceRecords1,
			ArrayList<String> sourceRecords2, HashMap<Integer, Integer> map) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		for (int i = 0; i < sourceRecords1.size(); i++) {
			if (map.get(i + 1) != null /* && checkInTestFile(i+1) */) {
				String result = String.format("%s:%d\t%s:%d", source1, i + 1, source2, map.get(i + 1));
				bw.write(result + "\n");
			}
		}
		bw.close();
	}

	private boolean filterId(HashSet<Integer> ids, int id) {
		if (ids != null) {
			return ids.contains(id);
		}
		return true;
	}

	// private boolean checkInTestFile(int id) {
	// HashSet<Integer> groundTruth = new HashSet<Integer>();
	// int[] ids = new int[] { 176, 225, 256, 234, 216, 228, 49, 64, 288, 152,
	// 55, 198, 213, 272, 36, 284, 70,
	// 227, 112, 119 };
	// for (int i = 0; i < ids.length; i++) {
	// groundTruth.add(ids[i]);
	// }
	// return groundTruth.contains(id);
	// }

	private String getStringAfterDelimiter(String text) {
		return text.substring(text.indexOf("---") + 3).replace(".", "").replace("east", "e").replace("west", "w")
				.replace("north", "n").replace("south", "s");
	}

}
