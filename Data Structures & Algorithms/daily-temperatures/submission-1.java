class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoSt = new Stack<Integer>();
        int[] nextGreatest = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--){
            if (monoSt.empty()){
                monoSt.push(i);
                nextGreatest[i] = 0;
            }
            else{
                if(temperatures[i] < temperatures[monoSt.peek()]){
                    nextGreatest[i] = monoSt.peek() - i;
                    monoSt.push(i);
                }
                else{
                    while (temperatures[i] >= temperatures[monoSt.peek()]){
                        monoSt.pop();
                        if (monoSt.empty()){
                            monoSt.push(i);
                            nextGreatest[i] = 0;
                            break;
                        }
                    }
                    
                    if (temperatures[i] <= temperatures[monoSt.peek()]){
                        nextGreatest[i] = monoSt.peek() - i;
                        monoSt.push(i);
                    }
                }
            }
        }
        return nextGreatest;
        
    }
}
