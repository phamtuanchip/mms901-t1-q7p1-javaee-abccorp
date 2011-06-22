/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AuctionInfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hoang Manh Hung
 */
@Stateless
public class AuctionInfoFacade extends AbstractFacade<AuctionInfo> {
    @PersistenceContext(unitName = "OASPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AuctionInfoFacade() {
        super(AuctionInfo.class);
    }
    
}
