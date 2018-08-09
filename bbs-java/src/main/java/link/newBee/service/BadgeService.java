package link.newBee.service;

import link.newBee.Entity.Badge;

import java.util.List;


/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *  规则：**ById save** del** 不能用Result<T>包装，保障代码复用
 * @author sis.nonacosa
 */

public interface BadgeService {


      List<Badge> getBadge(Badge badge);



}
