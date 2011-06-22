/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.BidDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hoang Manh Hung
 */
@Local
public interface BidDetailsFacadeLocal {

    void create(BidDetails bidDetails);

    void edit(BidDetails bidDetails);

    void remove(BidDetails bidDetails);

    BidDetails find(Object id);

    List<BidDetails> findAll();

    List<BidDetails> findRange(int[] range);

    int count();
    
}
