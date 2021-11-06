abstract class ShapeClass { // abstract method가 한 개 이상 있으므로 abstract class
    abstract void draw(); // 메소드 앞에 abstract 꼭 붙여줘야 함
}

class PointClass extends ShapeClass {
// abstract class의 추상 메소드를 구현할 때는 extends 키워드 사용
// abstract class를 상속받았으면, 반드시 추상 메소드들 구현해줘야 함 (아니면 얘도 abstract class여야 함)
    void draw() {
        System.out.println('+');
    }
}

class RectangleClass extends ShapeClass {
    private int width, height;
    RectangleClass(int width, int height) {
        this.width = width;
        this.height = height;
    }
    void draw() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++)
                System.out.print('+');
            System.out.println();
        }
    }
}

public class AbstractEx {
    public static void main(String[] args) {
        ShapeClass[] shape = new ShapeClass[2];
        // abstract class는 자료형으로는 가능하기 때문에 해당 자료형의 배열도 선언할 수 있음
        // 단, 그 안에 들어가는 객체는 일반 클래스여야 함
        shape[0] = new PointClass();
        shape[1] = new RectangleClass(3, 4);

        for(ShapeClass s : shape) {
        // 반복문에서 차례대로 돌릴 게 shape 배열이니까,
        // 해당 배열의 자료형인 ShapeClass로 임시변수 s를 만들어주고, s에 넣을 배열명 shape를 써주는 것
            s.draw();
            System.out.println();
        }
    }
}