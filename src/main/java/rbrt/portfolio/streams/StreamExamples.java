package rbrt.portfolio.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import rbrt.portfolio.generics.example.StoreCategory;

public class StreamExamples {
	
	@SuppressWarnings("unused")
	public void streamArrayCreation() {
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
	}
	
	@SuppressWarnings("unused")
	public void streamTypes() {
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
	}
	
	@SuppressWarnings("unused")
	public void streamOperations() {
		Stream<String> stream =  Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		Optional<String> anyElement = stream.findAny();
		Optional<String> firstElement = stream.findFirst();
		
		List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b")).collect(Collectors.toList());
		Optional<String> anyElementS = elements.stream().findAny();
		Optional<String> firstElementS = elements.stream().findFirst();
		
		Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
		Stream<String> twiceModifiedStream = stream.skip(1).map(element -> element.substring(0, 3));
		
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		long size = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().count();
	}
	
	public void collectExamples() {
		List<StoreCategory> categoryList = Arrays.asList(new StoreCategory("1", "potatoes", 2000), new StoreCategory("2", "orange", 1800), 
				new StoreCategory("3", "lemon", 50), new StoreCategory("4", "bread", 800), new StoreCategory("5", "sugar", 500));
		
		List<String> collectorCollection = categoryList.stream().map(StoreCategory::getName).collect(Collectors.toList());
		System.out.println(collectorCollection);
		
		String listToString = categoryList.stream().map(StoreCategory::getName).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(listToString);
		
		double averagePrice = categoryList.stream().collect(Collectors.averagingDouble(StoreCategory::getPrice));
		System.out.println(averagePrice);
		
		double summingPrice = categoryList.stream().collect(Collectors.summingDouble(StoreCategory::getPrice));
		System.out.println(summingPrice);
		
		DoubleSummaryStatistics statistics = categoryList.stream().collect(Collectors.summarizingDouble(StoreCategory::getPrice));
		System.out.println(statistics);
		
		Map<Double, List<StoreCategory>> collectorMapOfLists = categoryList.stream().collect(Collectors.groupingBy(StoreCategory::getPrice));
		System.out.println(collectorMapOfLists);
		
		Set<StoreCategory> unmodifiableSet = categoryList.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
		System.out.println(unmodifiableSet);
	}

}
