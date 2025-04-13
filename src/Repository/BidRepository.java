package Repository;

import Models.Bid;
import Models.Car;

import java.util.List;
import java.util.Objects;

public interface BidRepository {

    void makeBid(Bid bid);

    void removeBid(Bid bid);

    List<Bid> getAllBids();
}
