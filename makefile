### CSCI548 - Fall 2015 - HW7 Makefile

main: Similarity.class
Similarity.class : Similarity.java simmetrics_jar_v1_6_2_d07_02_07.jar SimilarityFactory.java SimilarityAlgorithm.java SimilarityImplementation.java MyJaccardSimilarity.java JaroWinklerSimilarity.java LevensteinSimilarity.java MongeElkanSimilarity.java NeedlemanWunchSimilarity.java SmithWatermanSimilarity.java
	javac -cp ".:./simmetrics_jar_v1_6_2_d07_02_07.jar" Similarity.java SimilarityFactory.java SimilarityAlgorithm.java SimilarityImplementation.java MyJaccardSimilarity.java JaroWinklerSimilarity.java LevensteinSimilarity.java MongeElkanSimilarity.java NeedlemanWunchSimilarity.java SmithWatermanSimilarity.java
clean:
	rm *.class

