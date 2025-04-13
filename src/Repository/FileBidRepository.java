package Repository;

import Models.Bid;
import Models.Car;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileBidRepository implements BidRepository {

    private String bidFile;
    private Path path;

    public FileBidRepository(String bidFile) {
        this.bidFile = bidFile;
        this.path = Paths.get(bidFile);
    }

    @Override
    public void makeBid(Bid bid) {
        try (FileOutputStream out = new FileOutputStream(bidFile, true)) {
            try (PrintStream writer = new PrintStream(out)) {
                writer.append(bid.getBidderName() + ";" + bid.getAmount() + ";" + bid.getCar().getBrand() + ";" + bid.getCar().getModel() +
                        ";" + bid.getCar().getYear() + ";" + bid.getCar().getPrice() + ";" + bid.getCar().getNumberPlate() + "\n");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBid(Bid bid) {
        List<Bid> bids = getAllBids();
        for (Bid b : bids) {
            if (b.getCar().getNumberPlate().equalsIgnoreCase(bid.getCar().getNumberPlate()) &&
                    b.getBidderName().equalsIgnoreCase(bid.getBidderName())) {
                bids.remove(b);
                try (FileOutputStream out = new FileOutputStream(bidFile)) {
                    try (PrintStream writer = new PrintStream(out)) {
                        writer.print("");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        for (Bid b : bids) {
            makeBid(b);
        }
    }

    @Override
    public List<Bid> getAllBids() {
        List<Bid> bids = new ArrayList<>();
        try (Scanner reader = new Scanner(path)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] splitLine = line.split(";");
                bids.add(new Bid(splitLine[0], Integer.parseInt(splitLine[1]),
                        new Car(splitLine[2], splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), splitLine[6])));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bids;
    }
}
