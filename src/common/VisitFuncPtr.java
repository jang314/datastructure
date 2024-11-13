package common;

@FunctionalInterface
public interface VisitFuncPtr<T> {
    void action(T data);
}
