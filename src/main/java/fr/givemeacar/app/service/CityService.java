@Service
public class CityService {
 
    @Autowired
    private CityRepository cityRepository;
 
    public List<City> list() {
        return cityRepository.findAll();
    }
}