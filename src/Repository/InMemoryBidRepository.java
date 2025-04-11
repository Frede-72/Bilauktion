package Repository;

import Models.Bid;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBidRepository implements BidRepository{

    List<Bid> bids = new ArrayList<>();

    @Override
    public void makeBid(Bid bid) {
        bids.add(bid);
    }

    @Override
    public void removeBid(Bid bid) {
        bids.remove(bid);
    }
}
