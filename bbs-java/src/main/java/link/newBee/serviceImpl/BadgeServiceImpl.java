package link.newBee.serviceImpl;


import link.newBee.Entity.Badge;
import link.newBee.dao.BadgeDao;
import link.newBee.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * data 2018-06-28   22:18
 * E-mail   sis.nonacosa@gmail.com
 * Badge 服务
 * @author sis.nonacosa
 */

@Service
public class BadgeServiceImpl implements BadgeService {


    @Autowired
    private BadgeDao badgeDao;

    @Override
    public List<Badge> getBadge(Badge badge) {
        badgeDao.findBadgeTitleByBadgeTag(badge.getBadgeTag());
        return null;
    }

    public static void main(String[] args) {

    }
}
