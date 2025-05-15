class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        List<String> list = new ArrayList<>();

        list.add(words[0]);
        int lastNum = groups[0];

        if (words.length == 0) return list;

        for(int i = 1 ; i < groups.length; i++){
            if(groups[i] != lastNum){
              list.add(words[i]);
              lastNum = groups[i];
            }
        }
        return list; 
    }
}