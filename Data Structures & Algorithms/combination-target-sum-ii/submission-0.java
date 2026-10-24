class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> currentMap = new HashMap<Integer, Integer>();
        for (int x : candidates){
            if (map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }
            else
                map.put(x, 1);
        }
        helper(0, candidates, result, current, 0, target, map, currentMap);
        return result;
    }

    private void helper(int i, int[] nums, List<List<Integer>> result, List<Integer> current, int currentSum, int target, HashMap<Integer, Integer> template, HashMap<Integer, Integer> currentMap){
        if (currentSum > target)
            return;
        if (currentSum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(j > 0 && nums[j] == nums[j-1])
                continue;
            
            if (addElement(nums[j], current, template, currentMap)){
                helper(j, nums, result, current, currentSum + nums[j], target, template,        currentMap);
                removeElement(nums[j], current, template, currentMap);
            }
        }
    }

    private boolean addElement(int element, List<Integer> current, HashMap<Integer, Integer> template, HashMap<Integer, Integer> currentMap)
    {
        if(currentMap.containsKey(element)){
            int occurance = currentMap.get(element);
            int max = template.get(element);
            if(occurance < max){
                current.add(element);
                currentMap.put(element, currentMap.get(element) + 1);
            }
            else    
                return false;
        }
        else{
            current.add(element);
            currentMap.put(element, 1);
        }
        return true;
    }

    private void removeElement(int element, List<Integer> current, HashMap<Integer, Integer> template, HashMap<Integer, Integer> currentMap)
    {
        currentMap.put(element, currentMap.get(element) - 1);
        current.remove(current.size() - 1);
    }
}
