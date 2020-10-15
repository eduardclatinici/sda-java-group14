package com.sda.spring.core.config.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.sda.spring.core.config.scan"})
//the @ComponentScan annotation searches for all the @Component annotated beans inside the specified package
//  and in all of the child packages of the specified package and will instantiate those beans
//  we need to define specific constructors for the beans inside which we want to use dependency
//      injection (inject other beans in said bean)
// In this case we need to create a constructor in MyComponentWithOtherComponentInjected that expects a
//      MyComponent parameter so that we provide a way for spring to inject the dependency
public class ScanConfig {
}
