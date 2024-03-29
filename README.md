### *这是一个用来改变编码方式的工具，大量使用lambda和函数式，使代码分块编写，使用过spring WebFlux开发过项目，特别喜欢里面的Flux与Mono流式操作编程，又因为java8有了Stream操作集合，在不使用WebFlux模块的情况下，操作单个元素的却没有，于是借鉴WebFlux的Mono自己开发了一套工具，目前工具API继续扩展中；*
## *优点：*
* ①使用lambda实现懒触发；
* ②通过以下操作符只是构建数据走过的桥梁，数据并不会真正的处理；
* ③使用操作符可以使代码分块，并且可以通过onError操作符来进行异常处理，使代码中再也不用处理运行时异常，便于阅读、维护；
* ④操作符易上手、操作简单、灵活高、自由组合，可以满足各种场景；
* ⑤桥梁节点操作符易扩展；
## API说明：
首先使用BridgeBuild.from工厂方法来构建桥梁；
* from(Supplier) 使用生成器来创建Bridge
* map(Function)  使用映射来转换元素
* monitor(Consumer)  使用消费者来监控元素   
* filter(Predicate)  使用断言来过滤桥梁中的元素
* trigger()     触发桥梁中的元素流动
* ifEmptySwitch(Supplier)  当桥梁中的数据为null时，返回生成器生成的元素
* onErrorMapElement(Predicate, Supplier)  当发生的异常符合断言时，返回值使用生成器生成，否则将异常往下传递
