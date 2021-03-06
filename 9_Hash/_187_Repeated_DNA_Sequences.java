class Solution {
    
        // what is rolling hash: https://www.youtube.com/watch?v=BfUejqd07yo 
      
        public List<String> findRepeatedDnaSequences(String s) {

                int L = 10;
                int n = s.length();
 
                if (n <= L) return new ArrayList();

                /** rolling hash 的参数 */
                int a = 4;
                int aL = (int)Math.pow(a, L);

                /** 把输入转成 int */
                Map<Character, Integer> toInt = new HashMap();

                toInt.put('A', 0); toInt.put('C', 1); toInt.put('G', 2); toInt.put('T', 3);

                int[] nums = new int[n];

                for(int i = 0; i < n; ++i) nums[i] = toInt.get(s.charAt(i));

                /**  */
                int h = 0;  // --> hash 的存放值
                Set<Integer> seen = new HashSet();   // --> 检测工具
                Set<String> output = new HashSet();  // --> 结果容器

                /** 遍历input */
                for (int start = 0; start < n - L + 1; ++start) {

                    /**  计算 hash of the first sequence in O(L) time */
                    if (start == 0) {
                         for(int i = 0; i < L; ++i) h = h * a + nums[i];
                    }
                    
                    /**  计算 hash of the current sequence in O(1) time */
                    if (start != 0) {
                         h = h * a - nums[start - 1] * aL + nums[start + L - 1];
                    }
 
                    /** update output and hashset of seen sequences */
                    if (seen.contains(h)) {
                        output.add(s.substring(start, start + L));
                    }

                    seen.add(h);
                }

                return new ArrayList<String>(output);
        }
}

