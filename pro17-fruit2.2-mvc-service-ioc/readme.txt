review:

1.最初的做法是：一个请求对应一个Servlet,这样存在的问题servlet太多了
2.把一系列的请求都对应一个Servlet,IndexServlet/AddServlet/EditServlet/DelServlet/UpdateServlet ->合成一个FruitServlet
  通过一个operate的值来决定调用FruitServlet中的哪个方法
  使用的是switch-case
3.在上一个版本中,Servlet中充斥着大量的swtich-case,随着我们的项目业务规模扩大,那么会有很多的Servlet,也就意味着会有很多的switch-case,这是一种代码冗余
  因此,我们在servlet中使用了反射技术,我们规定operate的值和方法名一致,那么接收到operate的值是上面就表明我们需要调用对应的方法进行响应,如果找不到对应的方法,则抛异常
4.在上一个版本中我们使用了反射技术,但是其实还是存在一定的问题:每一个servlet中都有类似的反射技术的代码.因此继续抽取,设计了中央控制类:DispatcherServlet
  DispatcherServlet这个类的工作分为两大部分:
  1.根据url定义到能够处理这个请求的controller组件
    1)从Url中提取servletPath ：/fruit.do -> fruit
    2)根据fruit找到对应的组件:FruitController,这个对应的依据我们存储在applicationContext.xml中
    <bean id="fruit" class="com.atguigu.fruit.controllers.FruitController"/>
    通过DOM技术我们去解析XML文件,在中央控制器中形成一个beanMap容器,用来存放所有的Controller组件
    3)根据获取到的operate的值定义到我们FruitController中需要调用的方法
  2.调用Controller组件中的方法：
    1)获取参数
      获取即将要调用的方法的参数签名信息:Parameter[] parameters = method.getParameters();
      通过parameter.getName()获取参数的名称,
      准备了Object[] parameterValues 这个数组用来存放对应参数的参数值
      另外,我们需要考虑参数的类型问题,需要类型转换的工作.通过parameter.getType()获取参数的类型
    2)执行方法
    Object returnObj = method.invoke(controllerBean,parameterValues);
    3)视图处理
    String returnStr = (String)returnObj;
    if(returnStr.startWith("redirect:")){
        ...
    }else{
        ...
    }

今日内容：
1.再次学习Servlet的初始化方法
2.学习Servlet中的ServletContext和<context-param>
3.什么是业务层
4.IOC
5.过滤器Filter
6.事务管理
7.TransActionManager、ThreadLocal、OpenSessionInViewFilter


