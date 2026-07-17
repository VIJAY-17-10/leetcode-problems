import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n, num = 1;
    private boolean zero = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer p) throws InterruptedException {
        while (num <= n) {
            if (zero) {
                p.accept(0);
                zero = false;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void even(IntConsumer p) throws InterruptedException {
        while (num <= n) {
            if (!zero && num % 2 == 0) {
                p.accept(num++);
                zero = true;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void odd(IntConsumer p) throws InterruptedException {
        while (num <= n) {
            if (!zero && num % 2 == 1) {
                p.accept(num++);
                zero = true;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
