package Repository;

import Models.Bid;

public interface BidRepository {

    void makeBid(Bid bid);

    void removeBid(Bid bid);
}
