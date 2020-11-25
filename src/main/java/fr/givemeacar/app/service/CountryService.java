@Service
public class CountryService {
 
    @Autowired
    private CountryRepository countryRepository;
 
    public List<Country> list() {
        return countryRepository.findAll();
    }
}