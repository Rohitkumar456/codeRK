/**
 * 
 * YOu are given a list of intervals (sorted based on the start point), you are given a new interval and merge that interval.
 * 
 * 
 */



import java.util.*;


class Interval{
    int start;
    int end;

    public Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {

        MergeIntervals mi = new MergeIntervals();

        ArrayList<Interval>intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        intervals.add(new Interval(7, 11));
        intervals = mi.addAndMergeInterval(intervals,new Interval(2, 5));
        mi.showIntervals(intervals);
    }

    public ArrayList<Interval> addAndMergeInterval(ArrayList<Interval>intervals, Interval interval){

        //adding the interval based on its start position
        boolean isInserted = false;
        for(int i=0;i<intervals.size();i++){
            if(interval.start<=intervals.get(i).start){
                intervals.add(i, interval);
                isInserted = true;
                break;
            }
        }
        if(!isInserted){
            intervals.add(interval);
        }

        //merging the final list after inserting the interval at its correct position.
        int i=1;
        while(i<intervals.size()){
            
            Interval cur = intervals.get(i);
            Interval prev = intervals.get(i-1);

            if(cur.start<=prev.end){
                prev.end = cur.end;
                intervals.remove(i);
            }else{
                i++;
            }
        }

        return intervals;
    }

    public void showIntervals(ArrayList<Interval>intervals){
        for(Interval i : intervals){
            System.out.println(i.start +" "+i.end);
        }
    }
    
}


