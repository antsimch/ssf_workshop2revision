package sg.edu.nus.iss.ssf_workshop2revision.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.ssf_workshop2revision.model.CONSTANTS;

@Service
public class RNGService {
    
    private int temp;

    public List<Integer> generateRandomNumbers(int number) {
        
        List<Integer> randomNumbers = new ArrayList<>();

        Random random = new Random();

        while (randomNumbers.size() < number) {
            
            temp = random.nextInt(CONSTANTS.MIN_VALUE, CONSTANTS.MAX_VALUE);

            if (!randomNumbers.contains(temp)) {
                randomNumbers.add(temp);
            }
        }
        
        return randomNumbers;
    }
}
