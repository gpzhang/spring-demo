* 基于xml文件配置的两种aop实现方式
    * aop:config中配置aop:pointcut和aop:aspect（切入点和切面）
    * aop:config中配置aop:pointcut和aop:advisor（切入点和通知器）
    
* <aop:advisor>和<aop:aspect>其实都是将advice和pointcut进行了封装， 原理基本上是一样的，只是使用的方式不同而已。
    
```text
 * 程序运行时会调用很多方法，
 * 调用的很多方法就叫做Join points（连接点，可以被选择来进行增强的方法点），
 * 在方法的前或者后选择一个地方来切入，切入的的地方就叫做Pointcut（切入点，选择增强的方法），
 * 然后把要增强的功能（Advice）加入到切入点所在的位置。
 * Advice和Pointcut组成一个切面（Aspect）
 * 切面Aspect=Advice+Pointcut,要增强的功能和要增强的功能的执行切入点共同构成了切面的概念

```    
