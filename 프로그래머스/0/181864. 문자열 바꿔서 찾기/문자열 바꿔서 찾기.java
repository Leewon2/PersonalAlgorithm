class Solution {
    public int solution(String myString, String pat) {
        return myString.contains(pat.replace("A", "X").replace("B", "A").replace("X", "B")) ? 1 : 0;
    }
}

        

