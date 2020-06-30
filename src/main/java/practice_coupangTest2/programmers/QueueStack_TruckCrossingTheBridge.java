package practice_coupangTest2.programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStack_TruckCrossingTheBridge {

    public static void main(String[] args){
        new QueueStack_TruckCrossingTheBridge().solve(2, 10, new int[]{7,4,5,6});
        new QueueStack_TruckCrossingTheBridge().solve(100, 100, new int[]{10});
        new QueueStack_TruckCrossingTheBridge().solve(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
    }

    private void solve(int bridgeLength, int weight, int[] truckWeights){

        Queue<Truck> queue = new LinkedList<>();
        queue.offer(new Truck(truckWeights[0], bridgeLength));
        int idx = 1, timer = 1, totalWeight = truckWeights[0];
        while(!queue.isEmpty()){
            Iterator<Truck> it = queue.iterator();
            while(it.hasNext()){
                it.next().timer -= 1;
            }
            if(queue.peek().timer == 0) {
                Truck bye = queue.poll();
                totalWeight -= bye.weight;
            }
            if(idx < truckWeights.length && truckWeights[idx]+totalWeight <= weight){
                queue.offer(new Truck(truckWeights[idx], bridgeLength));
                totalWeight += truckWeights[idx];
                idx++;
            }
            timer++;
        }

        System.out.println(timer);
    }

    class Truck{
        int weight;
        int timer;
        Truck(int weight, int timer){
            this.weight = weight;
            this.timer = timer;
        }
    }
}
