package link.newBee.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * data 2018-06-28   00:29
 * E-mail   sis.nonacosa@gmail.com
 * 徽章表
 * @author sis.nonacosa
 */

@Entity
@Getter
@Setter
public class Badge {

        @ManyToOne
        private Blog blog;

        @ManyToOne
        private User user;



        @Id
        @GeneratedValue
        private Long id;

        /**
         * 徽章图片链接
         */
        @Lob
        @Column(name = "badgeUrl", nullable = false, length = 100)
        private String badgeUrl;


        /**
         * 徽章标题
         */
        @Column(name = "badgeTitle", nullable = true, length = 20 )
        private String badgeTitle ;


        /**
         * 徽章类型
         */
        @Column(name = "badgeTag", nullable = true, length = 20 )
        private String badgeTag ;



}
