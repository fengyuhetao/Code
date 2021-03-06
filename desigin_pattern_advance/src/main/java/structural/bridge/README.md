## 桥接模式
* 将抽象部分与它的具体实现部分分离，使它们可以独立的变化
* 通过组合的方式建立两个类之间的联系，而不是继承
* 结构型

## 适用场景
* 抽象与具体实现之间增加更多的灵活性
* 一个类存在（或多个）独立变化的维度，且这两个（或多个）维度都需要独立进行扩展
* 不希望适用继承，或因为多继承导致系统类的个数剧增

## 优点
* 分离抽象部分及其具体实现部分
* 提高了系统的可扩展性
* 符合开闭原则
* 符合合成-复用原则

## 缺点
* 增加了系统的理解和设计难度
* 需要正确的识别出系统中两个独立变化的维度

## 相关设计模式
* 组合模式，强调不同级别组合，桥接模式强调平行级别上组合
* 适配器模式，二者都是为了让两个东西配合工作，适配器通过改变已有接口，桥接模式通过分离抽象和具体

## 案例
* com.mysql.jdbc.Driver
* DriverManager#registerDriver方法