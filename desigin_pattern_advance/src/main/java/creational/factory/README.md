## 工厂方法

## 定义
定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法让类的实例化推迟到子类中进行

## 类型
创建型

## 使用场景
* 创建对象需要大量重复代码
* 客户端不依赖于产品类型如何被创建
* 一个类通过子类指定创建那个对象
* 针对同一产品等级

## 优点
* 用户只需要关心产品对应的工厂，无需关心细节
* 加入新产品符合开闭原则，提高可扩展性

## 缺点
* 类的个数过多，增加复杂度
* 增加系统抽象性和理解难度

## 案例
* org.slf4j.ILoggerFactory
* java.util.Collection