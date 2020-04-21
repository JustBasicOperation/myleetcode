package com.zlfjw.written;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaolinfeng3
 * @description:
 * @create: 2020-03-28 10:22
 **/
public class TxMain {
    public static class Command {
        //
        private String location;
        private String left;
        private String right;
        private int[] dir = new int[2];

        public Command(String location, String left, String right) {
            this.location = location;
            this.left = left;
            this.right = right;
        }

        public String getLocation() {
            return location;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }

        public int[] getDir() {
            return dir;
        }

        public void setDir(int[] dir) {
            this.dir = dir;
        }
    }
    public static class Car{
        private int x;
        private int y;
        private String location;

        public Car(int x, int y, String location) {
            this.x = x;
            this.y = y;
            this.location = location;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "x=" + x +
                    ", y=" + y +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
    public static void carLocation(String[] start,String[] oder){
        String[] str1 = new String[]{
                "E","S","W","N"
        };
//        String[] leftStr = new String[]{
//                "N","E","S","W"
//        };
//        String[] rightStr = new String[]{
//                "S","W","N","E"
//        };
        Map<String, Command> forwardMap = new HashMap<>();
        //偏移量数组
        int[][] array = new int[][]{
                {1,0},{0,-1},{-1,0},{0,1}
        };
        for(int i = 0;i < 4;i++){
            Command command = new Command(str1[i],str1[(i+3)%4],str1[(i+1)%4]);
            //(1,0),(0,-1),(-1,0),(0,1)
            command.setDir(array[i]);
            //key为当前位置，value为对应的forward对象
            forwardMap.put(command.getLocation(),command);
        }
        Car car = new Car(Integer.parseInt(start[0]),Integer.parseInt(start[1]),start[2]);
        for(int i = 0;i < oder.length;i++){
            if(oder[i].equals("L")){
                car.setLocation(forwardMap.get(car.location).getLeft());
            }
            if(oder[i].equals("R")){
                car.setLocation(forwardMap.get(car.location).getRight());
            }
            if(oder[i].equals("M")){
                Command ward = forwardMap.get(car.location);
                int x = ward.getDir()[0];
                int y = ward.getDir()[1];
                car.setX(car.getX() + x);
                car.setY(car.getY() + y);
            }
        }
        System.out.println(car);
    }

    public static void main(String[] args) {
        String[] start = new String[]{
                "1","2","N"
        };
        String[] order = new String[]{
                "L","M","L","M","L","M","L","M","M"
        };
        String[] order1 = new String[]{
                ""
        };
        String[] order2 = new String[]{
                "L","M"
        };
        carLocation(start,order);
    }

}
