package Scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //说明是一个配置类
//@ComponentScan(value = "Scan") //设置扫描的包
public class ConF {
    @Bean("duck66")
    public duck duck66(){
        return new duck();
    }
}
