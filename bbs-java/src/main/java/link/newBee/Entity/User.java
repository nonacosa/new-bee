package link.newBee.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/**
 * data 2018-06-28   00:29
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

@Entity
@Getter
@Setter
public class User {

        @OneToMany(mappedBy = "user")
        private List<Blog> blog;

        @Id
        private String id;

        @Column(name = "github_node_id", nullable = true, length = 100)
        private String githubNodeId;

        @Column(name = "userName", nullable = true, length = 20)
        private String userName;

        @Column(name = "nickName", nullable = true, length = 20)
        private String nickName;

        @Column(name = "bio", nullable = true, length = 100)
        private String bio;

        @Column(name = "password", nullable = true, length = 50 )
        private String password ;

        @Column(name = "score", nullable = true, length = 10 )
        private Integer score = 0 ;

        @Column(name = "address", nullable = true, length = 10 )
        private Integer address = 0 ;

        @Column(name = "phone", nullable = true, length = 15)
        private String phone;

        @Column(name = "email", nullable = true, length = 50)
        private String email;

        @Column(name = "sex", nullable = true, length = 5 )
        private String sex ;

        @Column(name = "createTime", nullable = false )
        private String createTime ;

        @Column(name = "lastIp", nullable = true, length = 15 )
        private String lastIp ;

        @Column(name = "userTag", nullable = true, length = 50 )
        private String userTag ;

        @Column(name = "signature", nullable = true, length = 100 )
        private String signature ;

        @Column(name = "company", nullable = true, length = 100 )
        private String company ;

        @Column(name = "school", nullable = true, length = 100 )
        private String school ;


        @Column(name = "link", nullable = true, length = 100 )
        private String link ;

        @Column(name = "avatarPath", nullable = true, length = 200 )
        private String avatarPath ;

        @Column(name = "github", nullable = true, length = 100 )
        private String github ;

        @Column(name = "zhihu", nullable = true, length = 100 )
        private String zhihu ;

        @Column(name = "followers")
        private Integer followers = 0;

        @Column(name = "following")
        private Integer following = 0;

        @JsonBackReference
        public void setBlog(List<Blog> blog) {
                this.blog = blog;
        }
}
