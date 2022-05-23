import java.util.ArrayList;
import java.util.List;

//class created for testing purposes
public class Main {
    public static void main(String[] args) {

        BlockClass block1 = new BlockClass("green", "wood");
        BlockClass block2 = new BlockClass("green", "clay");
        BlockClass block3 = new BlockClass("blue", "metal");
        BlockClass block4 = new BlockClass("green", "plastic");

        List<Block> list = new ArrayList<>();
        Wall wall = new Wall(list);


        list.add(block1);
        list.add(block2);
        list.add(block3);
        list.add(block4);

        System.out.println(wall.findBlocksByMaterial("wood"));
        System.out.println(wall.findBlockByColor("green"));
    }
}
