/**
 * @Author: Liang
 * @Date: 2019/5/19 23:02
 * @Version 1.0
 */
package com.liang.admin_4.web;

import com.liang.admin_4.domin.SysLog;
import com.liang.admin_4.service.SysLogService;
import com.liang.admin_4.utils.CommonsUtils;
import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Liang
 * @date 2019/5/19 23:02
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;  //开始时间
    private Class clazz;     //访问的类
    private Method method;  //访问的方法

    //前
    @Before("execution(* com.liang.admin_4.web.*.*(..))")
    public  void doBefore(JoinPoint jp) throws  Exception{
        System.out.println("前");
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass(); //具体要访问的类
        String methodName = jp.getSignature().getName(); //获取访问的方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }

    }

    //后
    @After("execution(* com.liang.admin_4.web.*.*(..))")
    public  void doAfter(JoinPoint joinPoint)throws  Exception{
         long time = new Date().getTime() - visitTime.getTime();

         //URL
        String url = "";
        System.out.println("2");
        System.out.println(method);
        System.out.println(clazz==null);
        System.out.println(method==null);
        System.out.println(clazz==LogAop.class);
        if (clazz != null && method != null && clazz != LogAop.class){
            //1.类
            System.out.println("3");
            RequestMapping clazzAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            //2.方法
            if (clazzAnnotation!=null){
                System.out.println("4");
                String[] value = clazzAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    System.out.println("5");
                    String[] methodvalue = methodAnnotation.value();
                    url = value[0]+methodvalue[0];

                    //ip
                    String ip = request.getRemoteAddr();

                    //user
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User)context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //id
                    String id = CommonsUtils.getUUID();

                    //封装
                    SysLog sysLog = new SysLog();
                    sysLog.setId(id);
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    System.out.println("1");
                    //保存
                    sysLogService.save(sysLog);
                }
            }

        }



    }

}
