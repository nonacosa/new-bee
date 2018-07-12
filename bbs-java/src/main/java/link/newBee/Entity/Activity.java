package link.newBee.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * data 2018-07-13   00:29
 * E-mail   sis.nonacosa@gmail.com
 * 活动表
 * @author sis.nonacosa
 */

@Entity
@Getter
@Setter
public class Activity {

        @ManyToOne
        private Blog blog;

        @ManyToOne
        private User user;



        @Id
        @GeneratedValue
        private Long id;

        /**
         * 正文
         */
        @Lob
        @Column(name = "val", nullable = false, columnDefinition = "TEXT")
        private String val;

        /**
         * 活动类型
         */
        @Lob
        @Column(name = "type",  nullable = true, length = 20)
        private String type;


        /**
         * 创建时间
         */
        @Column(name = "createTime", nullable = true, length = 50 )
        private Integer createTime ;


}
