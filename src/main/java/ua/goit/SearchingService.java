package ua.goit;


import java.util.Collections;
import java.util.List;

public class SearchingService {
    public List<String> search(String query) {
        return Collections.singletonList("Search result 1 for query "+query);
    }
}
