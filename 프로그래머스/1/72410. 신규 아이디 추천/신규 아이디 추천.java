class Solution {
    public String solution(String new_id) {
        // step1
        new_id = new_id.toLowerCase();
        // step2
        new_id = new_id.replaceAll("[^0-9a-z-_.]","");
        // step3
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // step4
        new_id = new_id.replaceAll("^\\.+", "").replaceAll("\\.+$", "");
        // step5
        new_id = new_id.length()==0 ? "a" : new_id;
        // step6
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.+$", ""); 
        }
        // step7
        if(new_id.length()==1){
            new_id+=new_id.charAt(0);
            new_id+=new_id.charAt(0);
        }else if(new_id.length()==2){
            new_id+=new_id.charAt(1);
        }
        return new_id;
    }
    
}