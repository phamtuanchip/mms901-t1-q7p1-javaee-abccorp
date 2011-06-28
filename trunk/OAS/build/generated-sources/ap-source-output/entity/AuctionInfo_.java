package entity;

import entity.BidDetails;
import entity.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-28T19:35:56")
@StaticMetamodel(AuctionInfo.class)
public class AuctionInfo_ { 

    public static volatile SingularAttribute<AuctionInfo, Double> highestBid;
    public static volatile SingularAttribute<AuctionInfo, Double> reservedPrice;
    public static volatile CollectionAttribute<AuctionInfo, BidDetails> bidDetailsCollection;
    public static volatile SingularAttribute<AuctionInfo, Integer> auctionStatus;
    public static volatile SingularAttribute<AuctionInfo, Double> lowestBidPrice;
    public static volatile SingularAttribute<AuctionInfo, Integer> auctionId;
    public static volatile SingularAttribute<AuctionInfo, Integer> quantity;
    public static volatile SingularAttribute<AuctionInfo, Date> auctionDate;
    public static volatile SingularAttribute<AuctionInfo, Product> productId;

}