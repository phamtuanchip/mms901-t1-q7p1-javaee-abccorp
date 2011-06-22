package entity;

import entity.AuctionInfo;
import entity.BidDetailsPK;
import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-16T18:11:09")
@StaticMetamodel(BidDetails.class)
public class BidDetails_ { 

    public static volatile SingularAttribute<BidDetails, BidDetailsPK> bidDetailsPK;
    public static volatile SingularAttribute<BidDetails, Integer> bidStatus;
    public static volatile SingularAttribute<BidDetails, AuctionInfo> auctionInfo;
    public static volatile SingularAttribute<BidDetails, Integer> paymentStatus;
    public static volatile SingularAttribute<BidDetails, Customer> customer;

}