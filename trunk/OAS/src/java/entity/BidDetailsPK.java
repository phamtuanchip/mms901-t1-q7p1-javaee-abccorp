/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Hoang Manh Hung
 */
@Embeddable
public class BidDetailsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "AuctionId")
    private int auctionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private int customerId;

    public BidDetailsPK() {
    }

    public BidDetailsPK(int auctionId, int customerId) {
        this.auctionId = auctionId;
        this.customerId = customerId;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) auctionId;
        hash += (int) customerId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BidDetailsPK)) {
            return false;
        }
        BidDetailsPK other = (BidDetailsPK) object;
        if (this.auctionId != other.auctionId) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BidDetailsPK[ auctionId=" + auctionId + ", customerId=" + customerId + " ]";
    }
    
}
