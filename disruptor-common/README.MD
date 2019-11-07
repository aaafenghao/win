# disruptor
## 整体概念
###  是一个首尾相接的环，有一个序号，指向下一个可用的序号
###  生产者和消费的速率问题，消费者速度过快的话，消费者阻塞
###  生产者生产完成整个环的时候，会重新开始填充，但是第一个还没有被消费者消费的时候，会等待消费者消费掉之后才会再放数据
###  ringBufferSize 大小定义成2次方便于计算机计算
## RingBuffer
### 基于数组的缓存,环状
## Sequence Sequencer SequenceBarrier
###  通过序号递增的来编号，管理进行交换的数据
### 表示特定事件处理的进度 
### 可以看成AtomicLong类型的字段
### 消除了CPU的伪共享
### Sequencer  --核心   主要实现生产者和消费者之间快速，正确地传递数据的并发算法
### SingProducerSequencer   --单生产者
### MultiProducerSequencer   --多生产者
###  SequenceBarrier  --用来保持生产和消费者之间的平衡关系
## WaitStrategy  --决定消费者如何等待生产者   ---主要是针对消费者线程的
### BlockingWaitStrategy  --最低效的策略，对CPU的消耗最小
### SleepingWaitStrategy  --差不多和上面，对生产者线程影响较小
### YieldWaitStrategy -- 性能是最好的，适合低延迟的系统，推荐使用此策略
## Event  --处理的数据单元
## EnentProcess -- 处理Event,拥有消费者的sequence
### BatchEVentProcess  --回调EventHandler实现的方法
### EventHandler  --消息处理
### WorkProcess  --确保每个序号只被一个消费者消费


# 多生产者和多消费者
多生产者使用ringBuffer的sequence即可
多消费者中，每个消费者的消费进度不一致