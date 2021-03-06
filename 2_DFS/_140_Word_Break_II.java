class Solution {
    
    // 参考视频:  https://youtu.be/pYKGRZwbuzs?t=706   
	
	// 时间复杂度: https://stackoverflow.com/questions/39519667/whats-the-time-complexity-of-this-recursive-algorithm 
    
    public List<String> wordBreak(String s, List<String> wordDictList) {
        
        Set<String> wordDict = new HashSet<>(wordDictList);
        
        Map<String, List<String>> memo = new HashMap<>(); 
        
        return wordBreak(s, wordDict, memo); 
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict, 
                                  Map<String, List<String>> memo) {
        
        if (memo.containsKey(s)) return memo.get(s);
        
        List<String> ans = new ArrayList<>(); 
        
        if (wordDict.contains(s)) ans.add(s); 
        
        // 分割左大段，右小段
        for (int i = s.length()-1; i >= 0; i--) {
            
            String right = s.substring(i); 
            
            // 如果右小段在字典中
            if (wordDict.contains(right)) {
                
                String left = s.substring(0, i);
                
                // 递归求解左大段
                List<String> leftAns = wordBreak(left, wordDict, memo);
                
                // 将右小段衔接在左大段后面
                ans.addAll(append(leftAns, right));
            }
        }
        
        memo.put(s, ans);
        return memo.get(s);
    }
    
    private List<String> append(List<String> list, String str) {
        
        List<String> res = new ArrayList<>(); 
        
        for (int i = 0; i < list.size(); i++) {
            
            res.add(list.get(i).concat(" ").concat(str));
        }
        
        return res;
    }
}