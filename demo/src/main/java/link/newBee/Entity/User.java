package link.newBee.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


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

        @Id
        @GeneratedValue
        private Long id;

        @Column(name = "userName", nullable = true, length = 20)
        private String userName;

        @Column(name = "password", nullable = true, length = 50 )
        private String password ;

        @Column(name = "phone", nullable = true, length = 15)
        private String phone;

        @Column(name = "Email", nullable = true, length = 50)
        private String Email;

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

        @Column(name = "github", nullable = true, length = 100 )
        private String github ;

        @Column(name = "zhihu", nullable = true, length = 100 )
        private String zhihu ;





}
