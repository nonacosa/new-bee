package link.newBee.dao;

import link.newBee.Entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * data 2018-08-09   11:15
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */
public interface BadgeDao extends JpaRepository<Badge,Long> {

    Badge findBadgeTitleByBadgeTag(String BadgeTag);

}
