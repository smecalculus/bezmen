package org.smecalculus.bezmen.weighing;

import com.smecalculus.bezmen.messaging.model.MessagingProtocol;
import org.smecalculus.bezmen.weighing.messaging.WeighingPostgresController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Map;
import java.util.Set;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

record WeighingRegistrar(
        Set<MessagingProtocol> protocols
) implements BeanDefinitionRegistryPostProcessor {

    private static Map<String, Class<?>> postgresControllers() {
        return Map.of("postgresController", WeighingPostgresController.class);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (MessagingProtocol protocol : protocols) {
            switch (protocol) {
                case HTTP -> {
                    // empty
                }
                case POSTGRES -> postgresControllers().forEach((name, clazz) ->
                        registry.registerBeanDefinition(name, genericBeanDefinition(clazz).getBeanDefinition()));
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // empty
    }
}
