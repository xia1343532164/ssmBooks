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
	
	@Override // 配置地址分区，如/admin/** | /assets/** | /**
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		 //如果用户不是通过匿名也不是通过remember-me登录的用户时， 就会返回true。
		.antMatchers("/admin/**").access("isFullyAuthenticated() and hasRole('ADMIN')")
		.antMatchers("/assets/**","/login").permitAll()
		.antMatchers("/**").authenticated()
		
		.and()
		.formLogin()// 使用表单登录
	    .loginPage("/login")// 指定登录页面所在的地址
	    
	    .and()
		.rememberMe() //记住配置
		.tokenValiditySeconds(3*24*3600) //cookie有效期三天
		.userDetailsService(userDeatilsService);//从userDetailsService()中参照用户
	}
}
