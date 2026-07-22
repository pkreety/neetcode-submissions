class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> queue = new PriorityQueue<Point>((a,b)-> b.distance -a.distance);
        int[][] result = new int[k][2];

        for(int[] coordi: points) {
            int distance = calculateDistance(coordi);
            Point newPoint = new Point(distance, coordi);
            queue.offer(newPoint);
            if(queue.size() > k){
                queue.poll();
            }

        }
        
        int index = 0;
        while(!queue.isEmpty()){
            result[index++] = queue.poll().coordinates;
        }

        return result;
    }

    public int calculateDistance(int[] point){
        int x1 = point[0];
        int y1 = point[1];
       

        return (int) Math.pow((Math.pow(x1,2) + Math.pow(y1,2)), 2);
    }
}


class Point {
    int distance; 
    int[] coordinates;

    Point(int distance, int[] coordinates){
        this.distance = distance; 
        this.coordinates = coordinates;
    }

}