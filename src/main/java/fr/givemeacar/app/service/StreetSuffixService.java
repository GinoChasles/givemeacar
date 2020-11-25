@Service
public class StreetSuffixService {
 
    @Autowired
    private StreetSuffixRepository streetSuffixRepository;
 
    public List<StreetSuffix> list() {
        return streetSuffixRepository.findAll();
    }
}