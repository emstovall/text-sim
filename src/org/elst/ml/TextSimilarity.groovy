package org.elst.ml;

import java.util.List;
import java.util.Map;

public class TextSimilarity {

	private static Map countNGramFreq(String[] words, distance) {
		def nGramMap = [:]
		int charSize = words.size()

		for (int i = 0 ; i + distance < charSize; i++){
			def gram = words[i..(i + distance)]
			nGramMap[gram] = 1 + nGramMap.get(gram, 0) //add 1 to current value (if any)
		}

		return nGramMap
	}

	private static double dotProduct(Map<List, Integer> map1, Map<List, Integer> map2){

		def values = map1.keySet().collect {
			key ->
				map1[key] * map2.get(key, 0)
		}

		return values.sum()
	}

	//default to bigrams if no distance is passed
	public static double cosineSimilarityScore(firstString, secondString, distance = 1){
		def text1NGrams = countNGramFreq(firstString.toLowerCase().split(),distance)
		def text2NGrams = countNGramFreq(secondString.toLowerCase().split(),distance)
		return dotProduct(text1NGrams,text2NGrams) / Math.sqrt(dotProduct(text1NGrams,text1NGrams) * dotProduct(text2NGrams,text2NGrams))
	}
}
