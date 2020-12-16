## Fetch Rewards Text Similarity Exercise
My take on the requirements outlined by Fetch Rewards:
Your objective is to write a program that takes as inputs two texts and uses a metric to determine how similar they are. Documents that are exactly the same should get a score of 1, and documents that don’t have any words in common should get a score of 0. 
### Description
My solution defaults to using bigrams to get a count for each bigram occurrence in each String. I've set this up to be configurable in the Main. It uses the bigram map for each string to get the cosine similarity.

### Usage
This can be used as either via command line using Main.groovy (under org.elst) or as basic server on localhost:8000 by running StartServer.groovy
- You first need to have groovy installed [Groovy Download Page](http://groovy-lang.org/install.html#_download)
- Clone source using git clone 
##### Command Line Using Groovy
1. Navigate to src\org\elst
2. Compile TextSimilarity.groovy with the following command: groovyc ml/TextSimilarity.groovy
3. Execute the main by running the following command: groovy Main.groovy "this is the first string" "this is the second string"
    
The expected response should be "Score for the 2 inputs provided using 2 word grams is:" <score for the 2 strings>
##### Bonus Post Request starting server from command line
1. Navigate to src\org\elst
2. Compile TextSimilarityHandler with the following command: groovyc server/TextSimilarityHandler.groovy
3. Start server by running the following command: groovy StartServer.groovy
4. Submit post request to localhost:8000/similarity with json body of:
    1. {"text1": "some string", "text2": "some other string"}
    2. For now the body assumes they come in as "text1" and "text2"
5. To shutdown server CTRL+C
The expected response should be a 200 Ok and body of "score:" <score for the 2 strings>