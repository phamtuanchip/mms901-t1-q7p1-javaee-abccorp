/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.AuctionInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hoang Manh Hung
 */
@Local
public interface AuctionInfoFacadeLocal {

    void create(AuctionInfo auctionInfo);

    void edit(AuctionInfo auctionInfo);

    void remove(AuctionInfo auctionInfo);

    AuctionInfo find(Object id);

    List<AuctionInfo> findAll();

    List<AuctionInfo> findRange(int[] range);

    int count();
    
}
