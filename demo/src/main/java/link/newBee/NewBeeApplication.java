package link.newBee;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NewBeeApplication {

	public static void main(String[] args) {
		SpringApplication bootstrap = new SpringApplication(NewBeeApplication.class);
		bootstrap.setBanner((environment, aClass, printStream) -> System.out.println("#                                                                                 \n" +
                "#           ,--.                                                                  \n" +
                "#         ,--.'|    ,---,.           .---.            ,---,.     ,---,.    ,---,. \n" +
                "#     ,--,:  : |  ,'  .' |          /. ./|          ,'  .'  \\  ,'  .' |  ,'  .' | \n" +
                "#  ,`--.'`|  ' :,---.'   |      .--'.  ' ;        ,---.' .' |,---.'   |,---.'   | \n" +
                "#  |   :  :  | ||   |   .'     /__./ \\ : |        |   |  |: ||   |   .'|   |   .' \n" +
                "#  :   |   \\ | ::   :  |-, .--'.  '   \\' .        :   :  :  /:   :  |-,:   :  |-, \n" +
                "#  |   : '  '; |:   |  ;/|/___/ \\ |    ' '        :   |    ; :   |  ;/|:   |  ;/| \n" +
                "#  '   ' ;.    ;|   :   .';   \\  \\;      :        |   :     \\|   :   .'|   :   .' \n" +
                "#  |   | | \\   ||   |  |-, \\   ;  `      |        |   |   . ||   |  |-,|   |  |-, \n" +
                "#  '   : |  ; .''   :  ;/|  .   \\    .\\  ;        '   :  '; |'   :  ;/|'   :  ;/| \n" +
                "#  |   | '`--'  |   |    \\   \\   \\   ' \\ |        |   |  | ; |   |    \\|   |    \\ \n" +
                "#  '   : |      |   :   .'    :   '  |--\"         |   :   /  |   :   .'|   :   .' \n" +
                "#  ;   |.'      |   | ,'       \\   \\ ;            |   | ,'   |   | ,'  |   | ,'   \n" +
                "#  '---'        `----'          '---\"             `----'     `----'    `----'     \n" +
                "#                                                                                 "));
		bootstrap.setBannerMode(Banner.Mode.CONSOLE);
		bootstrap.run(args);
	}
}
