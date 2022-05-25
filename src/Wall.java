import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> list) {
        this.blocks = list;
    }
    public List<Block> differentBlocks() {
        List<Block> singleBlock = new ArrayList<>();
        List<Block> checker = new ArrayList<>(blocks);
        int count = 0;
        while (checker.size() != 0) {
            Block block = checker.remove(count);
            singleBlock.add(block);
            if (block instanceof CompositeBlock) {
                CompositeBlock composite = (CompositeBlock) block;
                checker.addAll(composite.getBlocks());
            }
        }
        return singleBlock;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : differentBlocks()){
            if (block.getColor().equals(color)){
                return Optional.of(block);
            }
        }
        return null;
    }

    @Override
    public List findBlocksByMaterial(String material) {
        List<Block> blocks1 = new ArrayList<>();
        for (Block block : differentBlocks()){
            if (block.getMaterial().equals(material)){
                blocks1.add(block);
            }
        }
        return blocks1;
    }

    @Override
    public int count() {
        return differentBlocks().size();
    }
}
