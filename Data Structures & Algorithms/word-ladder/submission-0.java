class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty() || wordList.size() == 0){
            return 0;
        }

        Set<String> wordSet = new HashSet(wordList);
        Set<String> visited = new HashSet();

        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        int distance = 0;

        while(!queue.isEmpty()){
             int size = queue.size();
             distance++;
             for(int i =0; i <size; i++){

                String currentWord = queue.poll();
                if(currentWord.equals(endWord)){
                    return distance;
                }
                Set<String> neighbours = getNeighbours(currentWord, wordSet);
                for(String neighbour: neighbours){
                    if(visited.add(neighbour)){
                         queue.add(neighbour);
                   }

                }
             }


        }  
        return 0; 
    }

        public Set<String> getNeighbours(String word, Set<String> wordSet){
            Set<String> neighbours = new HashSet(); 

            char[] letters = word.toCharArray();
            int index = 0;

            for(int i=0; i < letters.length; i++){
                char currentChar = letters[i];
                for(char j='a'; j<='z'; j++){
                    if(currentChar == j) continue; 
                    letters[i] = j;
                    String newWord = String.valueOf(letters);
                    if(wordSet.contains(newWord)){
                        neighbours.add(newWord);
                    }
                    letters[i] = currentChar;
                }
            }
            return neighbours;
        }
}
