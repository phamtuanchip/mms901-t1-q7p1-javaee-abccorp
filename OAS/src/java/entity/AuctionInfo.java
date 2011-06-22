/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hoang Manh Hung
 */
@Entity
@Table(name = "AuctionInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuctionInfo.findAll", query = "SELECT a FROM AuctionInfo a"),
    @NamedQuery(name = "AuctionInfo.findByAuctionId", query = "SELECT a FROM AuctionInfo a WHERE a.auctionId = :auctionId"),
    @NamedQuery(name = "AuctionInfo.findByAuctionDate", query = "SELECT a FROM AuctionInfo a WHERE a.auctionDate = :auctionDate"),
    @NamedQuery(name = "AuctionInfo.findByReservedPrice", query = "SELECT a FROM AuctionInfo a WHERE a.reservedPrice = :reservedPrice"),
    @NamedQuery(name = "AuctionInfo.findByLowestBidPrice", query = "SELECT a FROM AuctionInfo a WHERE a.lowestBidPrice = :lowestBidPrice"),
    @NamedQuery(name = "AuctionInfo.findByQuantity", query = "SELECT a FROM AuctionInfo a WHERE a.quantity = :quantity"),
    @NamedQuery(name = "AuctionInfo.findByAuctionStatus", query = "SELECT a FROM AuctionInfo a WHERE a.auctionStatus = :auctionStatus")})
public class AuctionInfo implements Serializable {
    @Basic(optional =     false)
    @NotNull
    @Column(name = "AuctionDate")
    @Temporal(TemporalType.DATE)
    private Date auctionDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HighestBid")
    private Double highestBid;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AuctionId")
    private Integer auctionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReservedPrice")
    private double reservedPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LowestBidPrice")
    private double lowestBidPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AuctionStatus")
    private int auctionStatus;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
    @ManyToOne(optional = false)
    private Product productId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auctionInfo")
    private Collection<BidDetails> bidDetailsCollection;

    public AuctionInfo() {
    }

    public AuctionInfo(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public AuctionInfo(Integer auctionId, Date auctionDate, double reservedPrice, double lowestBidPrice, int quantity, int auctionStatus) {
        this.auctionId = auctionId;
        this.auctionDate = auctionDate;
        this.reservedPrice = reservedPrice;
        this.lowestBidPrice = lowestBidPrice;
        this.quantity = quantity;
        this.auctionStatus = auctionStatus;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public double getReservedPrice() {
        return reservedPrice;
    }

    public void setReservedPrice(double reservedPrice) {
        this.reservedPrice = reservedPrice;
    }

    public double getLowestBidPrice() {
        return lowestBidPrice;
    }

    public void setLowestBidPrice(double lowestBidPrice) {
        this.lowestBidPrice = lowestBidPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(int auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @XmlTransient
    public Collection<BidDetails> getBidDetailsCollection() {
        return bidDetailsCollection;
    }

    public void setBidDetailsCollection(Collection<BidDetails> bidDetailsCollection) {
        this.bidDetailsCollection = bidDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionId != null ? auctionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuctionInfo)) {
            return false;
        }
        AuctionInfo other = (AuctionInfo) object;
        if ((this.auctionId == null && other.auctionId != null) || (this.auctionId != null && !this.auctionId.equals(other.auctionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AuctionInfo[ auctionId=" + auctionId + " ]";
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
    }

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }
    
}
