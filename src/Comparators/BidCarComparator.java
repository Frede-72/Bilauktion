package Comparators;

import Models.Bid;

import java.util.Comparator;

public class BidCarComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid o1, Bid o2) {
        int result = o1.getCar().getBrand().compareTo(o2.getCar().getBrand());
        if(result==0){
            return o1.getCar().getModel().compareTo(o2.getCar().getModel());
        }
        return result;
    }
}
