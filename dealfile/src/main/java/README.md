## JAVA之ReentrantReadWriteLock代码范例
* 支持公平和非公平锁
* 支持可重入特性，读线程在获取了读锁后还可以获取读锁，写线程在获取了写锁之后既可以再次获取写锁又可以获取读锁
* 此外还允许从写入锁降级为读取锁（操作方式是先获取写入锁， 然后获取读取锁，最后释放写入锁）
* 不允许从读取锁升级到写入锁，因为可能会出现数据不一致问题。

#### 运行结果
```
Writer0 write to current cache!
Reader1 read current cache size is:1
Reader3 read current cache size is:1
Writer2 write to current cache!
Writer4 write to current cache!
Reader5 read current cache size is:3
Writer6 write to current cache!
Reader7 read current cache size is:4
Writer8 write to current cache!
```