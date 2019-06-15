## 类图
![](../../../../image/微信截图_20190508185748.png)

## 简单工厂和工厂方法对比
1. 工程类中包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，对于客户端来说，去除了与具体产品的依赖。
2. 克服了简单工厂违背开放-封闭的缺点，保持封装对象创建过程的优点
3. 缺点是添加了额外的工作量
