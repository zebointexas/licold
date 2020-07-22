class Solution {
    
    public boolean canAttendMeetings(int[][] intervals) {
 
        if( intervals.length < 2 ) return true;
         
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; ++i) {

            int curStart = intervals[i][0];
            int preEnd = intervals[i - 1][1]; 
            
            if ( preEnd > curStart ) return false;

        }
        return true;
    }
}

