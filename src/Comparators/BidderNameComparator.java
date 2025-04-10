package Comparators;

import Models.Bid;

import java.util.Comparator;

public class BidderNameComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid o1, Bid o2) {
        return o1.getBidderName().compareTo(o2.getBidderName());
    }
}
