class Solution {
    public boolean isAnagram(String s, String t) {

        int sl = s.length();
        int tl = t.length(); 

        if(sl != tl){
            return false;
        }      

        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch, 0) +1);
        } 
        for(char ch : t.toCharArray()){
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch , map.get(ch) -1);
                }
            }else{
                return false;
            }
        } 

        return map.isEmpty();
    }
}