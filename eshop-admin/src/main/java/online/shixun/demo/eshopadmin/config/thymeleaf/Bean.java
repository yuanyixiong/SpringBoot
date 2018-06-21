package online.shixun.demo.eshopadmin.config.thymeleaf;

import java.util.UUID;

public class Bean {

    public String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
