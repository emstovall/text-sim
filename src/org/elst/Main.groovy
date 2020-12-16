package org.elst

import org.elst.ml.TextSimilarity

//Take in 2 texts
//Exact Match returns 1
//No Matches returns 0

//Sample Text 1
//The easiest way to earn points with Fetch Rewards is to just shop for the products you already love. If you have any participating brands on your receipt, you'll get points based on the cost of the products. You don't need to clip any coupons or scan individual barcodes. Just scan each grocery receipt after you shop and we'll find the savings for you.

//Sample Text 2
//The easiest way to earn points with Fetch Rewards is to just shop for the items you already buy. If you have any eligible brands on your receipt, you will get points based on the total cost of the products. You do not need to cut out any coupons or scan individual UPCs. Just scan your receipt after you check out and we will find the savings for you.

//Sample Text 3
//We are always looking for opportunities for you to earn more points, which is why we also give you a selection of Special Offers. These Special Offers are opportunities to earn bonus points on top of the regular points you earn every time you purchase a participating brand. No need to pre-select these offers, we'll give you the points whether or not you knew about the offer. We just think it is easier that way.


String text1, text2;
int nGramSize = 2;

//Validate there are 2 arguments provided
if(this.args.size() != 2 ) {
	println("Please provide 2 arguments.")
	println("argument 1 is the first text you want to compare")
	println("argument 2 is the second text you want to compare")

}
//Read in first 2 arguments
text1 = args[0]
text2 = args[1]

//return cosine similarity
def result = TextSimilarity.cosineSimilarityScore(text1, text2)
println("Score for the 2 inputs provided using $nGramSize word grams is:")
println(result)