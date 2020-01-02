package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJmsBroker;

/**
 * Created by jt on 6/7/17.
 */
@Configuration
public class PropertyConfig {
	
    @Value("${guru.username}")
    String user;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dburl}")
    String url;
    
    @Value("${guru.jms.username}")
    private String jmsUsername;
    
    @Value("${guru.jms.password}")
    private String jmsPassword;
    
    @Value("${guru.jms.url}")
    private String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }
    
    @Bean
    public FakeJmsBroker fakeJmsBroker() {
    	FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
    	fakeJmsBroker.setPassword(jmsPassword);
    	fakeJmsBroker.setUrl(jmsUrl);
    	fakeJmsBroker.setUsername(jmsUsername);
    	
    	return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
}
