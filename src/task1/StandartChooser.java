package task1;

import java.util.List;
import java.util.Random;

public class StandartChooser extends AbstractChooser {

    public StandartChooser(List<Option> options){
        super(options);
    }

    @Override
    public Option chooseOption() {
        return options.get(getIndex());
    }

    @Override
    public int getIndex() {
        return (new Random()).nextInt(options.size());
    }
}
