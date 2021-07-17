package program;

import modele.Point;

public class Program {
    public static void main(String[] args) {

        Point [] arr=new Point[5];
        for(int i=0;i<5;i++){
            arr[i]=new Point(i+1,(i+1)*2);
            System.out.println(i+"  "+arr[i].toString());
        }

        System.out.println("maxDistPoint "+Point.maxDistPoint(arr));
        System.out.println("maxPrimeter "+Point.maxPerimeter(arr));
        //System.out.println("maxArea "+Point.maxArea(arr));

        System.out.println("Area "+arr[2].Area(arr[1],arr[0]));

    }
}
