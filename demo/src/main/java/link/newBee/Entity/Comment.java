package link.newBee.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 * data 2018-06-28   00:29
 * E-mail   sis.nonacosa@gmail.com
 * 评论表
 * @author sis.nonacosa
 */

@Entity
@Getter
@Setter
public class Comment {

        @ManyToOne
        private Blog blog;


        @Id
        @GeneratedValue
        private Long id;

        /**
         * 正文
         */
        @Lob
        @Column(name = "content", nullable = false, columnDefinition = "TEXT")
        private String content;

        /**
         * 评论数
         */
        @Column(name = "commentCount", nullable = true, length = 50 )
        private Integer commentCount ;
        /**
         * 点赞数
         */
        @Column(name = "commendCount", nullable = true, length = 50 )
        private Integer commendCount ;

        /**
         * 创建时间
         */
        @Column(name = "createTime", nullable = true, length = 50 )
        private Integer createTime ;
         

}
