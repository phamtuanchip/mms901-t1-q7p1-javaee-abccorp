/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.BidDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hoang Manh Hung
 */
@Stateless
public class BidDetailsFacade extends AbstractFacade<BidDetails> {
    @PersistenceContext(unitName = "OASPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BidDetailsFacade() {
        super(BidDetails.class);
    }
    
}
