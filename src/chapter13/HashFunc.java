package chapter13;

@FunctionalInterface
public interface HashFunc<T> {
    int func(T key);
}
