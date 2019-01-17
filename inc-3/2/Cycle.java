public class Cycle {
    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{
                new Cycle(), new Unicycle(),
                new Bicycle(), new Tricycle()
        };
        for (Cycle c : cycles) {
            c.ride();
            System.out.println("wheels = " + c.wheels());
/*
            ((Unicycle) c).balance();
            Exception in thread "main" java.lang.ClassCastException: Cycle cannot be cast to Unicycle


*/
        }
    }

    void ride() {
        System.out.println("Cycle.ride()");
    }

    int wheels() {
        return 0;
    }
}

class Unicycle extends Cycle {
    void ride() {
        System.out.println("Unicycle.ride()");
    }

    //@Override
    int wheels() {
        return 1;
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}

class Bicycle extends Cycle {
  //  @Override
    void ride() {
        System.out.println("Bicycle.ride()");
    }

    //@Override
    int wheels() {
        return 2;
    }

    void balance() {
        System.out.println("Bicycle.balance()");
    }
}

class Tricycle extends Cycle {
    //@Override
    void ride() {
        System.out.println("Tricycle.ride()");
    }

    //s@Override
    int wheels() {
        return 3;
    }
}
