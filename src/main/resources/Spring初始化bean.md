
* 1、核心源码注解
```text
public void refresh() throws BeansException, IllegalStateException {
        //防止并发
		synchronized (this.startupShutdownMonitor) {
			// 容器加载前准备,
			prepareRefresh();

			//本质创建BeanFactory,并且完成从文件中获取bean的定义信息,
			// 将bean的信息保存在一个持有类中,此时所有的bean都尚未进行初始化
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// 父类未做任何实现，交由子类操作.
				postProcessBeanFactory(beanFactory);

				//初始化所有实现BeanFactoryPostProcessor接口的类,
				//并且完成对接口方法postProcessBeanFactory的调用
				invokeBeanFactoryPostProcessors(beanFactory);

				//注册所有实现BeanPostProcessor接口的类，
				//并完成实现类的初始化，通过调用beanFactory.getBean完成初始化
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// 父类未做任何实现，交由子类操作.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

                // 初始化所有的 singleton beans
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

			catch (BeansException ex) {
				if (logger.isWarnEnabled()) {
					logger.warn("Exception encountered during context initialization - " +
							"cancelling refresh attempt: " + ex);
				}

				// Destroy already created singletons to avoid dangling resources.
				destroyBeans();

				// Reset 'active' flag.
				cancelRefresh(ex);

				// Propagate exception to caller.
				throw ex;
			}
		}
	}
```