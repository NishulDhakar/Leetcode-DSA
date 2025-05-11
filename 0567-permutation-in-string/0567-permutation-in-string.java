class Solution {
    public boolean checkInclusion(String s1, String s2) {

        
        int len1 = s1.length();
        int len2 = s2.length();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char ch : s1.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch, 0)+1);
        }

        for(int i = 0; i < len2; i++){
            char crrCh = s2.charAt(i);
            map2.put(crrCh ,map2.getOrDefault(crrCh, 0) + 1);

            if(i >= len1){
                char chLeft = s2.charAt(i - len1);
                if(map2.get(chLeft) == 1){
                    map2.remove(chLeft);
                }else{
                    map2.put(chLeft , map2.get(chLeft) -1);
                }
            }

            if(map1.equals(map2)) return true;
        }
        return false;
    }
}