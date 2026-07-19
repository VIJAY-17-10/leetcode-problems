import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final Semaphore[] forks = new Semaphore[5];
    private final Semaphore room = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++)
            forks[i] = new Semaphore(1);
    }

    public void wantsToEat(int p,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left = p;
        int right = (p + 1) % 5;

        room.acquire();
        forks[left].acquire();
        forks[right].acquire();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();

        forks[right].release();
        forks[left].release();
        room.release();
    }
}
