## 类图
![](../../../../image/微信截图_20190512153852.png)

## 享元模式
运用共享技术有效地支持大量细粒度的对象。

## 使用场景
如果一个应用程序使用了大量对象，而大量的这些对象造成了很大的存储开销就应该考虑使用。
还有就是对象的大多数状态属于外部状态，如果删除对象的外部状态，那么可以用相对较少的共享对象来取代多组对象，考虑使用。