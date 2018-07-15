package task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ChooserFactory {

    public AbstractChooser createChooser(String className){
        AbstractChooser result = null;
        try{
            Class clazz = Class.forName(String.format("task1.%s", className));
            Constructor<AbstractChooser> constructor1 = clazz.getConstructor(List.class);
            List<Option> options = new ArrayList<>();

            options.add(new Option("feature1", 777));
            options.add(new Option("feature2", 654));
            options.add(new Option("feature3", 342));
            options.add(new Option("feature4", 321));
         //   options.add(new Option("feature5", 100));
           // options.add(new Option("feature6", 200));
            //options.add(new Option("feature7", 300));
            result = constructor1.newInstance(options);
        } catch (ClassNotFoundException e) {
            System.out.println("There is no class with such name.");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
