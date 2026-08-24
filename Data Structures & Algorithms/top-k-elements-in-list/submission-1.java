class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Hashtable<Integer, Integer> occurances = new Hashtable<Integer, Integer>();
        int maxOccurance = 1;
        for (int n : nums){
            if (occurances.containsKey(n)){
                int tmp = occurances.get(n);
                occurances.put(n, tmp+1);
                if (tmp+1 > maxOccurance){
                    maxOccurance = tmp + 1;
                }
            }
            else{
                occurances.put(n, 1);
            }
        }
        Hashtable<Integer, ArrayList<Integer>> frequencyList = new Hashtable<Integer, ArrayList<Integer>>();
        for (int key : occurances.keySet()){
            int occurance = occurances.get(key);
            if (frequencyList.containsKey(occurance)){
                ArrayList<Integer> tmp = frequencyList.get(occurance);
                tmp.add(key);
                frequencyList.put(occurance, tmp);
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(key);
                frequencyList.put(occurance, tmp);
            }
        }
        int[] top = new int[k];
        int index = maxOccurance;
        int cP = 0; // current pointer;
        while (k > 0){
            if (frequencyList.containsKey(index)){
                ArrayList<Integer> tmp = frequencyList.get(index);
                int size = tmp.size();
                for (int x : tmp){
                    if (k == 0) break;
                    top[cP] = x;
                    cP++;
                    k--;
                }
            }
            index--;
        }
        return top;
    }
}
