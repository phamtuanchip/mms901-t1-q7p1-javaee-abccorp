package entity;

import entity.AuctionInfo;
import entity.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-28T19:35:56")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> category;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile CollectionAttribute<Product, AuctionInfo> auctionInfoCollection;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Category> categoryId;
    public static volatile SingularAttribute<Product, Integer> quantity;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Integer> productId;

}