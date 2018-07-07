package link.newBee.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * data 2018-06-28   00:29
 * E-mail   sis.nonacosa@gmail.com
 * 博客表
 * @author sis.nonacosa
 */

@Entity
@Getter
@Setter
public class Blog {

        @ManyToOne
        private User user;

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
         * 分享地址
         */
        @Column(name = "shareUrl", nullable = true, length = 255 )
        private String shareUrl ;

        /**
         * 标题
         */
        @Column(name = "title", nullable = true, length = 50 )
        private String title ;

        /**
         * 标签
         */
        @Column(name = "tag", nullable = true, length = 50 )
        private String tag ;

        /**
         * 分类
         */
        @Column(name = "classify", nullable = true, length = 20 )
        private String classify ;

        /**
         * 博客首页图片地址
         */
        @Column(name = "blogImgUrl", nullable = true, length = 255 )
        private String blogImgUrl ;

        /**
         * 点赞数
         */
        @Column(name = "commendCount", nullable = true, length = 10 )
        private Integer commendCount = 0;


        /**
         * 评论数
         */
        @Column(name = "commentCount", nullable = true, length = 10 )
        private Integer commentCount = 0;

        /**
         * 阅读数
         */
        @Column(name = "readCount", nullable = true, length = 10 )
        private Integer readCount = 0;

        /**
         * 收藏数
         */
        @Column(name = "starCount", nullable = true, length = 10 )
        private Integer starCount = 0;

        /**
         * 发布时间
         */
        @Column(name = "createTime", nullable = false )
        private Date createTime ;

        /**
         * @Transient 不生成mysql字段 用来排序的
         */
        @Transient
        private String sort;

        @JsonBackReference
        public void setUser(User user) {
                this.user = user;
        }
}
