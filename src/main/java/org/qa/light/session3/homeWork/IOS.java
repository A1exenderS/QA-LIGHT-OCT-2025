package org.qa.light.session3.homeWork;

public class IOS implements IPhone {
    private boolean screenLocked = true;

    @Override
    public void callTo(String contact) {
        System.out.println("Call to " + contact + " with IOS");
        System.out.println("Call with " + contact + " is over");
    }


    @Override
    public void unlockScreen() {
        if (screenLocked) {
            screenLocked = false;
            System.out.println("..Unlocking the IOS screen");
        } else {
            System.out.println("Screen is already unlocked");
        }
    }

    @Override
    public void blockScreen() {
        if (!screenLocked) {
            screenLocked = true;
            System.out.println("..Locking the IOS screen");
        } else {
            System.out.println("Screen is already blocked");
        }
    }
}
