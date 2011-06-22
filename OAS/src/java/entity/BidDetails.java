/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hoang Manh Hung
 */
@Entity
@Table(name = "BidDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BidDetails.findAll", query = "SELECT b FROM BidDetails b"),
    @NamedQuery(name = "BidDetails.findByAuctionId", query = "SELECT b FROM BidDetails b WHERE b.bidDetailsPK.auctionId = :auctionId"),
    @NamedQuery(name = "BidDetails.findByCustomerId", query = "SELECT b FROM BidDetails b WHERE b.bidDetailsPK.customerId = :customerId"),
    @NamedQuery(name = "BidDetails.findByBidStatus", query = "SELECT b FROM BidDetails b WHERE b.bidStatus = :bidStatus"),
    @NamedQuery(name = "BidDetails.findByPaymentStatus", query = "SELECT b FROM BidDetails b WHERE b.paymentStatus = :paymentStatus")})
public class BidDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BidDetailsPK bidDetailsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BidStatus")
    private int bidStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentStatus")
    private int paymentStatus;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "AuctionId", referencedColumnName = "AuctionId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AuctionInfo auctionInfo;

    public BidDetails() {
    }

    public BidDetails(BidDetailsPK bidDetailsPK) {
        this.bidDetailsPK = bidDetailsPK;
    }

    public BidDetails(BidDetailsPK bidDetailsPK, int bidStatus, int paymentStatus) {
        this.bidDetailsPK = bidDetailsPK;
        this.bidStatus = bidStatus;
        this.paymentStatus = paymentStatus;
    }

    public BidDetails(int auctionId, int customerId) {
        this.bidDetailsPK = new BidDetailsPK(auctionId, customerId);
    }

    public BidDetailsPK getBidDetailsPK() {
        return bidDetailsPK;
    }

    public void setBidDetailsPK(BidDetailsPK bidDetailsPK) {
        this.bidDetailsPK = bidDetailsPK;
    }

    public int getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(int bidStatus) {
        this.bidStatus = bidStatus;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AuctionInfo getAuctionInfo() {
        return auctionInfo;
    }

    public void setAuctionInfo(AuctionInfo auctionInfo) {
        this.auctionInfo = auctionInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidDetailsPK != null ? bidDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BidDetails)) {
            return false;
        }
        BidDetails other = (BidDetails) object;
        if ((this.bidDetailsPK == null && other.bidDetailsPK != null) || (this.bidDetailsPK != null && !this.bidDetailsPK.equals(other.bidDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BidDetails[ bidDetailsPK=" + bidDetailsPK + " ]";
    }
    
}
