package day07;

// interface
// 상수와 추상 메소드로만 이루어져 있다.

// 서로 관계가 없는 물체들이 상호작용을 하기 위해서
// 사용하는 장치나 사스템
public interface Flyable {
	public abstract void fly();
	// interface에서는 abstract키워드를 빼도 자동으로
	// 추상 메소드로 인식한다.
	// public void fly(); -> (o)
}