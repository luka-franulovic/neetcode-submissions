class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Double, List<List<Integer>>> map = new HashMap<Double, List<List<Integer>>>();
        PriorityQueue<Double> minPQ = new PriorityQueue<Double>();
        for (int[] p : points){
            List<Integer> pts = Arrays.stream(p)
                                .boxed()
                                .collect(Collectors.toList());
            double distance = getDistance(p);
            minPQ.offer(distance);
            if (!map.containsKey(distance)){
                List<List<Integer>> tmp = new ArrayList<List<Integer>>();
                tmp.add(pts);
                map.put(distance, tmp);
            }
            else{
                List<List<Integer>> tmp = map.get(distance);
                tmp.add(pts);
                map.put(distance, tmp);
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++){
            double distance = minPQ.poll();
            List<List<Integer>> tmp = map.get(distance);
            List<Integer> temp = tmp.get(0);
            result[i] = temp.stream().mapToInt(Integer::intValue).toArray();
            if (tmp.size() > 1){
                tmp.remove(0);
                map.put(distance, tmp);
            }
        }
        return result;
    }
    private double getDistance(int[] points){
        int x = points[0];
        int y = points[1];
        return Math.sqrt((double)(x*x) + (double)(y*y));
    }
}
