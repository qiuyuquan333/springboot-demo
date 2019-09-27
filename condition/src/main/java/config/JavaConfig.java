package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pojo.Animal;
import pojo.Cat;
import pojo.Dog;

/**
 * 配置类
 */
@Configuration
public class JavaConfig {

    @Bean("Animal")
//    @Conditional(CatCondition.class)//条件类，需要自己编写条件类，灵活
    @Profile("女孩子") //自动实现条件
    Animal Cat(){
        return new Cat();
    }

    @Bean("Animal")
//    @Conditional(DogCondition.class)//条件类
    @Profile("男孩子")
    Animal Dog(){
        return new Dog();
    }
}
