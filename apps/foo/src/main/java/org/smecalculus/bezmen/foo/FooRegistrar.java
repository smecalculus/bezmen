package org.smecalculus.bezmen.foo;

import com.smecalculus.bezmen.configuration.MessagingProtocol;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Set;

record FooRegistrar(
        Set<MessagingProtocol> protocols
) implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (MessagingProtocol protocol : protocols) {
            switch (protocol) {
                case HTTP -> {
                    // empty
                }
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // empty
    }
}
