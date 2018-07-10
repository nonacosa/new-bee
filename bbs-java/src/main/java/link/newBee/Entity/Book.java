package link.newBee.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Book {


        @Id
        private String id;

        @Column(name = "bookName", nullable = true, length = 20)
        private String bookName;

        @Column(name = "downLoadUrl", nullable = true, length = 100 )
        private String downLoadUrl ;

        @Column(name = "bookImageUrl", nullable = true, length = 100 )
        private String bookImageUrl ;

        @Column(name = "bookIntroduction",  nullable = false, columnDefinition = "TEXT")
        private String bookIntroduction;

        @Column(name = "tag", nullable = true, length = 20)
        private String tag;

        @Column(name = "isFree", nullable = true, length = 5 )
        private String isFree ;

        @Column(name = "score", nullable = true, length = 10 )
        private Integer score = 0 ;


}
