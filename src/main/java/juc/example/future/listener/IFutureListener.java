package juc.example.future.listener;

public interface IFutureListener<V> {
    void operationCompleted(IFuture<V> future) throws Exception;
}