package socmour.spring.mygrades.Config;

//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Order(1)
//public class MyDemoLoggingAspect {

//    @Pointcut("execution(* socmour.spring.mygrades.DAO.*DAO.add*(..))")
//    private void forDAOPackage(){}
//
//
//    @Pointcut("forDAOPackage()")
//    private void forDAOPackageNoGetterSetter(){}
//
//    @Before("forDAOPackage()")
//    public void beforeAddUserAdvice(JoinPoint joinPoint) {
//
//        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
//        System.out.println(" \n " + methodSig + "\n   =======   >>>>> Executing @Before on add*()");
//
//        Object[] args = joinPoint.getArgs();
//
//        for (Object tempArg: args){
//
//            if (tempArg instanceof String){
//                System.out.println("'String' arg with value: " + ((String) tempArg).toUpperCase());
//            } else {
//                System.out.println("int: " + tempArg);
//            }
//        }
//
//    }
//
//    @Before("forDAOPackageNoGetterSetter()")
//    public void printAnalyticsForAddMethods(){
//        System.out.println("\n   <<<<<------ Performing some API Analytics ------>>>>>\n");
//    }

//}
