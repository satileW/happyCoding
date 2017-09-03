class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topo sort with kahn alogorithm
        int[] inDegrees = new int[numCourses];
        int[][] preMatrix = new int[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int follow = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(preMatrix[pre][follow] == 0){//remove duplicate
                inDegrees[follow]++;
                preMatrix[pre][follow] = 1;
            }
        }
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }
        
        while(queue.size() != 0){
            int prerequisite = queue.pop();
            for(int i = 0; i < numCourses; i++){
                if(preMatrix[prerequisite][i] != 0){
                    if(--inDegrees[i] == 0){
                        queue.offer(i);
                    }
                }
            }
            count ++;
            
        }
        return count == numCourses;
        
    }
}