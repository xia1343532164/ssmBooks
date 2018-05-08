package Books.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDeatilsService;
	
	@Override // ���õ�ַ��������/admin/** | /assets/** | /**
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		 //����û�����ͨ������Ҳ����ͨ��remember-me��¼���û�ʱ�� �ͻ᷵��true��
		.antMatchers("/admin/**").access("isFullyAuthenticated() and hasRole('ADMIN')")
		.antMatchers("/assets/**","/login").permitAll()
		.antMatchers("/**").authenticated()
		
		.and()
		.formLogin()// ʹ�ñ���¼
	    .loginPage("/login")// ָ����¼ҳ�����ڵĵ�ַ
	    
	    .and()
		.rememberMe() //��ס����
		.tokenValiditySeconds(3*24*3600) //cookie��Ч������
		.userDetailsService(userDeatilsService);//��userDetailsService()�в����û�
	}
}
