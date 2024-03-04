package com.aryog.firstapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {


    private final MyFirstClass myFirstClass;
    @Value("Hello Yogesh Students")
    private String customProperty;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("123")
    private Integer customPropertyInt;
    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }



    public MyFirstService(@Qualifier("myFirstBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying: "+myFirstClass.sayHello();
    }
}
