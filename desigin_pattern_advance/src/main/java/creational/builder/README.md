## 定义
讲一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
用户只需要指定建造的类型就可以得到它们，过程和细节无需关心

## 类型
创建型

## 使用场景
* 一个对象有非常复杂的内部结构（很多属性）
* 想把复杂的对象创建和使用分离

## 优点
* 封装型号，创建和使用分离
* 扩展性好，建造类之间独立，一定程度上解耦

## 缺点
* 产生多余builder对象
* 产品内部发生变化，建造者都要修改，成本较大

## 感觉和链式调用结合比较好

## 案例
StringBuilder
ImmutableSet
org.springframework.beans.factory.support.BeanDefinitionBuilder
SqlSessionFactoryBuilder