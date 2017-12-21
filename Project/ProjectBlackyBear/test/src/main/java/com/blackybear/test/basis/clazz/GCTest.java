package com.blackybear.test.basis.clazz;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Description: GC垃圾回收
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class GCTest {
    private static GCTest gcTest = null;
    public static void main(String[] args) {
        testFinalize();
        testWeakReference();
        testPhantomReference();
    }

    private static void testPhantomReference() {
        String str = new String("test");
        ReferenceQueue<String> rq = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(str, rq);
        str = null;
        System.out.println(pr.get());
        System.gc();
        System.runFinalization();
        System.out.println(pr==rq.poll());
    }

    private static void testWeakReference() {
        String str = new String("test");
        WeakReference<String> wr = new WeakReference<String>(str);
        str = null;
        System.out.println(wr.get());
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }

    private static void testFinalize() {
        new GCTest();
        System.gc();
        System.runFinalization();
        gcTest.print();
    }
    public void print() {
        System.out.println("Print");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize is called!");
        gcTest = this;
        super.finalize();
    }
}

