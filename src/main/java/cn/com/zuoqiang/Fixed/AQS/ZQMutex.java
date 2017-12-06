package cn.com.zuoqiang.Fixed.AQS;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

public class ZQMutex {
    private static class Sync extends AbstractQueuedLongSynchronizer {

        //当状态为0的时候获取锁，CAS操作成功，则state状态为1，
        @Override
        protected boolean tryAcquire(long arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        //释放锁，将同步状态置为0
        protected boolean tryRelease(long arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;       //1的时候表示被占用
        }
    }
    //同步对象完成一系列复杂的操作，我们仅需指向它即可
    private final Sync sync = new Sync();

    //加锁操作，代理到acquire（模板方法）上就行，acquire会调用我们重写的tryAcquire方法
    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    //释放锁，代理到release（模板方法）上就行，release会调用我们重写的tryRelease方法。
    public void unLock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

}
