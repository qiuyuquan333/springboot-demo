import config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.Animal;

public class main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        //添加一个properties到Environment中
//        ac.getEnvironment().getSystemProperties().put("people","女孩子");
        ac.getEnvironment().setActiveProfiles("男孩子");
        //注册配置类
        ac.register(JavaConfig.class);
        ac.refresh();
        Animal animal = (Animal) ac.getBean("Animal");
        System.out.println(animal.name());
    }
}
