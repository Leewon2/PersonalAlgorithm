import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Task> pq = new PriorityQueue<>((o1,o2)->{
            return o1.s-o2.s;
        });
        for(String[] str : plans){
            String[] t = str[1].split(":");
            int time = Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
            pq.offer(new Task(str[0],time,Integer.parseInt(str[2])));
        }
        Stack<Task> stack = new Stack<>();
        int idx=0;
        while(!pq.isEmpty()){
            Task task = pq.poll();
            if(pq.isEmpty()){
                answer[idx++] = task.name;
                break;
            }
            Task compareTask = pq.peek();
            if(task.s+task.time <= compareTask.s){
                answer[idx++] = task.name;
                int spare = compareTask.s - (task.s+task.time);
                while(!stack.isEmpty() && spare>0){
                    Task checkStack = stack.pop();
                    if(checkStack.time<=spare){
                        answer[idx++] = checkStack.name;
                        spare-=checkStack.time;
                    }else{
                        stack.add(new Task(checkStack.name,checkStack.s,checkStack.time-spare));
                        spare=0;
                    }
                }
            }else{
                stack.add(new Task(task.name,task.s,task.s+task.time-compareTask.s));
            }
            
        }
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        
        return answer;
    }
    private class Task{
        String name;
        int s;
        int time;
        public Task(String name, int s, int time){
            this.name=name;
            this.s=s;
            this.time=time;
        }
    }
}