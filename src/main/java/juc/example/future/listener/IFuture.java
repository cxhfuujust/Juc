package juc.example.future.listener;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * The result of an asynchronous operation.
 *
 * @author lixiaohui
 * @param <V> 执行结果的类型参数
 */
public interface IFuture<V> extends Future<V> {
    /**
     * 是否成功
     * @return
     */
    boolean isSuccess();

    /**
     * 立即返回结果(不管Future是否处于完成状态)
     * @return
     */
    V getNow();

    /**
     * 若执行失败时的原因
     * @return
     */
    Throwable cause();

    /**
     * 是否可以取消
     * @return
     */
    boolean isCancellable();

    /**
     * 等待future的完成
     * @return
     * @throws InterruptedException
     */
    IFuture<V> await() throws InterruptedException;

    /**
     * 超时等待future的完成
     * @param timeoutMillis
     * @return
     * @throws InterruptedException
     */
    boolean await(long timeoutMillis) throws InterruptedException;
    boolean await(long timeout, TimeUnit timeunit) throws InterruptedException;

    /**
     * 等待future的完成，不响应中断
     * @return
     */
    IFuture<V> awaitUninterruptibly();

    /**
     * 超时等待future的完成，不响应中断
     * @param timeoutMillis
     * @return
     */
    boolean awaitUninterruptibly(long timeoutMillis);
    boolean awaitUninterruptibly(long timeout, TimeUnit timeunit);

    /**
     * 当future完成时，会通知这些加进来的监听器
     * @param l
     * @return
     */
    IFuture<V> addListener(IFutureListener<V> l);
    IFuture<V> removeListener(IFutureListener<V> l);

}