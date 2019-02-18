package com.atguigu.juc.study;
@FunctionalInterface
interface Foo{
    public int add(int x,int y);
    public default int div(int x ,int y){
      return   x/y;
    }
    public static  int mul(int x,int y){
        return  x*y;
    }
}

/**
 * 拷贝小括号全落下 写死右箭头 落地大括号
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
    Foo foo=(int x,int y)->{System.out.println("来啦来啦");return x+y;};

        System.out.println(foo.add(4,8));
        System.out.println(foo.div(10,5));
        System.out.println(Foo.mul(10,9));
    }
}
