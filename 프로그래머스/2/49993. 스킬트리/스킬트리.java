class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            String str = skill_trees[i];
            if(can(str,skill)) {
                answer++;            
            }
        }
        return answer;
    }
    private boolean can(String str, String skill){
        String s = "";
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<skill.length(); j++){
                if(str.charAt(i)==skill.charAt(j)) s+=str.charAt(i);
            }
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=skill.charAt(i)) return false;
        }
        return true;
 
    }
    
}