package ru.golyakova.metods;

import ru.golyakova.boxs.Box;
import ru.golyakova.boxs.Point3D;
import ru.golyakova.validate.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Metods {
    public static void putPointInBox(Box<? super Point3D> box){
        if(box.isFull()){
            System.out.println("Ошибка: Коробка уже занята!");
        }else{
            System.out.println("Введите координаты трехмерной точки (начало отсчета):");
            System.out.print("Координата X: ");
            double x = Validator.inputDouble();
            System.out.print("Координата Y: ");
            double y = Validator.inputDouble();
            System.out.print("Координата Z: ");
            double z = Validator.inputDouble();
            Point3D point = new Point3D(x,y,z);
            try {
                box.put(point);
                System.out.println("Трехмерная точка " + point + " помещена в коробку");
            }catch (IllegalStateException e){
                System.out.println("Не удалось поместить точку: " + e.getMessage());
            }
        }
    }
    public static <T, P> List<P> processList(List<T> inputList, Function<T,P> function){
        List<P> resultList = new ArrayList<>();
        for(T item : inputList){
            P processedItem = function.apply(item);
            resultList.add(processedItem);
        }
        return resultList;
    }
    public static <T> List<T> filterList(List<T> inputList, Predicate<T> predicate){
        List<T> resultList = new ArrayList<>();
        for(T item : inputList){
            if(predicate.test(item)){
                resultList.add(item);
            }
        }
        return resultList;
    }
    public static <T> T reduceList (List<T> inputList, BinaryOperator<T> reducer, T defaultValue){
        if (inputList == null || inputList.isEmpty()){
            return defaultValue;
        }
        T result = inputList.get(0);
        for(int i = 1; i< inputList.size(); i++){
            result = reducer.apply(result, inputList.get(i));
        }
        return result;
    }
    public static <T, P extends Collection<T>> P collectToList(
            List<T> inputList, Supplier<P> collectFactory, Function<T, Boolean> include){
        P result = collectFactory.get();
        for(T item : inputList){
            if(include.apply(item)){
                result.add(item);
            }
        }
        return result;
    }
}
