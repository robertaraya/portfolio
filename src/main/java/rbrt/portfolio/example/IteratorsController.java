package rbrt.portfolio.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/example")
public class IteratorsController {
	
	@GetMapping("/list")
    public List<Integer> testSingleton() {
		List<Integer> list = new ArrayList<>();
		List<Integer> distinctList = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			list.add(getRandomNumber(0, 100));
		}
		
		distinctList = list.stream().sorted().distinct().collect(Collectors.toList());
		
    	return distinctList;
    }
	
	@GetMapping("/palindrome/{word}")
    public boolean testPalindrome(@PathVariable String word) {
		return isPalindrome(word);
    }
	
	@GetMapping("/fibonacci")
	public List<String> fibonacciNumbers () {
		List<String> resultList = new ArrayList<String>();
		
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
		.limit(10)
		.map(t -> t[0])
		.forEach(x -> resultList.add(x.toString()));
		
		return resultList;
	}
	
	@GetMapping("/prime/{number}")
	public String isPrimeNumber (@PathVariable Integer number) {
		
		Boolean isPrime = IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
			      .allMatch(n -> number % n != 0);
		
		return isPrime ? "Prime number" : "Not prime number";
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public boolean isPalindrome (String word) {
		return  word.toLowerCase().equals(new StringBuilder(word.toLowerCase()).reverse().toString());
	}
	

}
