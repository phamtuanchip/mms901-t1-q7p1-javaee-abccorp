package entity;

import entity.BidDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-06-16T18:11:09")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile CollectionAttribute<Customer, BidDetails> bidDetailsCollection;
    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> creditCardNumber;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, Integer> creditCardType;

}