package com.qyq.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity  //开启网络安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置两个用户（用户名、角色、密码）
        auth.inMemoryAuthentication()
                .withUser("qyq").roles("admin").password("$2a$10$i86O4wP6fXa.hkc1JRTgnu68Zo/qc7XMFYvr0K1LuzvqJPQMUAWg6")
                .and()
                .withUser("yxy").roles("user").password("$2a$10$zfhrQz6AoP7jxqf1lTCt/uJzIrfCVY7k7XovihZ6JisTScPd8k3Ly");
    }

    //配置不需要拦截的URL
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().mvcMatchers("/vercode");
//    }

    //加解密
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //  permitAll() 允许所有   anyRequest().authenticated() 所有请求需要认证
        http.authorizeRequests()
                .mvcMatchers("/index","/").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout().permitAll();


//        http.addFilterBefore(verifyFilter, UsernamePasswordAuthenticationFilter.class);
//        http.authorizeRequests()//开启登录配置
//                .antMatchers("/hello").hasRole("admin")//表示访问 /hello 接口需要具备 admin 这个角色
//                .anyRequest().authenticated()
//                .and()
//                //登录配置
//                .formLogin()
//                .loginPage("/index")  //登录页面
//                .loginProcessingUrl("/vercode") //登录后台处理接口
//                .usernameParameter("username")  //定义登录时用户名的key
//                .passwordParameter("password")  //定义登录时密码的key
//                .successHandler(new AuthenticationSuccessHandler() {       //登录成功进行的操作
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter writer = httpServletResponse.getWriter();
//                        writer.write("login success");
//                        writer.flush();
//                    }
//                }).failureHandler(new AuthenticationFailureHandler() {      //登录失败进行的操作
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter writer = httpServletResponse.getWriter();
//                        writer.write("login fail");
//                        writer.flush();
//                    }
//                })
//                .permitAll()    //和表单登录相关的接口全部通过
//                .and()
//                .logout()      //退出配置
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new LogoutSuccessHandler() {  //退出成功进行的操作
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter writer = httpServletResponse.getWriter();
//                        writer.write("logout success");
//                        writer.flush();
//                    }
//                })
//                .permitAll()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();
    }


}
